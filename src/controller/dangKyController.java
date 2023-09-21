package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.KhachHangbean;
import bo.KhachHangbo;

/**
 * Servlet implementation class dangKyController
 */
@WebServlet("/dangKyController")
public class dangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangKyController() {
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
			String ht = request.getParameter("txtHT");
			String dc = request.getParameter("txtDC");
			String sdt = request.getParameter("txtSDT");
			String em = request.getParameter("txtEM");
			String tendn = request.getParameter("txtTK");
			String pass = request.getParameter("txtMK");
			if (ht != null && dc != null && sdt != null && em != null && tendn != null && pass != null) {
				KhachHangbean kh = new KhachHangbean(ht, dc, sdt, em, tendn, pass);
				KhachHangbo khbo = new KhachHangbo();
				int kq = khbo.addKH(kh);
				if (kq == 1) {
					response.sendRedirect("dangNhapController");
				} else {
					request.setAttribute("kq", "Tài khoản đã có người đăng ký");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("dangKy.jsp");
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
