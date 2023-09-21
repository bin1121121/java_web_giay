package bean;

import java.util.Date;

public class AdminXacNhanMuaHangbean {
	private long MaChiTieHD;
	private String HoTen;
	private String TenGiay;
	private long Gia;
	private int SoLuongMua;
	private long ThanhTien;
	private boolean TinhTrang;
	private int Size;
	private String MauGiay;
	private String Anh;
	private Date NgayMua;
	private long MaGiay;
	private long MaHoaDon;

	public AdminXacNhanMuaHangbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminXacNhanMuaHangbean(int soLuongMua, long maGiay) {
		super();
		SoLuongMua = soLuongMua;
		MaGiay = maGiay;
	}

	public AdminXacNhanMuaHangbean(long maChiTieHD, String hoTen, String tenGiay, long gia, int soLuongMua,
			long thanhTien, boolean tinhTrang, int size, String mauGiay, String anh, Date ngayMua, long maGiay,
			long maHoaDon) {
		super();
		MaChiTieHD = maChiTieHD;
		HoTen = hoTen;
		TenGiay = tenGiay;
		Gia = gia;
		SoLuongMua = soLuongMua;
		ThanhTien = thanhTien;
		TinhTrang = tinhTrang;
		Size = size;
		MauGiay = mauGiay;
		Anh = anh;
		NgayMua = ngayMua;
		MaGiay = maGiay;
		MaHoaDon = maHoaDon;
	}

	public long getMaHoaDon() {
		return MaHoaDon;
	}

	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}

	public long getMaGiay() {
		return MaGiay;
	}

	public void setMaGiay(long maGiay) {
		MaGiay = maGiay;
	}

	public long getMaChiTieHD() {
		return MaChiTieHD;
	}

	public void setMaChiTieHD(long maChiTieHD) {
		MaChiTieHD = maChiTieHD;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getTenGiay() {
		return TenGiay;
	}

	public void setTenGiay(String tenGiay) {
		TenGiay = tenGiay;
	}

	public long getGia() {
		return Gia;
	}

	public void setGia(long gia) {
		Gia = gia;
	}

	public int getSoLuongMua() {
		return SoLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}

	public long getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}

	public boolean isTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		TinhTrang = tinhTrang;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	public String getMauGiay() {
		return MauGiay;
	}

	public void setMauGiay(String mauGiay) {
		MauGiay = mauGiay;
	}

	public String getAnh() {
		return Anh;
	}

	public void setAnh(String anh) {
		Anh = anh;
	}

	public Date getNgayMua() {
		return NgayMua;
	}

	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}

}
