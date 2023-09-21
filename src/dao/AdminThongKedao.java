package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminThongKedao {
	public long Thongke(int thang, int nam) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select SUM(ThanhTien) as 'Tong' from VThongKeHangBan where MONTH(NgayMua) = ? and YEAR(NgayMua) = ? and TinhTrang = 1";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, thang);
		cmd.setInt(2, nam);
		long kq = 0;
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			kq = rs.getLong("Tong");
		}
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public long TongMatHangDaBan(int thang, int nam) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select SUM(SoLuongMua) as 'TongMatHang' from VThongKeHangBan where MONTH(NgayMua) = ? and YEAR(NgayMua) = ? and TinhTrang = 1";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, thang);
		cmd.setInt(2, nam);
		long kq = 0;
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			kq = rs.getLong("TongMatHang");
		}
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
