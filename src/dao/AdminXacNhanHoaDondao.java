package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.AdminXacNhanHoaDonbean;
import bean.AdminXacNhanMuaHangbean;

public class AdminXacNhanHoaDondao {
	public ArrayList<AdminXacNhanHoaDonbean> getDSXNHoaDon() throws Exception {
		ArrayList<AdminXacNhanHoaDonbean> ds = new ArrayList<AdminXacNhanHoaDonbean>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select MaHoaDon, HoTen, NgayMua, TinhTrang, sum(ThanhTien) as 'TongTien' "
				+ "from VXacNhanHoaDon where TinhTrang = 0 and  TT = 0 group by MaHoaDon, HoTen, NgayMua, TinhTrang";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long MaHoaDon = rs.getLong("MaHoaDon");
			String HoTen = rs.getString("HoTen");
			Date NgayMua = rs.getDate("NgayMua");
			boolean TinhTrang = rs.getBoolean("TinhTrang");
			long TongTien = rs.getLong("TongTien");
			ds.add(new AdminXacNhanHoaDonbean(MaHoaDon, HoTen, NgayMua, TinhTrang, TongTien));
		}

		rs.close();
		cmd.close();
		kn.cn.close();
		return ds;
	}

	public int updateHoaDon(long maHD) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update HoaDon set TinhTrang = 1 where MaHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHD);
		cmd.executeUpdate();
		updateSoLuongTon(maHD);
		sql = "update ChiTietHoaDon set TinhTrang = 1 where MaHoaDon = ?";
		cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHD);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	void updateSoLuongTon(long maHD) throws Exception {
		ArrayList<AdminXacNhanMuaHangbean> ds = new ArrayList<AdminXacNhanMuaHangbean>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select MaGiay, SoLuongMua from ChiTietHoaDon where MaHoaDon = ? and TinhTrang = 0";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHD);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maGiay = rs.getLong("MaGiay");
			int SLMua = rs.getInt("SoLuongMua");
			ds.add(new AdminXacNhanMuaHangbean(SLMua, maGiay));
		}
		for (AdminXacNhanMuaHangbean mh : ds) {
			sql = "update Giay set SoLuongTon = SoLuongTon - ? where MaGiay = ?";
			cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, mh.getSoLuongMua());
			cmd.setLong(2, mh.getMaGiay());
			cmd.executeUpdate();
		}
	}

}
