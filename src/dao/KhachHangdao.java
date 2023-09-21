package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.KhachHangbean;

public class KhachHangdao {
	public KhachHangbean getKH(String tendn, String mk) throws Exception {
		KetNoidao kn = new KetNoidao();
		KhachHangbean kh = null;
		kn.KetNoi();
		String sql = "select * from KhachHang where TenDN = ? and Pass = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, mk);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			long maKhachHang = rs.getLong("MaKhachHang");
			String hoTen = rs.getString("HoTen");
			String diaChi = rs.getString("DiaChi");
			String sDT = rs.getString("SDT");
			String email = rs.getString("Email");
			String tenDN = rs.getString("TenDN");
			String pass = rs.getString("Pass");
			kh = new KhachHangbean(maKhachHang, hoTen, diaChi, sDT, email, tenDN, pass);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return kh;
	}

	public int addKH(KhachHangbean kh) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from KhachHang where TenDN = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, kh.getTenDN());
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			return 0;
		}
		sql = "insert into KhachHang(HoTen, DiaChi, SDT, Email, TenDN, Pass) values(?, ?, ?, ?, ?, ?)";
		cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, kh.getHoTen());
		cmd.setString(2, kh.getDiaChi());
		cmd.setString(3, kh.getSDT());
		cmd.setString(4, kh.getEmail());
		cmd.setString(5, kh.getTenDN());
		cmd.setString(6, kh.getPass());
		int kq = cmd.executeUpdate();
		rs.close();
		cmd.close();
		kn.cn.close();

		return kq;
	}
}
