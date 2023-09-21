package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.ChiTietSizebo;
import bo.Giaybo;
import bo.Loaibo;

/**
 * Servlet implementation class adminQuanLyMatHangController
 */
@WebServlet("/adminQuanLyMatHangController")
public class adminQuanLyMatHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminQuanLyMatHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if (request.getAttribute("thongBao") != null) {
				request.setAttribute("tb", "Mặt hàng này đã có trong danh sách của bạn");
			}
			if (session.getAttribute("admin") == null) {
				response.sendRedirect("adminDangNhapController");
			}
			String check = request.getParameter("check");
			String maGiay = request.getParameter("maGiay");
			ChiTietSizebo ctsbo = new ChiTietSizebo();
			if (check != null && check.equals("ok")) {
				request.setAttribute("check", "ok");
			}
			if (check != null && check.equals("sua")) {
				request.setAttribute("check", "sua");
				request.setAttribute("sizeCuaHang", ctsbo.getSizeMatHang(Long.parseLong(maGiay)));
			}
			Giaybo gbo = new Giaybo();

			if (maGiay != null) {
				request.setAttribute("giay", gbo.getMatHang(Long.parseLong(maGiay)));
			}
			request.setAttribute("dsGiay", gbo.getDSGiay());

			Loaibo lbo = new Loaibo();
			request.setAttribute("dsCTS", ctsbo.getDSSize());
			System.out.println(ctsbo.getDSSize().size());
			request.setAttribute("dsLoai", lbo.getDSLoai());

			RequestDispatcher rd = request.getRequestDispatcher("adminQuanLyMatHang.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
