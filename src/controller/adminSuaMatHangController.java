package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Servlet implementation class adminSuaMatHangController
 */
@WebServlet("/adminSuaMatHangController")
public class adminSuaMatHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminSuaMatHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "GiayThem";
		response.getWriter().println(dirUrl1);

		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			String maGiay = null;
			String txtTenHang = null;
			String txtGia = null;
			String txtSoLuong = null;
			String txtMauSac = null;
			String txtMLoai = null;
			String txtSize = null;
			String anh = null;
			String folder = null;
			String txtanh = null;
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
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("maGiay"))
						maGiay = fileItem.getString("UTF-8");
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
					if (tentk.equals("txtanh"))
						txtanh = fileItem.getString("UTF-8");
					folder = "GiayThem\\" + anh;
					System.out.println("ok bla: " + folder);

					if (tentk.equals("txtSize")) {
						txtSize = fileItem.getString("UTF-8");
						dssize.add(Integer.parseInt(txtSize));
					}
				}
			}
			try {
				System.out.println("ok123: " + txtanh);
				AdminQuanLyMatHangbo adminQLMHbo = new AdminQuanLyMatHangbo();

				Giaybean giay = new Giaybean(Long.parseLong(maGiay), txtTenHang, Long.parseLong(txtGia),
						Long.parseLong(txtMLoai), txtMauSac, anh == null ? txtanh : folder, Long.parseLong(txtSoLuong));
				adminQLMHbo.SuaMatHang(giay);
				adminQLMHbo.XoaChiTietSize(Long.parseLong(maGiay));
				for (int cts : dssize) {
					adminQLMHbo.ThemChiTietSize(cts, Long.parseLong(maGiay));
				}
				/*
				 * long ma = 0; ma = adminQLMHbo.ThemMatHang(giay); for (int s : dssize) {
				 * adminQLMHbo.ThemChiTietSize(s, ma); }
				 */

				response.sendRedirect("adminQuanLyMatHangController");
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

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
