package bean;

public class GioHangbean {
	private long MaGiay;
	private String TenGiay;
	private long Gia;
	private String MauGiay;
	private int Size;
	private long SoLuong;
	private long ThanhTien;
	private String Anh;

	public GioHangbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GioHangbean(long maGiay, String tenGiay, long gia, String mauGiay, int size, long soLuong, String anh) {
		super();
		MaGiay = maGiay;
		TenGiay = tenGiay;
		Gia = gia;
		MauGiay = mauGiay;
		Size = size;
		SoLuong = soLuong;
		Anh = anh;
	}

	public String getAnh() {
		return Anh;
	}

	public void setAnh(String anh) {
		Anh = anh;
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

	public long getGia() {
		return Gia;
	}

	public void setGia(long gia) {
		Gia = gia;
	}

	public String getMauGiay() {
		return MauGiay;
	}

	public void setMauGiay(String mauGiay) {
		MauGiay = mauGiay;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	public long getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}

	public long getThanhTien() {
		return getSoLuong() * getGia();
	}

	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}

}
