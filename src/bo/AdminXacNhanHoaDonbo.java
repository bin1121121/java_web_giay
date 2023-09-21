package bo;

import java.util.ArrayList;

import bean.AdminXacNhanHoaDonbean;
import dao.AdminXacNhanHoaDondao;

public class AdminXacNhanHoaDonbo {
	AdminXacNhanHoaDondao adminXNHDdao = new AdminXacNhanHoaDondao();

	public ArrayList<AdminXacNhanHoaDonbean> getDSXNHoaDon() throws Exception {
		return adminXNHDdao.getDSXNHoaDon();
	}

	public int updateHoaDon(long maHD) throws Exception {
		return adminXNHDdao.updateHoaDon(maHD);
	}
}
