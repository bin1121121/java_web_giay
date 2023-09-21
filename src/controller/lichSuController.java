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

import bean.KhachHangbean;
import bean.LichSubean;
import bo.LichSubo;

/**
 * Servlet implementation class lichSuController
 */
@WebServlet("/lichSuController")
public class lichSuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lichSuController() {
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
			KhachHangbean kh = (KhachHangbean) session.getAttribute("khachHang");
			if (kh == null) {
				response.sendRedirect("dangNhapController");
			} else {
				LichSubo lsbo1 = new LichSubo();
				ArrayList<LichSubean> dsLSTrue = new ArrayList<LichSubean>();
				dsLSTrue = lsbo1.getLichSu(kh.getMaKhachHang(), 1);
				request.setAttribute("dsLSTrue", dsLSTrue);

				for (LichSubean ls : dsLSTrue) {
					System.out.println("check: " + ls.isTinhTrang());
				}
				LichSubo lsbo2 = new LichSubo();
				ArrayList<LichSubean> dsLSFalse = new ArrayList<LichSubean>();
				dsLSFalse = lsbo2.getLichSu(kh.getMaKhachHang(), 0);
				request.setAttribute("dsLSFalse", dsLSFalse);
				RequestDispatcher rd = request.getRequestDispatcher("lichSu.jsp");
				rd.forward(request, response);
			}
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
