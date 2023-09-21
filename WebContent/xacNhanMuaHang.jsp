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
    <div class = "container">
    <form action="xacNhanMuaHangController" method="post">
    <div class = "row"> 
    <div class ="col-6">
        			<div class = "col-lg-7" style=" height: 900px;"> 
    			
    				<label style="font-weight: bold; font-size: 20px">Họ và tên:</label><br>
    				<input type = "text" name = "txtHT" placeholder="Nhập Họ và tên" class ="form-control" style=" margin: 10px 0" value = "<%=request.getAttribute("tenTrong") != null ? "" : khbean.getHoTen() %>">
    				 <label style="font-weight: bold; font-size: 20px">Địa chỉ:</label><br>
    				<input type = "text" name = "txtDC" placeholder="Nhập Địa chỉ" class ="form-control" style=" margin: 10px 0" value = "<%=request.getAttribute("diaChiTrong") != null ? "" :khbean.getDiaChi() %>">
    				   <label style="font-weight: bold; font-size: 20px">Số điện thoại:</label><br>
    				<input type = "text" name = "txtSDT" placeholder="Nhập Số điện thoại" class ="form-control" style=" margin: 10px 0" value = "<%=request.getAttribute("SDTTrong") != null ? "" :khbean.getSDT() %>">
    				   <label style="font-weight: bold; font-size: 20px">Email:</label><br>
    				<input type = "text" name = "txtEM" placeholder="Nhập Email" class ="form-control" style=" margin: 10px 0" value = "<%=request.getAttribute("emailTrong") != null ? "" :khbean.getEmail() %>">
    				<img src="simpleCaptcha.jpg" /><br>
					
					<input type="text" name="answer" /><br>
					
    				
    		<%if(request.getAttribute("tenTrong") != null){%>
    			<div style="color: red;"><%=(String) request.getAttribute("tenTrong") %></div>
    		<%}%>
    			<%if(request.getAttribute("diaChiTrong") != null){%>
    			<div style="color: red;"><%=(String) request.getAttribute("diaChiTrong") %></div>
    		<%}%>
    		<%if(request.getAttribute("SDTTrong") != null){%>
    			<div style="color: red;"><%=(String) request.getAttribute("SDTTrong") %></div>
    		<%}%>
    		<%if(request.getAttribute("emailTrong") != null){%>
    			<div style="color: red;"><%=(String) request.getAttribute("emailTrong") %></div>
    		<%}%>
    		<%if(request.getAttribute("soLuongTrong") != null){%>
    			<div style="color: red;"><%=(String) request.getAttribute("soLuongTrong") %></div>
    		<%}%>
    		<%if(request.getAttribute("SaiSDT") != null){%>
    			<div style="color: red;"><%=(String) request.getAttribute("SaiSDT") %></div>
    		<%}%>
    		<%if(request.getAttribute("saiCapcha") != null){%>
    			<div style="color: red;"><%=(String) request.getAttribute("saiCapcha") %></div>
    		<%}%>
    		</div>
    </div>
    <div class = "col-6">
    	<%if(request.getAttribute("noEmpty") == null){ %>
    	<div class = "row mt-3"> 
    		
    		
    		<div class = "col-12" style="text-align: center">
    			<div class = "row tieuDe">
    			<div class = "col-2"></div>
    			<div class = "col-4" style="font-weight: bold;">SẢN PHẨM</div>
    			
    			<div class = "col-2" style="font-weight: bold;">GÍA</div>
    			<div class = "col-2" style="padding: 0px !important; font-weight: bold;">SỐ LƯỢNG</div>
    			<div class="col-2" style="font-weight: bold;">TẠM TÍNH</div>
    			
    			</div>
    		</div>
    	</div>
    	<div class = "row mt-3"> 
    		<%
    		Locale localeVN = new Locale("vi", "VN");
    	    NumberFormat vn = NumberFormat.getInstance(localeVN);
    		
    		%>
    		
    		<div class = "col-12">
    		<%
    		//ds giỏ
    		for(GioHangbean gio: dsGio){%>	
				<div class = "row" style=" height: 80px;text-align: center"> 
    		
    			<div class = "col-2"><img src="<%=gio.getAnh()%>" style="width: 100%; height: 100%"></div>
    			<div class = "col-4 text" style="font-weight: bold;"><p class = "text"><%=gio.getTenGiay()%> - <%=gio.getSize()%> - <%=gio.getMauGiay() %></p></div>
    			
    			<div class = "col-2"><%=vn.format(gio.getGia())%>đ</div>
    			<div class = "col-2"><%=gio.getSoLuong() %></div>
    			<div class = "col-2 "><%=vn.format(gio.getThanhTien())%>đ</div>
    			<div class = "col-1">
    				
    			
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
    		<div class = "col-10"></div>
    		<div class = "col-2">
    			
    				<input type="submit" value="Mua hàng"  class = "btn btn-outline-dark" name = "btnMuaHang" >
    			
    		</div>
    	</div>
    	</div>
    	

    		
    		<div>
    		
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
     </form>
     	</div>
     	
</body>
</html>