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

import bean.AdminXacNhanHoaDonbean;
import bo.AdminXacNhanHoaDonbo;

/**
 * Servlet implementation class adminXacNhanHoaDonController
 */
@WebServlet("/adminXacNhanHoaDonController")
public class adminXacNhanHoaDonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminXacNhanHoaDonController() {
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
			if (session.getAttribute("admin") == null) {
				response.sendRedirect("adminDangNhapController");
			}

			AdminXacNhanHoaDonbo adminXNHDbo = new AdminXacNhanHoaDonbo();
			String maHD = request.getParameter("maHD");
			if (maHD != null) {
				adminXNHDbo.updateHoaDon(Long.parseLong(maHD));
			}
			ArrayList<AdminXacNhanHoaDonbean> dsXNHD = adminXNHDbo.getDSXNHoaDon();
			request.setAttribute("dsXacNhanHD", dsXNHD);
			RequestDispatcher rd = request.getRequestDispatcher("adminXacNhanHoaDon.jsp");
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
