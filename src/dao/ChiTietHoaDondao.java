package dao;

import java.sql.PreparedStatement;

public class ChiTietHoaDondao {
	public int addChiTietHoaDon(long maHoaDon, long maGiay, int soLuongMua, boolean tinhTrang, int size)
			throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "insert into ChiTietHoaDon(MaHoaDon, MaGiay, SoLuongMua, TinhTrang, Size) values(?,?,?,?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// truyen tham so
		cmd.setLong(1, maHoaDon);
		cmd.setLong(2, maGiay);
		cmd.setInt(3, soLuongMua);
		cmd.setBoolean(4, tinhTrang);
		cmd.setInt(5, size);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
