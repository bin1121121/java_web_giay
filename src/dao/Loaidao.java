package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Loaibean;

public class Loaidao {
	public ArrayList<Loaibean> getDSLoai() throws Exception {
		ArrayList<Loaibean> dsLoai = new ArrayList<Loaibean>();
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from Loai";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maLoai = rs.getLong("MaLoai");
			String tenLoai = rs.getString("TenLoai");
			dsLoai.add(new Loaibean(maLoai, tenLoai));
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return dsLoai;
	}
}
