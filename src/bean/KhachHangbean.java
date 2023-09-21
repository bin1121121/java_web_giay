package bean;

public class KhachHangbean {
	private long MaKhachHang;
	private String HoTen;
	private String DiaChi;
	private String SDT;
	private String Email;
	private String TenDN;
	private String Pass;

	public KhachHangbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHangbean(long maKhachHang, String hoTen, String diaChi, String sDT, String email, String tenDN,
			String pass) {
		super();
		MaKhachHang = maKhachHang;
		HoTen = hoTen;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		TenDN = tenDN;
		Pass = pass;
	}

	public KhachHangbean(String hoTen, String diaChi, String sDT, String email, String tenDN, String pass) {
		super();
		HoTen = hoTen;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		TenDN = tenDN;
		Pass = pass;
	}

	public long getMaKhachHang() {
		return MaKhachHang;
	}

	public void setMaKhachHang(long maKhachHang) {
		MaKhachHang = maKhachHang;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTenDN() {
		return TenDN;
	}

	public void setTenDN(String tenDN) {
		TenDN = tenDN;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

}
