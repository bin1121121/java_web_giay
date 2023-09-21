package bo;

import java.util.ArrayList;

import bean.GioHangbean;

public class GioHangbo {
	public ArrayList<GioHangbean> dsGioHang = new ArrayList<GioHangbean>();

	public void addGioHang(GioHangbean matHang) throws Exception {
		for (GioHangbean gio : dsGioHang) {
			if (gio.getMaGiay() == matHang.getMaGiay() && gio.getSize() == matHang.getSize()) {
				gio.setSoLuong(gio.getSoLuong() + matHang.getSoLuong());
				return;
			}
		}
		dsGioHang.add(matHang);
	}

	public void suaGioHang(long maGiay, long soLuong) throws Exception {
		int n = dsGioHang.size();
		for (int i = 0; i < n; i++) {
			if (dsGioHang.get(i).getMaGiay() == maGiay) {
				GioHangbean gio = dsGioHang.get(i);
				gio.setSoLuong(soLuong);
				dsGioHang.set(i, gio);
				return;
			}
		}
	}

	public void xoaGioHang(long maGiay) throws Exception {
		for (GioHangbean gio : dsGioHang) {
			if (gio.getMaGiay() == maGiay) {
				dsGioHang.remove(gio);
				return;
			}
		}
	}

	public long tong() throws Exception {
		long tong = 0;
		for (GioHangbean gio : dsGioHang) {
			tong += gio.getThanhTien();
		}
		return tong;
	}
}
