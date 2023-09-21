package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GioHangbean;
import bo.GioHangbo;

/**
 * Servlet implementation class xoaController
 */
@WebServlet("/xoaController")
public class xoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xoaController() {
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
			String mg = request.getParameter("mg");
			String btnXoa = request.getParameter("btnXoa");
			GioHangbo gbo = null;
			ArrayList<GioHangbean> dsGioHang = null;
			if (mg != null && btnXoa != null) {
				gbo = (GioHangbo) session.getAttribute("gioHang");
				dsGioHang = (ArrayList<GioHangbean>) session.getAttribute("dsGioHang");
				gbo.xoaGioHang(Long.parseLong(mg));
				dsGioHang = gbo.dsGioHang;
				session.setAttribute("gioHang", gbo);

				session.setAttribute("dsGioHang", dsGioHang);
				session.setAttribute("tong", (long) gbo.tong());
			}
			String btnXoaTatCa = request.getParameter("btnXoaTatCa");

			String[] xoaTP = request.getParameterValues("checkbox");
			String btnXoaTungPhan = request.getParameter("btnXoaTungPhan");
			if (xoaTP != null && btnXoaTungPhan != null) {
				gbo = (GioHangbo) session.getAttribute("gioHang");
				dsGioHang = (ArrayList<GioHangbean>) session.getAttribute("dsGioHang");
				for (String x : xoaTP) {
					gbo.xoaGioHang(Long.parseLong(x));
				}
				dsGioHang = gbo.dsGioHang;
				session.setAttribute("gioHang", gbo);

				session.setAttribute("dsGioHang", dsGioHang);
				session.setAttribute("tong", (long) gbo.tong());
			}
			if (btnXoaTatCa != null) {
				session.removeAttribute("gioHang");
				session.removeAttribute("dsGioHang");
			}
			response.sendRedirect("gioHangController");
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
