package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminDangNhapbean;
import bo.AdminDangNhapbo;

/**
 * Servlet implementation class adminDangNhapController
 */
@WebServlet("/adminDangNhapController")
public class adminDangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminDangNhapController() {
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
			AdminDangNhapbo adminbo = new AdminDangNhapbo();
			String txtTKAdmin = request.getParameter("txtTKAdmin");
			String txtMKAdmin = request.getParameter("txtMKAdmin");
			AdminDangNhapbean adminbean;
			if (txtTKAdmin != null && txtMKAdmin != null) {
				adminbean = adminbo.getAdmin(txtTKAdmin, txtMKAdmin);
				if (adminbean == null) {
					request.setAttribute("kq", "Sai tài khoản  hoặc mật khẩu!");

				} else {
					session.setAttribute("admin", adminbean);
					response.sendRedirect("adminTrangChuController");
				}

			}
			RequestDispatcher rd = request.getRequestDispatcher("adminDangNhap.jsp");
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
