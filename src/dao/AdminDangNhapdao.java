package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.AdminDangNhapbean;

public class AdminDangNhapdao {
	public AdminDangNhapbean getAdmin(String tk, String mk) throws Exception {
		AdminDangNhapbean admin = null;
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from DangNhap where TenDN = ? and Pass = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tk);
		cmd.setString(2, mk);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			String tendn = rs.getString("TenDN");
			String pass = rs.getString("Pass");
			String hoten = rs.getString("HoTen");
			String sdt = rs.getString("SDT");
			String soTaiKhoan = rs.getString("SoTaiKhoan");
			String diaChi = rs.getString("DiaChi");
			String email = rs.getString("Email");
			admin = new AdminDangNhapbean(tendn, pass, hoten, sdt, soTaiKhoan, diaChi, email);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return admin;
	}
}
