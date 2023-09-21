package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ChiTietSizebo;
import bo.Giaybo;

/**
 * Servlet implementation class adminXoaMatHangController
 */
@WebServlet("/adminXoaMatHangController")
public class adminXoaMatHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminXoaMatHangController() {
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
			String maGiay = request.getParameter("maGiay");
			if (maGiay != null) {
				ChiTietSizebo ctsbo = new ChiTietSizebo();
				ctsbo.xoaSize(Long.parseLong(maGiay));
				Giaybo gbo = new Giaybo();
				gbo.xoaGiay(Long.parseLong(maGiay));
			}
			response.sendRedirect("adminQuanLyMatHangController");
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
