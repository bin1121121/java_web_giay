<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminDangNhapbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
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
    <div class = "container-fluid">
    <div style="text-align: center"><h3>Thống kê mặt hàng</h3></div>
   	<div>
   	<% 
	LocalDateTime localDate = LocalDateTime.now();
	int now = localDate.getYear();
   	%>
	<form action="adminTrangChuController" method="post">
	 <select class="form-select" aria-label="Default select example" name="txtNam">
 	 <%for(int i = 0; i <3; i++){ %>
 	 	<option value="<%=now - i%>" <%
 	 	if(request.getAttribute("getNam") != null){
 	 	int year = (int) request.getAttribute("getNam");
 	 	if(year == (now - i)){%>
 	 	selected
 	 	<%}} %>
 	 	>Năm <%=now - i %></option>
 	 <%} %>
	</select>
	<input type="submit" name = "btnXacNhan" value="Xác nhận" class = "btn btn-outline-dark" style="margin: 5px 0;">
	</form>
   	</div>
    <table class = "table">
    <thead class = "table-dark"> 
   	<tr>
      <th scope="col">Tháng</th>
      <th scope="col">Tổng mặt hàng đã bán</th>
      <th scope="col">Tổng doanh thu</th>
    </tr>
    </thead>
    <tbody>
    <%ArrayList<Long> dsThuNhap = (ArrayList<Long>) request.getAttribute("dsThuNhap");
    ArrayList<Long> dsTongMathang= (ArrayList<Long>) request.getAttribute("dsTongMathang");
    int n = dsThuNhap.size();
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat vn = NumberFormat.getInstance(localeVN);
    for(int i = 0; i< 12; i ++){
    %>
    	<tr>
    		<th scope="row">Tháng <%=i+1 %></th>
      		<td><%=dsTongMathang.get(i) %></td>
      		<td><%=vn.format(dsThuNhap.get(i))%>đ</td>
    	</tr>
    <%} %>
    </tbody>
    </table>
    </div>
    
</body>
</html>