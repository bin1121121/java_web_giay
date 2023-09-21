<%@page import="bean.GioHangbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bean.Giaybean"%>
<%@page import="bean.KhachHangbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin sản phẩm</title>
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
                	int a = 0;
                		if(dsGio != null)
                			a = dsGio.size();
                	%>
                    <a href="gioHangController" class="nav-item nav-link">Giỏ hàng(<%=a %>)</a>
                    <a href="lichSuController" class="nav-item nav-link">Lịch sử mua hàng</a>
                </div>
                <form class="d-flex mx-auto">
                    <input type="text" class="form-control me-sm-2" style="width: 300px" placeholder="Search">
                    <button type="submit" class="btn btn-outline-light">Search</button>
                </form>
                <div class="navbar-nav">
                <%KhachHangbean khbean = (KhachHangbean) session.getAttribute("khachHang");
                if(khbean == null){%>
                <a href="dangKyController" class="nav-item nav-link">Đăng ký</a>
                <a href="dangNhapController" class="nav-item nav-link">Đăng nhập</a>
                <%}else{ %>
                <a href="#" class="nav-item nav-link"><%=khbean.getHoTen()%></a>
                <a href="dangXuatController" class="nav-item nav-link">Đăng xuất</a>
                <%} %>
                </div>
            </div>
        </div>
    </nav>
	
	<div class = "container mt-5">
	<%
	Locale localeVN = new Locale("vi", "VN");
    NumberFormat vn = NumberFormat.getInstance(localeVN);
	Giaybean giay = (Giaybean) request.getAttribute("matHang"); 
	ArrayList<Integer> dsSize = (ArrayList<Integer>) request.getAttribute("sizeMatHang");
	%>
		<div class = "row">
		<div class = "col-lg-5">
		<img src="<%=giay.getAnh()%>" height="90%" width="90%" class = "img-thumbnail">
		</div>	
		<div class = "col-lg-7">
		<div style="font-size: 30px; font-weight: bold;"><%=giay.getTenGiay() %></div>	
		<div style="margin: 10px 0; font-size: 25px; font-weight: normal;">Giá: <%=vn.format(giay.getGia())%>đ</div>
		<div style="margin: 10px 0; font-size: 20px; font-weight: normal">Màu sắc: <%=giay.getMauGiay() %></div>
		<div style="margin: 10px 0; font-size: 20px; font-weight: normal; color: grey">Số lượng còn: <%=giay.getSoLuongTon()%></div>
		<div>
			<label style="margin: 10px 0; font-size: 20px; font-weight: normal">Size: </label>
		<form action="gioHangController?maGiay=<%=giay.getMaGiay()%>&tenGiay=<%=giay.getTenGiay()%>&gia=<%=giay.getGia()%>&anh=<%=giay.getAnh()%>
		&mauGiay=<%=giay.getMauGiay()%>" method="post">
		<div class = "btn-group"> 
		<%
		int n = dsSize.size();
		for(int i = 0; i <n ; i++){ %>
		<div style="margin: 0 5px">
			<%if(i == 0){
			//nếu phần từ đầu tiên là cho checkbox = true
			%>
				<input type="radio" class="btn-check" name="btnradio" id="btnradio<%=i %>" autocomplete="off" checked value="<%=dsSize.get(i)%>">
   			   <label class="btn btn-outline-dark" for="btnradio<%=i %>" checked><%=dsSize.get(i) %></label>
			<%}else{
			%>
   			  <input type="radio" class="btn-check" name="btnradio" id="btnradio<%=i %>" autocomplete="off" value="<%=dsSize.get(i)%>">
   			   <label class="btn btn-outline-dark" for="btnradio<%=i %>"><%=dsSize.get(i) %></label>
  		<%} %>
  		</div>
		<%} %>
		</div>
		</div>
		<div>
			<label style="margin: 10px 0; font-size: 20px; font-weight: normal">Số lượng: </label>
			<input type="number" min = "1" max = "<%=giay.getSoLuongTon() %>" value = 1 class = "text-form" style="width : 50px" name = "txtSoLuong">
		</div>
		<hr>
		<%if(giay.getSoLuongTon() != 0){ %>
		<input type="submit" value = "Thêm vào giỏ hàng" class = "btn btn-dark">
		<%}else{ %>
		<div style="color: red;">Mặt hàng này đã hết, vui lòng quay lại sau</div>
		<br>
		<input type="submit" value = "Thêm vào giỏ hàng" class = "btn btn-dark" disabled>
		<%} %>
		</form>
		</div>
		</div>
		
	</div>
</body>
</html>