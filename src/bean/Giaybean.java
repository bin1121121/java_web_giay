package bean;

public class Giaybean {
	private long MaGiay;
	private String TenGiay;
	private long Gia;
	private long MaLoai;
	private String MauGiay;
	private String Anh;
	private long SoLuongTon;

	public Giaybean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Giaybean(long maGiay, String tenGiay, long gia, long maLoai, String mauGiay, String anh, long soLuongTon) {
		super();
		MaGiay = maGiay;
		TenGiay = tenGiay;
		Gia = gia;
		MaLoai = maLoai;
		MauGiay = mauGiay;
		Anh = anh;
		SoLuongTon = soLuongTon;
	}

	public Giaybean(String tenGiay, long gia, long maLoai, String mauGiay, String anh, long soLuongTon) {
		super();
		TenGiay = tenGiay;
		Gia = gia;
		MaLoai = maLoai;
		MauGiay = mauGiay;
		Anh = anh;
		SoLuongTon = soLuongTon;
	}

	public long getSoLuongTon() {
		return SoLuongTon;
	}

	public void setSoLuongTon(long soLuongTon) {
		SoLuongTon = soLuongTon;
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

	public long getMaLoai() {
		return MaLoai;
	}

	public void setMaLoai(long maLoai) {
		MaLoai = maLoai;
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

}
