package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.AdminXacNhanMuaHangbean;

public class AdminXacNhanMuahangdao {
	public ArrayList<AdminXacNhanMuaHangbean> getDSXacNhan() throws Exception {
		ArrayList<AdminXacNhanMuaHangbean> ds = new ArrayList<AdminXacNhanMuaHangbean>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from VXacNhanMuaHang where TinhTrang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setBoolean(1, false);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {

			long MaChiTieHD = rs.getLong("MaChiTietHD");
			String HoTen = rs.getString("HoTen");
			String TenGiay = rs.getString("TenGiay");
			long Gia = rs.getLong("Gia");
			int SoLuongMua = rs.getInt("SoLuongMua");
			System.out.println("alo daooooooooo");
			long ThanhTien = rs.getLong("ThanhTien");

			boolean TinhTrang = rs.getBoolean("TinhTrang");
			int Size = rs.getInt("Size");
			String MauGiay = rs.getString("MauGiay");
			String Anh = rs.getString("Anh");
			Date NgayMua = rs.getDate("NgayMua");
			long MaGiay = rs.getLong("MaGiay");
			long MaHoaDon = rs.getLong("MaHoaDon");
			ds.add(new AdminXacNhanMuaHangbean(MaChiTieHD, HoTen, TenGiay, Gia, SoLuongMua, ThanhTien, TinhTrang, Size,
					MauGiay, Anh, NgayMua, MaGiay, MaHoaDon));
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return ds;
	}

	public int XacNhanCTHD(long maCTHD) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update ChiTietHoaDon set TinhTrang = 'true' where MaChiTietHD = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maCTHD);

		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int updateSoLuongTon(int soLuongMua, long maGiay) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update Giay set SoLuongTon = SoLuongTon - ? where MaGiay = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, soLuongMua);
		cmd.setLong(2, maGiay);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public long checkHD1(long maHoaDon) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select MaHoaDon,COUNT(MaChiTietHD) as N'Tong' from ChiTietHoaDon where MaHoaDon = ? group by MaHoaDon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHoaDon);
		ResultSet rs = cmd.executeQuery();
		long MaHoaDon = 0;
		long Tong = 0;
		if (rs.next()) {
			maHoaDon = rs.getLong("MaHoaDon");
			Tong = rs.getLong("Tong");
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return Tong;
	}

	public int checkHD2(long maHoaDon, long Tong) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql2 = "select MaHoaDon,COUNT(MaChiTietHD) as N'Tong' from ChiTietHoaDon where TinhTrang = 1 and MaHoaDon = ? group by MaHoaDon";
		PreparedStatement cmd2 = kn.cn.prepareStatement(sql2);
		cmd2.setLong(1, maHoaDon);
		ResultSet rs2 = cmd2.executeQuery();

		long TongTT = 0;
		if (rs2.next()) {
			maHoaDon = rs2.getLong("MaHoaDon");
			TongTT = rs2.getLong("Tong");
		}
		int kq = 0;
		if (Tong == TongTT) {
			kq = 1;
		}
		rs2.close();
		cmd2.close();
		kn.cn.close();
		return kq;
	}

	public int updateHD(long maHoaDon) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update HoaDon set TinhTrang = 1 where MaHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHoaDon);
		int kq = 0;
		kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
