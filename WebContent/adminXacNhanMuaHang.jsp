<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bean.AdminXacNhanMuaHangbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminDangNhapbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận mua hàng</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
.text {
   overflow: hidden;
   display: -webkit-box;
   -webkit-line-clamp: 2; /* number of lines to show */
           line-clamp: 2; 
   -webkit-box-orient: vertical;
}

@media (min-width: 992px) {
	.formbtnXacNhan {
		display: none
		
	}
}

@media (max-width: 992px) {
	.formbtnXacNhan2 {
		display: none
		
	}
}
</style>
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
    <div style="text-align: center">
    	<h3>Xác nhận mặt hàng</h3>
    </div>
    <br>
   	<table class = "table table-responsive">
   		<thead class="table-dark">
    <tr>
      <th scope="col">#</th>
      
      <th scope="col">Họ tên</th>
      <th scope="col">Sản phẩm</th>
      <th scope="col">Ngày mua</th>
      <th scope="col">Giá</th>
      <th scope="col">Số lượng</th>
      <th scope="col">Thành tiền</th>
      <th scope="col">Xác nhận</th>
    </tr>
  </thead>
   	<tbody>
    
    <%
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat vn = NumberFormat.getInstance(localeVN);
    ArrayList<AdminXacNhanMuaHangbean> dsXN = (ArrayList<AdminXacNhanMuaHangbean>) request.getAttribute("dsXacNhan");
    	for(AdminXacNhanMuaHangbean XN : dsXN){
    %>	
    	<tr>
    	<th scope="row" ><img src="<%=XN.getAnh()%>"  style="width: 50px; height:50px"></th>
    	<td><%=XN.getHoTen() %></td>
    	<td><p class = "text"><%=XN.getTenGiay()%> - <%=XN.getSize()%> - <%=XN.getMauGiay()%></p></td>
    	
    	<td><%=XN.getNgayMua()%></td>
    	<td><%=vn.format(XN.getGia())%>đ</td>
    	<td><%=XN.getSoLuongMua()%></td>
    	<td><%=vn.format(XN.getThanhTien())%>đ</td>
    	<td class = "formbtnXacNhan2"><a href="adminXacNhanMuahangController?maCTHD=<%=XN.getMaChiTieHD()%>&SLMua=<%=XN.getSoLuongMua()%>&maGiay=<%=XN.getMaGiay()%>&maHD=<%=XN.getMaHoaDon() %>" class = "btn btn-outline-dark">
    	Xác nhận</a></td>
    	<td class = "formbtnXacNhan"><a href="adminXacNhanMuahangController?maCTHD=<%=XN.getMaChiTieHD()%>&SLMua=<%=XN.getSoLuongMua()%>&maGiay=<%=XN.getMaGiay()%>&maHD=<%=XN.getMaHoaDon() %>" class = "btn btn-outline-dark">
    	<i class="bi bi-check"></i></a></td>
    	</tr>
    	
    <%} %>
 
    </tbody>
    </table>
    </div>
</body>
</html>