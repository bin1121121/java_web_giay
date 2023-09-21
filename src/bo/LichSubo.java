package bo;

import java.util.ArrayList;

import bean.LichSubean;
import dao.LichSudao;

public class LichSubo {
	public ArrayList<LichSubean> dsLichSu = new ArrayList<LichSubean>();
	LichSudao lsdao = new LichSudao();

	public ArrayList<LichSubean> getLichSu(long ma, int check) throws Exception {

		return lsdao.getLichSu(ma, check);
	}
}
