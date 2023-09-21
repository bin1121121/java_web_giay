package bo;

import bean.Giaybean;
import dao.AdminQuanLyMatHangdao;

public class AdminQuanLyMatHangbo {
	AdminQuanLyMatHangdao adminQLMHdao = new AdminQuanLyMatHangdao();

	public long KiemTraTenMatHang(String tenGiay) throws Exception {
		return adminQLMHdao.KiemTraTenMatHang(tenGiay);
	}

	public long ThemMatHang(Giaybean giay) throws Exception {
		return adminQLMHdao.ThemMatHang(giay);
	}

	public int ThemChiTietSize(int size, long maGiay) throws Exception {
		return adminQLMHdao.ThemChiTietSize(size, maGiay);
	}

	public int SuaMatHang(Giaybean giay) throws Exception {
		return adminQLMHdao.SuaMatHang(giay);
	}

	public int XoaChiTietSize(long maGiay) throws Exception {
		return adminQLMHdao.XoaChiTietSize(maGiay);
	}
}
