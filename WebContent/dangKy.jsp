<%@page import="bean.GioHangbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
.border-div{
	border-right: 0.1px solid grey
}
@media (max-width: 992px){
	.tieuDe{
		display: none
	}
}
</style>
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
                <form class="d-flex mx-auto">
                    <input type="text" class="form-control me-sm-2" style="width: 300px" placeholder="Search">
                    <button type="submit" class="btn btn-outline-light">Search</button>
                </form>
                <div class="navbar-nav">
                <a href="#" class="nav-item nav-link">Đăng ký</a>
                <a href="dangNhapController" class="nav-item nav-link">Đăng nhập</a>
                </div>
            </div>
        </div>
    </nav>
        <div class = "container mt-4" >
    <div class = "row">
    	<div class = "col-lg-5 border-div tieuDe"> 
    		<h1 style="display: flex; justify-content: center; align-items: center; height: 600px; font-size: 50px; font-weight: bold">Đăng Ký</h1>
    	</div>
    	<%String kq = (String) request.getAttribute("kq"); %>
    	
    	<div class = "col-lg-7" style="display: flex; align-items: center;justify-content:center; height: 600px;"> 
    			<form action="dangKyController" method="post">
    				<label style="font-weight: bold; font-size: 20px">Họ và tên:</label><br>
    				<input type = "text" name = "txtHT" placeholder="Nhập Họ và tên" class ="form-control" style=" margin: 10px 0">
    				 <label style="font-weight: bold; font-size: 20px">Địa chỉ:</label><br>
    				<input type = "text" name = "txtDC" placeholder="Nhập Địa chỉ" class ="form-control" style=" margin: 10px 0">
    				   <label style="font-weight: bold; font-size: 20px">Số điện thoại:</label><br>
    				<input type = "text" name = "txtSDT" placeholder="Nhập Số điện thoại" class ="form-control" style=" margin: 10px 0">
    				   <label style="font-weight: bold; font-size: 20px">Email:</label><br>
    				<input type = "text" name = "txtEM" placeholder="Nhập Email" class ="form-control" style=" margin: 10px 0">
    				<label style="font-weight: bold; font-size: 20px">Tên tài khoản:</label><br>
    				<input type = "text" name = "txtTK" placeholder="Nhập tên tài khoản" class ="form-control" style="width: 300px; margin: 10px 0;">
    				<label style="font-weight: bold; font-size: 20px">Mật khẩu:</label><br>
    				<input type = "password" name = "txtMK" placeholder="Nhập mật khẩu" class ="form-control" style=" margin: 10px 0">
    				<%if(kq != null){ %>
    				<div style="color: red"><%=kq %></div>
    				<%} %>
    				<div>
    					<input type = "submit" name = "btnXacNhan" value = "Đăng ký" class = "btn btn-dark" style="margin-top: 10px">
    				</div>		
    			</form>
    		</div>
    	
    </div>
    </div>
</body>
</html>