package bo;

import dao.AdminThongKedao;

public class AdminThongKebo {
	AdminThongKedao adminTKdao = new AdminThongKedao();

	public long Thongke(int thang, int nam) throws Exception {
		return adminTKdao.Thongke(thang, nam);
	}

	public long TongMatHangDaBan(int thang, int nam) throws Exception {
		return adminTKdao.TongMatHangDaBan(thang, nam);
	}
}
