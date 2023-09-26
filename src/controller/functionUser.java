package controller;

import javax.servlet.http.HttpServletRequest;

public class functionUser {
	public boolean checkHoTen(String hoTen) {
		if (hoTen.isEmpty() || !hoTen.matches("^[\\p{InCombiningDiacriticalMarks}\\p{IsL}\\s]+$")
				|| hoTen.length() > 30) {
			return false;
		}
		return true;
	}

	public void requestTruongHoTen(String hoTen, HttpServletRequest request) {
		if (hoTen.isEmpty()) {
			request.setAttribute("tenTrong", "Vui lòng nhập họ và tên người mua");
		} else if (!hoTen.matches("^[\\p{InCombiningDiacriticalMarks}\\p{IsL}\\s]+$")) {
			request.setAttribute("tenTrong", "Tên của bạn có kí tự số hoặc kí tự đặc biệt");
		}
	}

	public boolean checkSDT(String SDT) {
		if (SDT.isEmpty() || !SDT.matches("^[0-9]+$") || SDT.length() != 10) {
			return false;
		}
		return true;
	}

	public void requestTruongSDT(String SDT, HttpServletRequest request) {
		if (SDT.isEmpty()) {
			request.setAttribute("SDTTrong", "Vui lòng nhập số điện thoại");
		} else if (!SDT.matches("^[0-9]+$")) {
			request.setAttribute("SDTTrong", "Số điện thoại có kí tự đặc biệt");
		}
		if (SDT.length() != 10) {
			request.setAttribute("SaiSDT", "Số điện thoại có độ dài khác 10 chữ số");
		}
	}

	public boolean checkEmail(String email) {
		boolean checkStarChar = true;
		if (!email.isEmpty() && email.matches(".*@gmail\\.com$") && (email.startsWith("@") || email.startsWith(" "))) {
			checkStarChar = false;
		}
		if (email.isEmpty() || !email.matches(".*@gmail\\.com$") || !checkStarChar) {
			return false;
		}
		return true;
	}

	public void requestTruongEmail(String email, HttpServletRequest request) {
		if (email.isEmpty()) {
			request.setAttribute("emailTrong", "Vui lòng nhập email");
		} else if (!email.matches(".*@gmail\\.com$") || email.startsWith("@") || email.startsWith(" ")) {
			request.setAttribute("emailTrong", "Định dạng email không hợp lệ");
		}
	}

	public boolean checkDiaChi(String diaChi) {
		if (!diaChi.matches("\\d+.*\\/.*\\s+[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+")
				|| !diaChi.matches("\\d+\\s+[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+"))
			return false;
		return true;
	}

	public void requestTruongDiaChi(String diaChi, HttpServletRequest request) {

		if (diaChi.isEmpty()) {
			request.setAttribute("diaChiTrong", "Vui lòng nhập địa chỉ");
		} else if (!diaChi.matches("\\d+.*\\/.*\\s+[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+")
				|| !diaChi.matches("\\d+\\s+[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+,[\\p{L}\\d\\s,]+")) {
			request.setAttribute("diaChiTrong", "Định dạng địa chỉ sai [Số nhà Đường, Phường, Thành Phố]");
		}
	}
}
