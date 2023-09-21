package bo;

import java.util.ArrayList;

import bean.Giaybean;
import dao.Giaydao;

public class Giaybo {
	Giaydao gdao = new Giaydao();
	ArrayList<Giaybean> dsGiay;

	public ArrayList<Giaybean> getDSGiay() throws Exception {
		dsGiay = gdao.getDSGiay();
		return dsGiay;
	}

	public ArrayList<Giaybean> getDSLoaiGiay(long maLoai) throws Exception {
		ArrayList<Giaybean> tam = new ArrayList<Giaybean>();
		for (Giaybean giay : dsGiay) {
			if (giay.getMaLoai() == maLoai) {
				tam.add(giay);
			}
		}
		return tam;
	}

	public ArrayList<Giaybean> getTimKiem(String txtTimKiem) throws Exception {
		ArrayList<Giaybean> tam = new ArrayList<Giaybean>();
		for (Giaybean giay : dsGiay) {
			if (giay.getTenGiay().toLowerCase().contains(txtTimKiem.toLowerCase())) {
				tam.add(giay);
			}
		}
		return tam;
	}

	public ArrayList<String> getDSMauGiay() throws Exception {

		return gdao.getDSMauGiay();
	}

	public ArrayList<Giaybean> getTimSize(int size) throws Exception {
		return gdao.getTimSize(size);
	}

	public ArrayList<Giaybean> getTimMau(String mau) throws Exception {
		ArrayList<Giaybean> dsMau = new ArrayList<Giaybean>();
		for (Giaybean giay : dsGiay) {
			if (giay.getMauGiay().toLowerCase().equals(mau.toLowerCase())) {
				dsMau.add(giay);
			}
		}
		return dsMau;
	}

	public Giaybean getMatHang(long magiay) throws Exception {
		return gdao.getMatHang(magiay);
	}

	public int xoaGiay(long maGiay) throws Exception {
		return gdao.xoaGiay(maGiay);
	}

}