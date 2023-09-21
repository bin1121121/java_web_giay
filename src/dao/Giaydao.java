package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Giaybean;

public class Giaydao {
	public ArrayList<Giaybean> getDSGiay() throws Exception {
		ArrayList<Giaybean> dsGiay = new ArrayList<Giaybean>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from Giay";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maGiay = rs.getLong("MaGiay");
			String tenGiay = rs.getString("TenGiay");
			long gia = rs.getLong("Gia");
			long maLoai = rs.getLong("MaLoai");
			String mauGiay = rs.getString("MauGiay");
			String anh = rs.getString("Anh");
			long soLuongTon = rs.getLong("SoLuongTon");
			dsGiay.add(new Giaybean(maGiay, tenGiay, gia, maLoai, mauGiay, anh, soLuongTon));
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return dsGiay;
	}

	public Giaybean getMatHang(long magiay) throws Exception {
		Giaybean Giay = null;
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from Giay where MaGiay =?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, magiay);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			long maGiay = rs.getLong("MaGiay");
			String tenGiay = rs.getString("TenGiay");
			long gia = rs.getLong("Gia");
			long maLoai = rs.getLong("MaLoai");
			String mauGiay = rs.getString("MauGiay");
			String anh = rs.getString("Anh");
			long soLuongTon = rs.getLong("SoLuongTon");
			Giay = new Giaybean(maGiay, tenGiay, gia, maLoai, mauGiay, anh, soLuongTon);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return Giay;
	}

	public ArrayList<Giaybean> getTimSize(int size) throws Exception {
		ArrayList<Giaybean> dsGiay = new ArrayList<Giaybean>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select Giay.MaGiay, TenGiay, Gia, MaLoai, MauGiay, Anh, SoLuongTon from Giay join ChiTietSize on Giay.MaGiay = ChiTietSize.MaGiay where Size = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, size);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maGiay = rs.getLong("MaGiay");
			String tenGiay = rs.getString("TenGiay");
			long gia = rs.getLong("Gia");
			long maLoai = rs.getLong("MaLoai");
			String mauGiay = rs.getString("MauGiay");
			String anh = rs.getString("Anh");
			long soLuongTon = rs.getLong("SoLuongTon");
			dsGiay.add(new Giaybean(maGiay, tenGiay, gia, maLoai, mauGiay, anh, soLuongTon));
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return dsGiay;
	}

	public ArrayList<String> getDSMauGiay() throws Exception {
		ArrayList<String> dsMauGiay = new ArrayList<String>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select DISTINCT MauGiay from Giay";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String mauGiay = rs.getString("MauGiay");
			dsMauGiay.add(mauGiay);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return dsMauGiay;
	}

	public int xoaGiay(long maGiay) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "delete from Giay where MaGiay = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maGiay);
		int kq = 0;
		kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
