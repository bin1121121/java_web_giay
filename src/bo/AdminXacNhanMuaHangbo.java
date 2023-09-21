package bo;

import java.util.ArrayList;

import bean.AdminXacNhanMuaHangbean;
import dao.AdminXacNhanMuahangdao;

public class AdminXacNhanMuaHangbo {
	public ArrayList<AdminXacNhanMuaHangbean> dsXacNhan = new ArrayList<AdminXacNhanMuaHangbean>();
	AdminXacNhanMuahangdao adminXNdao = new AdminXacNhanMuahangdao();

	public ArrayList<AdminXacNhanMuaHangbean> getDSXacNhan() throws Exception {
		System.out.println("alo boooo");
		dsXacNhan = adminXNdao.getDSXacNhan();

		return dsXacNhan;
	}

	public int XacNhanCTHD(long maCTHD) throws Exception {
		return adminXNdao.XacNhanCTHD(maCTHD);
	}

	public int updateSoLuongTon(int soLuongMua, long maGiay) throws Exception {
		return adminXNdao.updateSoLuongTon(soLuongMua, maGiay);
	}

	public long checkHD1(long maHoaDon) throws Exception {
		return adminXNdao.checkHD1(maHoaDon);
	}

	public int checkHD2(long maHoaDon, long Tong) throws Exception {
		return adminXNdao.checkHD2(maHoaDon, Tong);
	}

	public int updateHD(long maHoaDon) throws Exception {
		return adminXNdao.updateHD(maHoaDon);
	}
}
