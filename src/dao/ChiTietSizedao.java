package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ChiTietSizebean;

public class ChiTietSizedao {
	public ArrayList<Integer> getDSSize() throws Exception {
		ArrayList<Integer> dsSize = new ArrayList<Integer>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select DISTINCT Size from ChiTietSize";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int size = rs.getInt("Size");
			dsSize.add(size);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return dsSize;
	}

	public ArrayList<Integer> getSizeMatHang(long magiay) throws Exception {
		ArrayList<Integer> dsSize = new ArrayList<Integer>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from ChiTietSize where MaGiay =?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, magiay);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int size = rs.getInt("Size");
			dsSize.add(size);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return dsSize;
	}

	public ArrayList<ChiTietSizebean> getDSSizeCuaAD(long magiay) throws Exception {
		ArrayList<ChiTietSizebean> dsSize = new ArrayList<ChiTietSizebean>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from ChiTietSize where MaGiay =?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, magiay);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maSize = rs.getLong("MaSize");
			int size = rs.getInt("Size");
			long MaGiay = rs.getLong("MaGiay");
			dsSize.add(new ChiTietSizebean(maSize, size, MaGiay));
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return dsSize;
	}

	public int xoaSize(long maGiay) throws Exception {
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
}
