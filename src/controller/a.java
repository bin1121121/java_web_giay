package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Giaybean;
import bo.AdminQuanLyMatHangbo;
import bo.Giaybo;

public class a {
	public static void main(String[] args) {
		String str1 = "Hello@World";
		String str2 = "@HelloWorld";
		String str3 = "HelloWorld@";
		String str4 = "123";
		String str5 = "123abc123";

		boolean result1 = containsSingleSpecialChar(str1);
		System.out.println("Result 1: " + result1);

		boolean result2 = containsSingleSpecialChar(str2);
		System.out.println("Result 2: " + result2);

		boolean result3 = containsSingleSpecialChar(str3);
		System.out.println("Result 3: " + result3);

		boolean result4 = containsSingleSpecialChar(str4);
		System.out.println("Result 4: " + result4);

		boolean result5 = containsSingleSpecialChar(str5);
		System.out.println("Result 5: " + result5);
	}

	public static boolean containsSingleSpecialChar(String input) {
		// Biểu thức chính quy để kiểm tra chuỗi có đúng một kí tự đặc biệt
		String regex = "^[0-9]+$";

		return input.matches(regex);
	}

}

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

		String txtTenHang = null;
		String txtGia = null;
		String txtSoLuong = null;
		String txtMauSac = null;
		String txtMLoai = null;
		String txtSize = null;
		String anh = null;
		String folder = null;
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
			if (adminQLMHbo.KiemTraTenMatHang(txtTenHang) == 0) {
				request.setAttribute("trungTen", "Mặt hàng này đã có trong danh sách của bạn");
				Giaybo gbo = new Giaybo();
				request.setAttribute("dsGiay", gbo.getDSGiay());
				RequestDispatcher rd = request.getRequestDispatcher("adminQuanLyMatHang.jsp");
				rd.forward(request, response);
			} else if (txtTenHang.isEmpty()
					|| txtTenHang.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/~`\\s].*") || txtGia.isEmpty()
					|| !txtGia.matches("^[0-9]+$") || Integer.parseInt(txtGia) < 1 || txtSoLuong.isEmpty()
					|| Integer.parseInt(txtSoLuong) < 1 || !txtSoLuong.matches("^[0-9]+$") || txtMauSac.isEmpty()
					|| !txtMauSac.matches("^[\\p{InCombiningDiacriticalMarks}\\p{IsL}\\s]+$") || anh == null
					|| dssize.size() == 0) {
				System.out.println(txtGia.matches("\\d+"));
				if (anh == null) {
					request.setAttribute("anhTrong", "Chưa chọn ảnh");
				}
				if (txtTenHang.isEmpty()) {
					request.setAttribute("tenTrong", "Chưa nhập tên hàng");
				} else if (txtTenHang.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/~`\\s].*")) {
					request.setAttribute("tenTrong", "Tên hàng không được có kí tự đặc biệt");
				}
				if (txtGia.isEmpty()) {
					request.setAttribute("giaTrong", "Chưa nhập giá hàng");
				} else if (!txtGia.matches("^[0-9]+$")) {
					request.setAttribute("giaTrong", "Giá của mặt hàng không được có kí tự đặc biệt");
				} else if (Integer.parseInt(txtGia) < 1) {
					request.setAttribute("giaTrong", "Giá của mặt hàng không được âm");
				}
				if (txtSoLuong.isEmpty()) {
					request.setAttribute("soLuongTrong", "Chưa nhập số lượng");
				} else if (!txtSoLuong.matches("^[0-9]+$")) {
					request.setAttribute("soLuongTrong", "Số lượng mặt hàng không được có kí tự đặc biệt");
				} else if (Integer.parseInt(txtSoLuong) < 1) {
					request.setAttribute("soLuongTrong", "Số lượng mặt hàng phải lớn hơn 1");
				}

				if (txtMauSac.isEmpty()) {
					request.setAttribute("mauSacTrong", "Chưa nhập màu sắc");
				} else if (!txtMauSac.matches("^[\\p{InCombiningDiacriticalMarks}\\p{IsL}\\s]+$")) {
					request.setAttribute("mauSacTrong", "Màu sắc không được có kí tự số hoặc kí tự đặc biệt");
				}
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
