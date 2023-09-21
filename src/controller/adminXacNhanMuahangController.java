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

import bean.AdminXacNhanMuaHangbean;
import bo.AdminXacNhanMuaHangbo;

/**
 * Servlet implementation class adminXacNhanMuahangController
 */
@WebServlet("/adminXacNhanMuahangController")
public class adminXacNhanMuahangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminXacNhanMuahangController() {
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

			AdminXacNhanMuaHangbo adminXNbo = new AdminXacNhanMuaHangbo();
			ArrayList<AdminXacNhanMuaHangbean> dsXN;

			String maCTHD = request.getParameter("maCTHD");
			String SLMua = request.getParameter("SLMua");
			String maGiay = request.getParameter("maGiay");
			String maHoaDon = request.getParameter("maHD");
			if (maCTHD != null && SLMua != null && maGiay != null && maHoaDon != null) {
				long tong1 = 0;
				adminXNbo.XacNhanCTHD(Long.parseLong(maCTHD));
				adminXNbo.updateSoLuongTon(Integer.parseInt(SLMua), Long.parseLong(maGiay));
				tong1 = adminXNbo.checkHD1(Long.parseLong(maHoaDon));
				int check = 0;
				check = adminXNbo.checkHD2(Long.parseLong(maHoaDon), tong1);
				if (check == 1) {
					adminXNbo.updateHD(Long.parseLong(maHoaDon));
				}
				response.sendRedirect("adminXacNhanMuahangController");
			}

			adminXNbo.getDSXacNhan();

			dsXN = adminXNbo.dsXacNhan;
			request.setAttribute("dsXacNhan", dsXN);

			RequestDispatcher rd = request.getRequestDispatcher("adminXacNhanMuaHang.jsp");
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
