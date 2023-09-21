package bo;

import java.util.Date;

import dao.HoaDondao;

public class HoaDonbo {
	HoaDondao hddao = new HoaDondao();

	public int addHoaDon(long maKH, Date ngayMua, boolean tinhTrang) throws Exception {
		return hddao.addHoaDon(maKH, ngayMua, tinhTrang);
	}

	public long getMaHoaDon() throws Exception {
		return hddao.getMaHoaDon();
	}
}
