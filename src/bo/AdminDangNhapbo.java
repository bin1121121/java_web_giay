package bo;

import bean.AdminDangNhapbean;
import dao.AdminDangNhapdao;

public class AdminDangNhapbo {
	AdminDangNhapdao adminDNdao = new AdminDangNhapdao();

	public AdminDangNhapbean getAdmin(String tk, String mk) throws Exception {
		return adminDNdao.getAdmin(tk, mk);
	}
}
