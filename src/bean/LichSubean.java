package bean;

import java.util.Date;

public class LichSubean {
	private long MaGiay;
	private String TenGiay;
	private int Size;
	private String MauGiay;
	private String Anh;
	private int SoLuong;
	private long Gia;
	private long MaKhachHang;
	private long ThanhTien;
	private Date NgayMua;
	private boolean TinhTrang;

	public LichSubean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LichSubean(long maGiay, String tenGiay, int size, String mauGiay, String anh, int soLuong, long gia,
			long maKhachHang, long thanhTien, Date ngayMua, boolean tinhTrang) {
		super();
		MaGiay = maGiay;
		TenGiay = tenGiay;
		Size = size;
		MauGiay = mauGiay;
		Anh = anh;
		SoLuong = soLuong;
		Gia = gia;
		MaKhachHang = maKhachHang;
		ThanhTien = thanhTien;
		NgayMua = ngayMua;
		TinhTrang = tinhTrang;
	}

	public long getMaGiay() {
		return MaGiay;
	}

	public void setMaGiay(long maGiay) {
		MaGiay = maGiay;
	}

	public String getTenGiay() {
		return TenGiay;
	}

	public void setTenGiay(String tenGiay) {
		TenGiay = tenGiay;
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

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public long getGia() {
		return Gia;
	}

	public void setGia(long gia) {
		Gia = gia;
	}

	public long getMaKhachHang() {
		return MaKhachHang;
	}

	public void setMaKhachHang(long maKhachHang) {
		MaKhachHang = maKhachHang;
	}

	public long getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
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
