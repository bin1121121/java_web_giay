<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bean.AdminXacNhanHoaDonbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminDangNhapbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận hóa đơn</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a href="adminTrangChuController" class="navbar-brand">Trang chủ</a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse1">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse1">
                <div class="navbar-nav">
               
                    <a href="adminQuanLyMatHangController" class="nav-item nav-link">Quản lý mặt hàng</a>
                    <a href="adminXacNhanMuahangController" class="nav-item nav-link">Xác nhận mua hàng</a>
                    <a href="adminXacNhanHoaDonController" class="nav-item nav-link">Xác nhận hóa đơn</a>
                </div>
                
                <div class="navbar-nav d-flex ms-auto">
                <%AdminDangNhapbean adminbean = (AdminDangNhapbean) session.getAttribute("admin");
                if(adminbean == null){%>
               
                <a href="adminDangNhapController" class="nav-item nav-link">Đăng nhập</a>
                <%}else{ %>
                <a href="#" class="nav-item nav-link"><%=adminbean.getHoTen()%></a>
                <a href="adminDangXuatController" class="nav-item nav-link">Đăng xuất</a>
                <%} %>
                </div>
            </div>
        </div>
    </nav>
    
    <div class = "container-fluid mt-3">
    <div style="text-align: center"><h3>Xác nhận hóa đơn</h3></div>
    <br>
    <table class = "table table-responsive">
   		<thead class="table-dark">
    <tr>
      <th scope="col">Mã hóa đơn</th>
      
      <th scope="col">Họ tên</th>
      <th scope="col">Ngày mua</th>
      <th scope="col">Tổng tiền</th>
      <th scope="col">Tình trạng</th>
       <th scope="col">Xác nhận</th>
    </tr>
  </thead>
  
    	<tbody>
    		<%
    		Locale localeVN = new Locale("vi", "VN");
    	    NumberFormat vn = NumberFormat.getInstance(localeVN);
    		ArrayList<AdminXacNhanHoaDonbean> dsXacNhanHD = (ArrayList<AdminXacNhanHoaDonbean>) request.getAttribute("dsXacNhanHD");
    		for(AdminXacNhanHoaDonbean hoadon : dsXacNhanHD){ %>
    		
    		<tr>
    	<th scope="row"><%=hoadon.getMaHoaDon() %></th>
    	<td><%=hoadon.getHoTen() %></td>
    	<td><%=hoadon.getNgayMua()%></td>
    	<td><%=vn.format(hoadon.getTongTien())%>đ</td>
    	<td><%=hoadon.isTinhTrang() ? "Đã thanh toán": "Chưa thanh toán" %></td>
    	<td><a href="adminXacNhanHoaDonController?maHD=<%=hoadon.getMaHoaDon() %>" class = "btn btn-outline-dark">Xác nhận</a></td>
    	
    	
    	
    	</tr>
    			<%-- <div class = "col-1"><%=hoadon.getMaHoaDon() %></div>
    			<div class = "col-3"><%=hoadon.getHoTen() %></div>
    			<div class = "col-2"><%=hoadon.getNgayMua()%></div>
    			<div class = "col-2"><%=hoadon.getTongTien() %></div>
    			<div class = "col-2"><%=hoadon.isTinhTrang() ? "Đã thanh toán": "Chưa thanh toán" %></div>
    			<div class = "col-2"><a href="adminXacNhanHoaDonController?maHD=<%=hoadon.getMaHoaDon() %>" class = "btn btn-outline-dark">Xác nhận</a></div>
    		 --%><%} %>
    	</tbody>
    </div>
</body>
</html>