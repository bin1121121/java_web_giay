package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GioHangbean;
import bo.GioHangbo;

/**
 * Servlet implementation class gioHangController
 */
@WebServlet("/gioHangController")
public class gioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public gioHangController() {
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
			String maGiay = request.getParameter("maGiay");
			String tenGiay = request.getParameter("tenGiay");
			String gia = request.getParameter("gia");
			String mauGiay = request.getParameter("mauGiay");
			String size = request.getParameter("btnradio");
			String anh = request.getParameter("anh");
			String soLuong = request.getParameter("txtSoLuong");

			GioHangbo gbo = null;
			ArrayList<GioHangbean> dsGioHang = null;

			if (maGiay != null) {
				GioHangbean gio = new GioHangbean(Long.parseLong(maGiay), tenGiay, Long.parseLong(gia), mauGiay,
						Integer.parseInt(size), Long.parseLong(soLuong), anh);
				if (session.getAttribute("gioHang") == null) {
					gbo = new GioHangbo();
					session.setAttribute("gioHang", gbo);
				} else {
					gbo = (GioHangbo) session.getAttribute("gioHang");
				}
				gbo.addGioHang(gio);
				dsGioHang = gbo.dsGioHang;

				session.setAttribute("dsGioHang", dsGioHang);
				session.setAttribute("tong", gbo.tong());
				response.sendRedirect("gioHangController");
			}
			String mg = request.getParameter("mg");
			String txtSL = request.getParameter("txtSL");
			if (txtSL != null && mg != null) {
				gbo = (GioHangbo) session.getAttribute("gioHang");
				dsGioHang = (ArrayList<GioHangbean>) session.getAttribute("dsGioHang");
				gbo.suaGioHang(Long.parseLong(mg), Long.parseLong(txtSL));
				dsGioHang = gbo.dsGioHang;
				session.setAttribute("gioHang", gbo);

				session.setAttribute("dsGioHang", dsGioHang);
				session.setAttribute("tong", (long) gbo.tong());

			}

			if (((ArrayList<GioHangbean>) session.getAttribute("dsGioHang")) == null) {
				request.setAttribute("noEmpty", "noEmpty.png");
			} else {
				if (((ArrayList<GioHangbean>) session.getAttribute("dsGioHang")).isEmpty()) {
					request.setAttribute("noEmpty", "noEmpty.png");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("gioHang.jsp");
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
