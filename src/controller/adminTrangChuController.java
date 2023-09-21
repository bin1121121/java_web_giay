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

import bo.AdminThongKebo;

/**
 * Servlet implementation class adminTrangChuController
 */
@WebServlet("/adminTrangChuController")
public class adminTrangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminTrangChuController() {
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

			AdminThongKebo adTKbo = new AdminThongKebo();
			ArrayList<Long> dsThuNhap = new ArrayList<Long>();
			ArrayList<Long> dsTongMathang = new ArrayList<Long>();
			String year = request.getParameter("txtNam");
			for (int i = 0; i < 12; i++) {
				dsThuNhap.add(adTKbo.Thongke(i + 1, year != null ? Integer.parseInt(year) : 2023));
				dsTongMathang.add(adTKbo.TongMatHangDaBan(i + 1, year != null ? Integer.parseInt(year) : 2023));
			}

			if (year != null) {
				request.setAttribute("getNam", Integer.parseInt(year));

			}

			request.setAttribute("dsTongMathang", dsTongMathang);
			request.setAttribute("dsThuNhap", dsThuNhap);
			RequestDispatcher rd = request.getRequestDispatcher("adminTrangChu.jsp");
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
