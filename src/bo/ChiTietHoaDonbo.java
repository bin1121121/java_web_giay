package bo;

import dao.ChiTietHoaDondao;

public class ChiTietHoaDonbo {
	ChiTietHoaDondao cthddao = new ChiTietHoaDondao();

	public int addChiTietHoaDon(long maHoaDon, long maGiay, int soLuongMua, boolean tinhTrang, int size)
			throws Exception {
		return cthddao.addChiTietHoaDon(maHoaDon, maGiay, soLuongMua, tinhTrang, size);
	}
}
