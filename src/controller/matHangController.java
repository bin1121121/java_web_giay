package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ChiTietSizebo;
import bo.Giaybo;

/**
 * Servlet implementation class matHangController
 */
@WebServlet("/matHangController")
public class matHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public matHangController() {
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
				Giaybo gbo = new Giaybo();
				ChiTietSizebo ctsbo = new ChiTietSizebo();
				request.setAttribute("matHang", gbo.getMatHang(Long.parseLong(maGiay)));
				request.setAttribute("sizeMatHang", ctsbo.getSizeMatHang(Long.parseLong(maGiay)));
			}
			RequestDispatcher rd = request.getRequestDispatcher("matHang.jsp");
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
