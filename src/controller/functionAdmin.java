package controller;

import javax.servlet.http.HttpServletRequest;

public class functionAdmin {
	public boolean checkDuoiAnh(String anh) {
		System.out.println(anh);
		if (anh == null || anh.isEmpty())
			return false;
		String[] duoiAnh = anh.split("\\.");
		System.out.println(duoiAnh.length);
		System.out.println(duoiAnh[1]);
		if (duoiAnh[1].equals("jpg") || duoiAnh[1].equals("png") || duoiAnh[1].equals("gif"))
			return true;
		return false;
	}

	public void requestTruongTenSP(String tenHang, HttpServletRequest request) {

		if (tenHang.isEmpty()) {
			request.setAttribute("tenTrong", "Chưa nhập tên hàng");
		} else if (tenHang.length() > 100) {
			request.setAttribute("tenTrong", "Tên hàng không được dài quá");
		} else if (tenHang.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/~`\\s].*")) {
			request.setAttribute("tenTrong", "Tên hàng không được có kí tự đặc biệt");
		}
	}

	public boolean checkTenSanPham(String tenSP) {
		if (tenSP.isEmpty() || tenSP.length() > 100
				|| tenSP.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/~`\\s].*")) {
			return false;
		}
		return true;
	}

	public boolean checkGia(String gia) {
		if (gia.isEmpty() || !gia.matches("^[0-9]+$") || Integer.parseInt(gia) < 1) {
			return false;
		}
		return true;
	}

	public void requestTruongGia(String gia, HttpServletRequest request) {
		if (gia.isEmpty()) {
			request.setAttribute("giaTrong", "Chưa nhập giá hàng");
		} else if (!gia.matches("^[0-9]+$")) {
			request.setAttribute("giaTrong", "Giá của mặt hàng không được có kí tự đặc biệt");
		} else if (Integer.parseInt(gia) < 1) {
			request.setAttribute("giaTrong", "Chưa có giá cho mặt hàng");
		}
	}

	public boolean checkSoLuong(String soLuong) {
		if (soLuong.isEmpty() || !soLuong.matches("^[0-9]+$") || Integer.parseInt(soLuong) < 1) {
			return false;
		}
		return true;
	}

	public void requestTruongSoLuong(String SoLuong, HttpServletRequest request) {
		if (SoLuong.isEmpty()) {
			request.setAttribute("soLuongTrong", "Chưa nhập số lượng");
		} else if (!SoLuong.matches("^[0-9]+$")) {
			request.setAttribute("soLuongTrong", "Số lượng mặt hàng không được có kí tự đặc biệt");
		} else if (Integer.parseInt(SoLuong) < 1) {
			request.setAttribute("soLuongTrong", "Chưa có số lượng cho mặt hàng");
		}
	}

	public boolean checkMauSac(String mauSac) {
		if (mauSac.isEmpty() || !mauSac.matches("^[\\p{InCombiningDiacriticalMarks}\\p{IsL}\\s]+$")) {
			return false;
		}
		return true;
	}

	public void requestTruongMauSac(String mauSac, HttpServletRequest request) {
		if (mauSac.isEmpty()) {
			request.setAttribute("mauSacTrong", "Chưa nhập màu sắc");
		} else if (!mauSac.matches("^[\\p{InCombiningDiacriticalMarks}\\p{IsL}\\s]+$")) {
			request.setAttribute("mauSacTrong", "Màu sắc không được có kí tự số hoặc kí tự đặc biệt");
		}
	}
}
