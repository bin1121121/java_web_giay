package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.LichSubean;

public class LichSudao {
	public ArrayList<LichSubean> ds = new ArrayList<LichSubean>();

	public ArrayList<LichSubean> getLichSu(long ma, int check) throws Exception {

		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from VLichSuMuaHang where MaKhachHang = ? and TinhTrang= ? order by NgayMua desc";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, ma);
		cmd.setInt(2, check);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long MaGiay = rs.getLong("MaGiay");
			String TenGiay = rs.getString("TenGiay");
			int Size = rs.getInt("Size");
			String MauGiay = rs.getString("MauGiay");
			String Anh = rs.getString("Anh");
			int SoLuong = rs.getInt("SoLuongMua");
			long Gia = rs.getLong("Gia");
			long MaKhachHang = rs.getLong("MaKhachHang");
			long ThanhTien = rs.getLong("ThanhTien");
			Date NgayMua = rs.getDate("NgayMua");
			boolean TinhTrang = rs.getBoolean("TinhTrang");
			System.out.println("check2: " + TinhTrang);
			LichSubean ls = new LichSubean(MaGiay, TenGiay, Size, MauGiay, Anh, SoLuong, Gia, MaKhachHang, ThanhTien,
					NgayMua, TinhTrang);
			ds.add(ls);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return ds;
	}
}
