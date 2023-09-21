<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bean.Loaibean"%>
<%@page import="bean.ChiTietSizebean"%>
<%@page import="bean.Giaybean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminDangNhapbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý mặt hàng</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
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
 
 <div clas = "container-fluid">
 <div style="text-align: center" class = "mt-3"><h3>Quản lý mặt hàng</h3></div>
 <br>
<%
 Giaybean giay = (Giaybean) request.getAttribute("giay");
 %>


<form action = "adminQuanLyMatHangController?check=ok" method="post">
	<input type = "submit" name = "btnThem" value = "Thêm mặt hàng" class = "btn btn-outline-dark">
</form>
<%
if(request.getAttribute("trungTen") != null){
	   %>
	   <div style="color: red; text-align: center"><%=request.getAttribute("trungTen")%></div>
	   <br>
 <%}%>
 <%
if(request.getAttribute("tenTrong") != null){
	   %>
	   <div style="color: red; text-align: center"><%=request.getAttribute("tenTrong")%></div>
	   <br>
 <%}%>
 <%
if(request.getAttribute("giaTrong") != null){
	   %>
	   <div style="color: red; text-align: center"><%=request.getAttribute("giaTrong")%></div>
	   <br>
 <%}%>
 <%
if(request.getAttribute("soLuongTrong") != null){
	   %>
	   <div style="color: red; text-align: center"><%=request.getAttribute("soLuongTrong")%></div>
	   <br>
 <%}%>
 <%
if(request.getAttribute("mauSacTrong") != null){
	   %>
	   <div style="color: red; text-align: center"><%=request.getAttribute("mauSacTrong")%></div>
	   <br>
 <%}%>
  <%
if(request.getAttribute("danhSachTrong") != null){
	   %>
	   <div style="color: red; text-align: center"><%=request.getAttribute("danhSachTrong")%></div>
	   <br>
 <%}%>
 <%
 if(request.getAttribute("anhTrong") != null){
	   %>
	   <div style="color: red; text-align: center"><%=request.getAttribute("anhTrong")%></div>
	   <br>
 <%}%>
