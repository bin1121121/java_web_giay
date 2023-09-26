package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Giaybean;
import bo.AdminQuanLyMatHangbo;
import bo.Giaybo;

/**
 * Servlet implementation class adminThemMatHangController
 */
@WebServlet("/adminThemMatHangController")
public class adminThemMatHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminThemMatHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// gửi dữ liệu lên kiểu unicode
		response.setCharacterEncoding("utf-8");// nhận dữ liệu về kiểu unicode

		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "GiayThem";
		response.getWriter().println(dirUrl1);

		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control

			String txtTenHang = "";
			String txtGia = "";
			String txtSoLuong = "";
			String txtMauSac = "";
			String txtMLoai = "";
			String txtSize = "";
			String anh = null;
			String folder = null;
			double sizeImage = 0;
			ArrayList<Integer> dssize = new ArrayList<Integer>();

			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "GiayThem";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file

						try {
							fileItem.write(file);// lưu file
							anh = nameimg;
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
							sizeImage = ((double) file.length() / 1048576);
							sizeImage = Math.floor(sizeImage * 10) / 10;
							System.out.println("Size: " + anh);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();

					if (tentk.equals("txtTenHang"))
						txtTenHang = fileItem.getString("UTF-8");
					if (tentk.equals("txtGia"))
						txtGia = fileItem.getString("UTF-8");
					if (tentk.equals("txtSoLuong"))
						txtSoLuong = fileItem.getString("UTF-8");
					if (tentk.equals("txtMauSac"))
						txtMauSac = fileItem.getString("UTF-8");
					if (tentk.equals("txtMaLoai"))
						txtMLoai = fileItem.getString("UTF-8");
					folder = "GiayThem\\" + anh;

					if (tentk.equals("txtSize")) {
						txtSize = fileItem.getString("UTF-8");
						dssize.add(Integer.parseInt(txtSize));
					}
				}
			}
			try {

				AdminQuanLyMatHangbo adminQLMHbo = new AdminQuanLyMatHangbo();
				functionAdmin function = new functionAdmin();

				boolean duoiAnh = function.checkDuoiAnh(anh);
				boolean checkTenSP = function.checkTenSanPham(txtTenHang);
				boolean checkGia = function.checkGia(txtGia);
				boolean checkSoLuong = function.checkSoLuong(txtSoLuong);
				boolean checkMauSac = function.checkMauSac(txtMauSac);
				if (adminQLMHbo.KiemTraTenMatHang(txtTenHang) == 0) {
					request.setAttribute("trungTen", "Mặt hàng này đã có trong danh sách của bạn");
					Giaybo gbo = new Giaybo();
					request.setAttribute("dsGiay", gbo.getDSGiay());
					RequestDispatcher rd = request.getRequestDispatcher("adminQuanLyMatHang.jsp");
					rd.forward(request, response);
				} else if (!checkTenSP || !checkGia || !checkSoLuong || !checkMauSac || sizeImage > 5 || !duoiAnh
						|| dssize.size() == 0) {
					System.out.println("1");
					if (!duoiAnh) {
						request.setAttribute("anhTrong", "Định dạng ảnh không đúng");
					} else if (sizeImage > 5) {
						request.setAttribute("anhTrong", "Kích thước của ảnh quá lớn");
					}
					function.requestTruongTenSP(txtTenHang, request);
					function.requestTruongGia(txtGia, request);
					function.requestTruongSoLuong(txtSoLuong, request);
					function.requestTruongMauSac(txtMauSac, request);
					if (dssize.size() == 0) {
						request.setAttribute("danhSachTrong", "Chưa chọn size");
					}
					Giaybo gbo = new Giaybo();
					request.setAttribute("dsGiay", gbo.getDSGiay());
					RequestDispatcher rd = request.getRequestDispatcher("adminQuanLyMatHang.jsp");
					rd.forward(request, response);
				} else {
					Giaybean giay = new Giaybean(txtTenHang, Long.parseLong(txtGia), Long.parseLong(txtMLoai),
							txtMauSac, folder, Long.parseLong(txtSoLuong));

					long ma = 0;
					ma = adminQLMHbo.ThemMatHang(giay);
					for (int s : dssize) {
						adminQLMHbo.ThemChiTietSize(s, ma);
					}

				}
				response.sendRedirect("adminQuanLyMatHangController");
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}

//
//	void requestTruongAnh(String anh, double imageSize, HttpServletRequest request) {
//
//		if (anh == null) {
//			request.setAttribute("anhTrong", "Chưa chọn ảnh");
//		} else if (imageSize > 5) {
//			request.setAttribute("anhTrong", "Kích thước của ảnh quá lớn");
//		}
//	}

//	boolean checkTenSanPham(String tenSP) {
//		
//	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
