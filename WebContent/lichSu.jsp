<%@page import="bean.LichSubean"%>
<%@page import="bean.KhachHangbean"%>
<%@page import="bean.GioHangbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lịch sử mua hàng</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a href="trangChuController" class="navbar-brand">Trang chủ</a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse1">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse1">
                <div class="navbar-nav">
                <%
                	ArrayList<GioHangbean> dsGio = (ArrayList<GioHangbean>) session.getAttribute("dsGioHang");
                	int n = 0;
                		if(dsGio != null)
                			n = dsGio.size();
                	%>
                    <a href="gioHangController" class="nav-item nav-link">Giỏ hàng(<%=n %>)</a>
                    <a href="lichSuController" class="nav-item nav-link">Lịch sử mua hàng</a>
                </div>
                <form class="d-flex mx-auto" action="trangChuController" method="post">
                    <input type="text" class="form-control me-sm-2" style="width: 300px" placeholder="Search" name = "txtTimKiem">
                    <button type="submit" class="btn btn-outline-light">Search</button>
                </form>
                <div class="navbar-nav">
                <%KhachHangbean khbean = (KhachHangbean) session.getAttribute("khachHang");
                if(khbean == null){%>
                <a href="dangKyController" class="nav-item nav-link">Đăng ký</a>
                <a href="dangNhapController" class="nav-item nav-link">Đăng nhập</a>
                <%}else{ %>
                <a href="hoSoController?hoSo=<%=khbean.getMaKhachHang()%>" class="nav-item nav-link"><%=khbean.getHoTen()%></a>
                <a href="dangXuatController" class="nav-item nav-link">Đăng xuất</a>
                <%} %>
                </div>
            </div>
        </div>
    </nav>
    
    <div class = "container">
    <div class = "col-12">
    	<div class = "row">
    		<div class = "col-1"></div>
    		<div class = "col-3" style="font-weight: bold;">SẢN PHẨM</div>
    		<div class = "col-2" style="font-weight: bold;">GIÁ</div>
    		<div class = "col-2" style="font-weight: bold;">SỐ LƯỢNG</div>
    		<div class = "col-2" style="font-weight: bold;">NGÀY MUA</div>
    		<div class = "col-2" style="font-weight: bold;">TÌNH TRẠNG</div>
    	</div>
    </div>
    	<div style="font-weight: bold;">Sản phẩm đã thanh toán</div>
    	<hr>
    	<div class = row>
    		<%ArrayList<LichSubean> dsLSTrue = (ArrayList<LichSubean>) request.getAttribute("dsLSTrue");
    		for(LichSubean ls : dsLSTrue){%>
    		<div class = "col-1"><img src="<%=ls.getAnh()%>" width="100%"></div>
    		<div class = "col-3"><%=ls.getTenGiay()%> - <%=ls.getSize()%> - <%=ls.getMauGiay()%></div>
    		<div class = "col-2"><%=ls.getGia() %></div>
    		<div class = "col-2"><%=ls.getSoLuong() %></div>
    		<div class = "col-2"><%=ls.getNgayMua() %></div>
    		<div class = "col-2"><%=ls.isTinhTrang() ? "Đã thanh toán" : ""%></div>
    		<div class="mb-2"></div>
    		<hr>
    		<%}
    		%>
    	</div>
    	
    	<div style="font-weight: bold;">Sản phẩm chưa thanh toán</div>
    	<hr>
    	<div class = row>
    		<%ArrayList<LichSubean> dsLSFalse = (ArrayList<LichSubean>) request.getAttribute("dsLSFalse");
    		for(LichSubean ls : dsLSFalse){%>
    		<div class = "col-1"><img src="<%=ls.getAnh()%>" width="100%"></div>
    		<div class = "col-3"><%=ls.getTenGiay()%> - <%=ls.getSize()%> - <%=ls.getMauGiay()%></div>
    		<div class = "col-2"><%=ls.getGia() %></div>
    		<div class = "col-2"><%=ls.getSoLuong() %></div>
    		<div class = "col-2"><%=ls.getNgayMua() %></div>
    		<div class = "col-2"><%=ls.isTinhTrang() ? "" : "Đang thanh toán" %></div>
    		<div class="mb-2"></div>
    		<hr>
    		<%}
    		%>
    	</div>
    </div>
</body>
</html>