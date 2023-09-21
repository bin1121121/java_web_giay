package bean;

public class AdminDangNhapbean {
	private String TenDN;
	private String Pass;
	private String HoTen;
	private String SĐT;
	private String SoTaiKhoan;
	private String DiaChi;
	private String Email;

	public AdminDangNhapbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDangNhapbean(String tenDN, String pass, String hoTen, String sĐT, String soTaiKhoan, String diaChi,
			String email) {
		super();
		TenDN = tenDN;
		Pass = pass;
		HoTen = hoTen;
		SĐT = sĐT;
		SoTaiKhoan = soTaiKhoan;
		DiaChi = diaChi;
		Email = email;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getSĐT() {
		return SĐT;
	}

	public void setSĐT(String sĐT) {
		SĐT = sĐT;
	}

	public String getSoTaiKhoan() {
		return SoTaiKhoan;
	}

	public void setSoTaiKhoan(String soTaiKhoan) {
		SoTaiKhoan = soTaiKhoan;
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
