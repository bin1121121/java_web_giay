package bo;

import java.util.ArrayList;

import bean.ChiTietSizebean;
import dao.ChiTietSizedao;

public class ChiTietSizebo {
	ChiTietSizedao ctsdao = new ChiTietSizedao();

	public ArrayList<Integer> getDSSize() throws Exception {
		return ctsdao.getDSSize();
	}

	public ArrayList<Integer> getSizeMatHang(long magiay) throws Exception {
		return ctsdao.getSizeMatHang(magiay);
	}

	public ArrayList<ChiTietSizebean> getDSSizeCuaAD(long magiay) throws Exception {
		return ctsdao.getDSSizeCuaAD(magiay);
	}

	public int xoaSize(long maGiay) throws Exception {
		return ctsdao.xoaSize(maGiay);
	}
}
