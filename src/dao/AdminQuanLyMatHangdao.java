package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Giaybean;

public class AdminQuanLyMatHangdao {

	public long KiemTraTenMatHang(String tenGiay) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from Giay where TenGiay = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tenGiay);
		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			rs.close();
			cmd.close();
			kn.cn.close();
			return 0;
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return 1;
	}

	public long ThemMatHang(Giaybean giay) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "insert into Giay(TenGiay, Gia, MaLoai, MauGiay, Anh, SoLuongTon) values(?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, giay.getTenGiay());
		cmd.setLong(2, giay.getGia());
		cmd.setLong(3, giay.getMaLoai());
		cmd.setString(4, giay.getMauGiay());
		cmd.setString(5, giay.getAnh());
		cmd.setInt(6, (int) giay.getSoLuongTon());
		cmd.executeUpdate();
		sql = "select MAX(MaGiay) as 'Ma' from Giay";
		cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long maGiay = 0;
		if (rs.next()) {
			maGiay = rs.getLong("Ma");
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return maGiay;
	}

	public int XoaChiTietSize(long maGiay) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "delete from ChiTietSize where MaGiay = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maGiay);
		int kq = 0;
		kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int ThemChiTietSize(int size, long maGiay) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "insert into ChiTietSize(Size, MaGiay) values(?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, size);
		cmd.setLong(2, maGiay);
		int kq = 0;
		kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int SuaMatHang(Giaybean giay) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update Giay set TenGiay = ?, Gia = ?, MaLoai = ?, MauGiay = ?, Anh = ?, SoLuongTon = ? where MaGiay = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, giay.getTenGiay());
		cmd.setLong(2, giay.getGia());
		cmd.setLong(3, giay.getMaLoai());
		cmd.setString(4, giay.getMauGiay());
		cmd.setString(5, giay.getAnh());
		cmd.setInt(6, (int) giay.getSoLuongTon());
		cmd.setLong(7, giay.getMaGiay());
		int kq = 0;
		kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}