<div class = "col-12 row">
<div class = "col-3"></div>
<%
String check = (String) request.getAttribute("check");
if(check != null ){ %>
	<div class = "col-6">
<%
if(check.equals("ok")){%>
	 <form action="adminThemMatHangController" method="post" enctype= "multipart/form-data" class = "p-4">
<%}else{%>
<form action="adminSuaMatHangController" method="post" enctype= "multipart/form-data" class = "p-4">
<input name = "maGiay" value = "<%=giay.getMaGiay()%>" style="display: none">
<%} %>
  <div class="form-row">
    <div class="form-group col-12">
      <label>Tên hàng</label>
      <input type="text" class="form-control" name = "txtTenHang" value = "<%=giay!= null ? giay.getTenGiay() : ""%>">
    </div>
    <br>
    <div class="form-group col-12">
      <label>Giá</label>
      <input type=text class="form-control" name = "txtGia" value = "<%=giay != null ? giay.getGia() : ""%>">
    </div>
    <br>
  </div>
  <div class="form-group col-12">
    <label>Số lượng</label>
    <input type="text" class="form-control"  name = "txtSoLuong" value = "<%=giay != null ? giay.getSoLuongTon() : ""%>">
  </div>
  <br>
      <div class="form-group col-12">
      <label>Màu sắc</label>
      <input type="text" class="form-control" name = "txtMauSac" value = "<%=giay != null ? giay.getMauGiay() : ""%>">
    </div>
    <br>
  <div class="form-group col-12">
    <label>Ảnh </label>
   	<%if(giay != null){ %>
   	<div style="width: 100px; height: 100px"><img src="<%=giay.getAnh()%>" style="width: 100%; height: 100%"></div>
   	<input type="text" name="txtanh" value = "<%=giay.getAnh()%>">
   	<%} %>
    <div>
    <input type="file" name="txtfile" value = "<%=giay != null ? giay.getAnh() : ""%>">
    </div>
  </div>
  <br>
  <div class="form-row">
    <div class="form-group col-12">
      <labe>Tên loại</label>
      <select class="form-control" name="txtMaLoai">
      <%if(request.getAttribute("dsLoai") != null){
    	  ArrayList<Loaibean> dsLoai = (ArrayList<Loaibean>) request.getAttribute("dsLoai");
    	  for(Loaibean loai : dsLoai){
    	 	if(giay != null && giay.getMaLoai() == loai.getMaLoai()){
    	  %>
    	  	<option value = <%=loai.getMaLoai() %> selected><%=loai.getTenLoai()%></option>
    		<%} %>
    	  <option value = <%=loai.getMaLoai() %>><%=loai.getTenLoai()%></option>
      <%}} %>
      </select>
    </div>
    <div class="form-group col-12">
      <label>Size</label>
      
      <div class = "row">
      <%
      
      if(request.getAttribute("dsCTS") != null){
      ArrayList<Integer> dsCTSize = (ArrayList<Integer>) request.getAttribute("dsCTS");
      ArrayList<Integer> sizeCuaHang = (ArrayList<Integer>) request.getAttribute("sizeCuaHang");
      int n = dsCTSize.size();
      	for(int i = 0; i < n; i++){%>
      		<div class = "col-1"><input type="checkbox" name = "txtSize" value = "<%=dsCTSize.get(i)%>"
      		<%if(sizeCuaHang != null){
      		int m = sizeCuaHang.size();
      			for(int j =0; j<m; j++){
      				if(sizeCuaHang.get(j) == dsCTSize.get(i)){
      		%>
      		checked
      		<%}}} %>
      		></div>
      		<div class = "col-2"><p><%=dsCTSize.get(i)%></p></div>
      	<%}}
      
      %>   
      
    </div>
   </div>
   
  </div>
  <br>

  <button type="submit" class="btn btn-outline-dark">Xác nhận</button>
</form>
</div>
<%} %>
 	<div class = "col-3" style="padding: 0px 0px !important"></div>
 	</div>
 	
 	<table class = "table">
 		<thead class = "table-dark">
 		<tr>
 			<th scope="col">Ảnh</th>
 			<th scope="col">Tên giày</th>
      		<th scope="col">Giá</th>
      		<th scope="col">Tên loại</th>
      		<th scope="col">Màu sắc</th>
      		<th scope="col">Số lượng</th>
      		<th scope="col">Sửa</th>
      		<th scope="col">Xóa</th>
 		</tr>
 		</thead>
 	<tbody>
 	<%ArrayList<Giaybean> dsGiay = (ArrayList<Giaybean>) request.getAttribute("dsGiay");
 	Locale localeVN = new Locale("vi", "VN");
    NumberFormat vn = NumberFormat.getInstance(localeVN);
 		for(Giaybean g : dsGiay){%>
 		<tr>
 			<th scope="row"><img src="<%=g.getAnh()%>" style="width: 50px; height: 50px"></th>
 			<td><%=g.getTenGiay() %></td>
      		<td><%=vn.format(g.getGia())%>đ</td>
      		<td><%=g.getMaGiay() %></td>
      		<td><%=g.getMauGiay() %></td>
      		<td><%=g.getSoLuongTon() %></td>
      		<td><a href="adminQuanLyMatHangController?maGiay=<%=g.getMaGiay()%>&check=sua" class = "btn btn-outline-dark">
      		<i class="bi bi-pencil-square"></i></a>
      		</td>
      		<td><a href="adminXoaMatHangController?maGiay=<%=g.getMaGiay()%>" class = "btn btn-outline-dark"><i class="bi bi-trash"></i></a></td>
 		</tr>
 		<%} %>
 	</tbody>
 	</table>
 </div>
</body>
</html>