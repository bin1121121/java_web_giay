package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class HoaDondao {
	public int addHoaDon(long maKH, Date ngayMua, boolean tinhTrang) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "insert into HoaDon(MaKhachHang, NgayMua, TinhTrang) values(?, ?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maKH);
		java.sql.Date ngaysql = new java.sql.Date(ngayMua.getTime());
		cmd.setDate(2, ngaysql);
		cmd.setBoolean(3, tinhTrang);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public long getMaHoaDon() throws Exception {
		KetNoidao kn = new KetNoidao();
		long maHD = 0;
		kn.KetNoi();
		String sql = "select MAX(MaHoaDon) as maHD from HoaDon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			maHD = rs.getLong("maHD");
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return maHD;
	}
}
