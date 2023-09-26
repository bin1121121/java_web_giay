package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Giaybean;
import bean.GioHangbean;
import bean.KhachHangbean;
import bo.ChiTietHoaDonbo;
import bo.GioHangbo;
import bo.HoaDonbo;
import dao.Giaydao;
import nl.captcha.Captcha;

/**
 * Servlet implementation class xacNhanMuaHangController
 */
@WebServlet("/xacNhanMuaHangController")
public class xacNhanMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xacNhanMuaHangController() {
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
			request.setCharacterEncoding("utf-8");// gửi dữ liệu lên kiểu unicode
			response.setCharacterEncoding("utf-8");// nhận dữ liệu về kiểu unicode
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			GioHangbo gbo = (GioHangbo) session.getAttribute("gioHang");
			ArrayList<GioHangbean> dsGioHang = gbo.dsGioHang;
			session.setAttribute("dsGioHang", dsGioHang);
			session.setAttribute("tong", gbo.tong());
			String btnMuaHang = request.getParameter("btnMuaHang");

			System.out.println(btnMuaHang);
			if (btnMuaHang != null) {
				KhachHangbean kh = (KhachHangbean) session.getAttribute("khachHang");
				if (kh == null) {
					response.sendRedirect("dangNhapController");
				} else {
					String txtHT = request.getParameter("txtHT");
					String txtDC = request.getParameter("txtDC");
					String txtSDT = request.getParameter("txtSDT");
					String txtEM = request.getParameter("txtEM");
					String answer = request.getParameter("answer");
					boolean checkSoLuong = false;
					Giaybean giay = null;
					Giaydao gdao = new Giaydao();

					for (GioHangbean g : dsGioHang) {
						giay = gdao.getMatHang(g.getMaGiay());
						if (giay.getSoLuongTon() == 0) {
							checkSoLuong = true;
							break;
						}
					}

					functionUser functionUser = new functionUser();
					boolean checkHoTen = functionUser.checkHoTen(txtHT);
					boolean checkSDT = functionUser.checkSDT(txtSDT);
					boolean checkEmail = functionUser.checkEmail(txtEM);
					boolean checkDiaChi = functionUser.checkDiaChi(txtDC);
					if (!checkHoTen || !checkDiaChi || !checkSDT || !checkEmail || checkSoLuong
							|| !captcha.isCorrect(answer)) {

						functionUser.requestTruongHoTen(txtHT, request);
						functionUser.requestTruongDiaChi(txtDC, request);
						functionUser.requestTruongSDT(txtSDT, request);
						functionUser.requestTruongEmail(txtEM, request);
						if (checkSoLuong) {
							request.setAttribute("soLuongTrong",
									"Mặt hàng " + giay.getTenGiay() + " đã hết, hãy chọn mặt hàng khác");
						}
						if (!captcha.isCorrect(answer)) {
							request.setAttribute("saiCapcha", "Capcha không hợp lệ");
						}
					} else {
						HoaDonbo hdbo = new HoaDonbo();
						Date a = new Date();
						SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
						String ns = f.format(a);
						Date ngayMua = f.parse(ns);
						hdbo.addHoaDon(kh.getMaKhachHang(), ngayMua, false);
						long maHD = hdbo.getMaHoaDon();
						ArrayList<GioHangbean> ds = (ArrayList<GioHangbean>) session.getAttribute("dsGioHang");
						ChiTietHoaDonbo cthdbo = new ChiTietHoaDonbo();
						for (GioHangbean gio : ds) {
							cthdbo.addChiTietHoaDon(maHD, gio.getMaGiay(), Integer.parseInt(gio.getSoLuong() + ""),
									false, gio.getSize());
						}
						session.removeAttribute("gioHang");
						session.removeAttribute("dsGioHang");
						response.sendRedirect("lichSuController");
					}
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("xacNhanMuaHang.jsp");
			rd.forward(request, response);
		} catch (

		Exception e) {
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
