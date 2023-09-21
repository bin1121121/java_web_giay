<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bean.KhachHangbean"%>
<%@page import="bean.GioHangbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<title>Giỏ hàng</title>

<style type="text/css">
.text {
   overflow: hidden;
   display: -webkit-box;
   -webkit-line-clamp: 2; /* number of lines to show */
           line-clamp: 2; 
   -webkit-box-orient: vertical;
}

@media (min-width: 992px) {
	.formbtnXoa2 {
		display: none
		
	}
}

@media (max-width: 992px) {
	.formbtnXoa1 {
		display: none
		
	}
}

</style>

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
                <form action="trangChuController" method="post" class="d-flex mx-auto" >
                    <input type="text" class="form-control me-sm-2" style="width: 300px" placeholder="Search" name = "txtTimKiem">
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
    <div class = "container mt-3">
    	<%if(request.getAttribute("noEmpty") == null){ %>
    	<div class = "row mt-3"> 
    		<div class ="col-sm-1 col-1">
    			<form action="xoaController" method="post">
    				<input type="submit" value = "Xóa" name ="btnXoaTungPhan" class = "btn btn-outline-dark">
    			
    		</div>
    		
    		<div class = "col-11" style="text-align: center">
    			<div class = "row tieuDe">
    			<div class = "col-1"></div>
    			<div class = "col-4" style="font-weight: bold;">SẢN PHẨM</div>
    			
    			<div class = "col-2" style="font-weight: bold;">GÍA</div>
    			<div class = "col-2" style="padding: 0px !important; font-weight: bold;">SỐ LƯỢNG</div>
    			<div class="col-2" style="font-weight: bold;">TẠM TÍNH</div>
    			<div clsas = "col-1" style="font-weight: bold;"></div>
    			</div>
    		</div>
    	</div>
    	<div class = "row mt-3"> 
    		<%
    		Locale localeVN = new Locale("vi", "VN");
    	    NumberFormat vn = NumberFormat.getInstance(localeVN);
    		
    		%>
    		<div class = "col-1">
    		<%
    		//checkbox
    		for(GioHangbean gio: dsGio){%>
    			<div class = "row" style="height: 80px; text-align: center"">
    				<div style="display: flex; align-items: center; justify-content: center; height: 100%;">
    					<input type="checkbox" name = "checkbox" value="<%=gio.getMaGiay()%>">
    				</div>
    			
    			
    			</div>
    			<br>
    		<%}
    		%>
    		</form>
    		</div>
    		<div class = "col-11">
    		<%
    		//ds giỏ
    		for(GioHangbean gio: dsGio){%>	
				<div class = "row" style=" height: 80px;text-align: center"> 
    		
    			<div class = "col-1"><img src="<%=gio.getAnh()%>" style="width: 100%; height: 100%"></div>
    			<div class = "col-4 text" style="font-weight: bold;"><p class = "text"><%=gio.getTenGiay()%> - <%=gio.getSize()%> - <%=gio.getMauGiay() %></p></div>
    			
    			<div class = "col-2"><%=vn.format(gio.getGia())%>đ</div>
    			<div class = "col-2">
    			<form action="gioHangController?mg=<%=gio.getMaGiay()%>" method="post">
    			<div class = "row">
    				<input type="number" name = "txtSL" value= "<%=gio.getSoLuong() %>" min = 1 class = "col-lg-4 col-sm-6 col-6" style="padding: 0 !important; margin-right: 2px;" width="100%">
    				<input type = "submit" value = "Sửa" class = "col-lg-5 col-sm-6 col-6 btn btn-outline-dark btn-sm" style="width: 50%">
    				</div>
    			</form>
    			</div>
    			<div class = "col-2 "><%=vn.format(gio.getThanhTien())%>đ</div>
    			<div class = "col-1">
    			<form action="xoaController?mg=<%=gio.getMaGiay()%>" method="post" class = "formbtnXoa1">
    				<input type = "submit" value = "Xóa" name = "btnXoa" class = "btn btn-outline-danger btn-sm" style="width: 100%">
    			</form>
    			<form action="xoaController?mg=<%=gio.getMaGiay()%>" method="post" class = "formbtnXoa2">
    				<button name = "btnXoa" class = "btn btn-outline-danger btn-sm">X</button>
    			</form>
    			</div>
    			
    		</div>
				
				<br>
    		<%}%>
    	</div>
    	<hr>
    	<div class ="row">
    		<div class = "col-1"></div>
    		<div class = "col-11">
    			<div class ="row">
    				<div class ="col-10" style="font-weight: bold;">TỔNG TIỀN: </div>
    				<div class ="col-2"><%=vn.format(session.getAttribute("tong"))%>đ</div>
    			</div>
    		</div>
    	</div>
    	
    	<div class ="row">
    		<div class = "col-10">
    			<form action="xoaController" method="post">
    				<input type="submit" value ="Xóa tất cả" class = "btn btn-outline-dark" name = "btnXoaTatCa">
    			</form>
    		</div>
    		<div class = "col-2">
    			 <form action="muaHangController">
    				<input type="submit" value="Mua hàng"  class = "btn btn-outline-dark" name = "btnMuaHang" >
    			</form>
    			
    		</div>
    	</div>
    	</div>
    		
    		
    	<%}else{ %>
    	<div class = "row">
    	<div class ="col-3"></div>
    		<div class ="col-6">
    			<img src="<%=request.getAttribute("noEmpty")%>" width="100%" >
    		</div>
    	<div class ="col-3"></div>
    	</div>
    	<%} %>  	
     </div>
     	
</body>
</html>