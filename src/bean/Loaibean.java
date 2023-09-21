package bean;

public class Loaibean {
	private long MaLoai;
	private String TenLoai;

	public Loaibean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loaibean(long maLoai, String tenLoai) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
	}

	public long getMaLoai() {
		return MaLoai;
	}

	public void setMaLoai(long maLoai) {
		MaLoai = maLoai;
	}

	public String getTenLoai() {
		return TenLoai;
	}

	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}

}
