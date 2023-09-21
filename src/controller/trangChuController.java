package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Giaybean;
import bo.ChiTietSizebo;
import bo.Giaybo;
import bo.Loaibo;

/**
 * Servlet implementation class trangChuController
 */
@WebServlet("/trangChuController")
public class trangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public trangChuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// gửi dữ liệu lên kiểu unicode
		response.setCharacterEncoding("utf-8");// nhận dữ liệu về kiểu unicode
		try {
			Loaibo lbo = new Loaibo();
			Giaybo gbo = new Giaybo();
			ChiTietSizebo ctsbo = new ChiTietSizebo();
			String maLoai = request.getParameter("maLoai");
			String tenLoai = request.getParameter("tenLoai");
			ArrayList<Giaybean> dsGiay = gbo.getDSGiay();
			if (maLoai != null) {
				request.setAttribute("tieuDe", "THƯƠNG HIỆU: " + tenLoai);
				dsGiay = gbo.getDSLoaiGiay(Long.parseLong(maLoai));
			}
			String size = request.getParameter("size");
			System.out.println(size);
			if (size != null) {
				request.setAttribute("tieuDe", "SIZE: " + size);

				dsGiay = gbo.getTimSize(Integer.parseInt(size));
			}
			String mau = request.getParameter("mau");
			if (mau != null) {
				request.setAttribute("tieuDe", "MÀU SẮC: " + mau);
				dsGiay = gbo.getTimMau(mau);
			}
			String txtTimKiem = request.getParameter("txtTimKiem");
			if (txtTimKiem != null) {
				dsGiay = gbo.getTimKiem(txtTimKiem);
				if (dsGiay.size() == 0) {
					request.setAttribute("empty", "Không có hàng phù hợp!");
				}
			}
			if (txtTimKiem == "") {
				request.setAttribute("keyNull", "Vui lòng nhập tên hàng!");
			}
			request.setAttribute("dsGiay", dsGiay);
			request.setAttribute("dsLoai", lbo.getDSLoai());
			request.setAttribute("dsSize", ctsbo.getDSSize());
			request.setAttribute("dsMauGiay", gbo.getDSMauGiay());

			RequestDispatcher rd = request.getRequestDispatcher("trangChu.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}