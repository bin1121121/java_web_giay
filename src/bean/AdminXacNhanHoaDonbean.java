package bean;

import java.util.Date;

public class AdminXacNhanHoaDonbean {
	private long MaHoaDon;
	private String HoTen;
	private Date NgayMua;
	private boolean TinhTrang;
	private long TongTien;

	public AdminXacNhanHoaDonbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getTongTien() {
		return TongTien;
	}

	public void setTongTien(long tongTien) {
		TongTien = tongTien;
	}

	public AdminXacNhanHoaDonbean(long maHoaDon, String hoTen, Date ngayMua, boolean tinhTrang, long tongTien) {
		super();
		MaHoaDon = maHoaDon;
		HoTen = hoTen;
		NgayMua = ngayMua;
		TinhTrang = tinhTrang;
		TongTien = tongTien;
	}

	public long getMaHoaDon() {
		return MaHoaDon;
	}

	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public Date getNgayMua() {
		return NgayMua;
	}

	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}

	public boolean isTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		TinhTrang = tinhTrang;
	}

}
