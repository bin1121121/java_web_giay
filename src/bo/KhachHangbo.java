package bo;

import bean.KhachHangbean;
import dao.KhachHangdao;

public class KhachHangbo {
	KhachHangdao khdao = new KhachHangdao();

	public KhachHangbean getKH(String tendn, String mk) throws Exception {
		return khdao.getKH(tendn, mk);
	}

	public int addKH(KhachHangbean kh) throws Exception {
		return khdao.addKH(kh);
	}

}
