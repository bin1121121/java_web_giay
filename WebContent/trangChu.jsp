<%-- <%@page import="bean.GioHangbean"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bean.KhachHangbean"%>
<%@page import="bean.Giaybean"%>
<%@page import="bean.Loaibean"%>
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
<style>
	/* Custom style */
    .navbar{
        margin-bottom: 1rem;
    }
    .hover-div:hover{
	border: 1px solid #dcdcdc !important;
	box-shadow: 5px 5px 5px 5px #dcdcdc !important;	
}
.image img {

    width: 100%;
    height: 300;
    transition: all 1s ease-in-out
}
.image-2{
	 overflow: hidden;
}
.image:hover img {
    transform: scale(1.25);
   
    cursor: pointer
}

@media (min-width: 780px) {
	.danhMucHai {
		display: none
	}
}

@media (max-width: 781px){
	.danhMuc{
		display: none
	}
}

</style>

<title>Trang chủ</title>
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
                //số lượng giỏ
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
		<div class = "row">
	<div class = "col-md-3 col-12 col-sm-3 danhMuc" style="overflow-y: scroll; height: 100vh ">
	<h3>THƯƠNG HIỆU</h3>
	<div class = "btn-group">
	<div class = "row">
	<%
	// đổ ra danh sách loại
	 ArrayList<Loaibean> dsLoai = (ArrayList<Loaibean>) request.getAttribute("dsLoai");
	for(Loaibean loai: dsLoai){ %>
	<div style="margin: 5px 0" class = "col-12">
	<a href="trangChuController?maLoai=<%=loai.getMaLoai()%>&tenLoai=<%=loai.getTenLoai() %>" style="width: 90%" class="text-decoration-none btn btn-outline-dark"><%=loai.getTenLoai().toUpperCase()%></a>
	</div>
	<%} %>
	</div>
	</div>
	<hr>
	
	<h3>SIZE</h3>
	<div class = "row">
		<div class = "btn-group flex-wrap">
	<%ArrayList<Integer> dsSize = (ArrayList<Integer>) request.getAttribute("dsSize");%>
	
	<%for(int size : dsSize){
		//đổ ra danh sách size
	%>
	<div class = "col-lg-3 col-md-4 col-sm-4 col-2 " > 
	
	<a href="trangChuController?size=<%=size%>" class="text-decoration-none btn btn-outline-dark" style="margin: 5px 5px 5px 0; width: 90%; height: 90%">
	<span style="justify-content: center; align-content: center; width: 100%; display: flex"><%=size %></span>
	</a>	
	</div>
	
	<%}
	%>
	
	</div>
	
	</div>
	
	<hr>
	<h3>MÀU SẮC</h3>
	
	<div class = "btn-group">
	<div class = "row">
		<%ArrayList<String> dsMauGiay =(ArrayList<String>) request.getAttribute("dsMauGiay");
		for(String mau : dsMauGiay){
		//đổ ra danh sách màu
		%>
		<div class = "col-12">
			<a href="trangChuController?mau=<%=mau%>" class="text-decoration-none btn btn-outline-dark" style="width: 90%; margin: 5px 0;"><%=mau %></a>
		</div>
		<%} %>
	</div>
	</div> 
	</div>
		
		
	<div class = "danhMucHai">
	<a class="btn btn-outline-dark danhMucHai" data-bs-toggle="collapse" href="#collapseExample3" role="button" aria-expanded="false" aria-controls="collapseExample3" style="width: 100%">
    Danh mục
  </a>
	<div class = "col-12 collapse" id="collapseExample3">
	<h3>THƯƠNG HIỆU</h3>
	<div class = "btn-group flex-wrap">
	<div class = "row">
	<%
	 ArrayList<Loaibean> dsLoai1 = (ArrayList<Loaibean>) request.getAttribute("dsLoai");
	for(Loaibean loai: dsLoai1){ %>
	<div class = "col-lg-2 col-md-4 col-sm-4 col-4">
	<a href="trangChuController?maLoai=<%=loai.getMaLoai()%>&tenLoai=<%=loai.getTenLoai() %>" style="width: 80%;margin: 5px 5px" class="text-decoration-none btn btn-outline-dark"><%=loai.getTenLoai().toUpperCase()%></a>
	</div>
	<%} %>
	</div>
	</div>
	<hr>
	
	<h3>SIZE</h3>
	<div class = "row">
	<div class = "btn-group flex-wrap">
	<%ArrayList<Integer> dsSize1 = (ArrayList<Integer>) request.getAttribute("dsSize");%>
	
	<%for(int size : dsSize1){
	%>
	<div class = "col-lg-2 col-md-3 col-sm-4 col-2 " > 
	
	<a href="trangChuController?size=<%=size%>" class="text-decoration-none btn btn-outline-dark" style="margin: 5px 5px 5px 0; width: 90%; height: 90%">
	<span style="justify-content: center; align-content: center; width: 100%; display: flex"><%=size %></span>
	</a>
	
		
	</div>
	
	<%}
	%>
	
	</div>
	
	</div>
	
	<hr>
	<h3>MÀU SẮC</h3>
	<div class = "btn-group">
	<div class = "row"> 
		<%ArrayList<String> dsMauGiay1 =(ArrayList<String>) request.getAttribute("dsMauGiay");
		for(String mau : dsMauGiay1){%>
		<div class = "col-lg-2 col-md-3 col-sm-3 col-3">
			<a href="trangChuController?mau=<%=mau%>" class="text-decoration-none btn btn-outline-dark" style="width: 80% ;margin: 5px 0;"><%=mau %></a>
		</div>
		<%} %>
	</div>
	</div>
		</div>
		
		</div>
		
		
		<div class = "col-lg-9 col-md-9 col-12 col-sm-12">
		<div class = "row">
		<%if(request.getAttribute("tieuDe") != null){%>
			<div><h3><%=request.getAttribute("tieuDe") %></h3></div>
		<%}%>
		<%Locale localeVN = new Locale("vi", "VN");
	    NumberFormat vn = NumberFormat.getInstance(localeVN);
		
		ArrayList<Giaybean> dsGiay = (ArrayList<Giaybean>) request.getAttribute("dsGiay");
			for(Giaybean giay: dsGiay){%>
			
				<div class = "col-lg-3 col-md-4 col-sm-4 col-4 shadow-sm p-3 mb-5 bg-white rounded hover-div image">
				
				<a href="matHangController?maGiay=<%=giay.getMaGiay()%>">
				<div class = "image-2">
					<img src="<%=giay.getAnh()%>" width="300" height="300" class = "img-thumbnail">
				</div><br>
				<label style="font-weight: bold; color: black"><%=giay.getTenGiay()%></label><br>
				
				<label style="color: black">Giá: <%=vn.format(giay.getGia())%>đ</label><br>
				<%if(giay.getSoLuongTon() != 0){ %>
				<label style="color: grey">Số lượng còn: <%=giay.getSoLuongTon()%></label><br>
				<%}else{ %>
				<label style="color: grey">Đã hết hàng</label><br>
				<%} %>
				</a>
			
			</div>
			<%} %>
			</div>
			</div>
		</div>
		
	</div>
	
	   
</body>
</html> --%>


<%@page import="bean.GioHangbean"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bean.KhachHangbean"%>
<%@page import="bean.Giaybean"%>
<%@page import="bean.Loaibean"%>
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
<style>
	/* Custom style */
    .navbar{
        margin-bottom: 1rem;
    }
    .hover-div:hover{
	border: 1px solid #dcdcdc !important;
	box-shadow: 5px 5px 5px 5px #dcdcdc !important;	
}
.image img {

    width: 100%;
    height: 300;
    transition: all 1s ease-in-out
}
.image-2{
	 overflow: hidden;
}
.image:hover img {
    transform: scale(1.25);
   
    cursor: pointer
}

@media (min-width: 780px) {
	.danhMucHai {
		display: none
	}
}

@media (max-width: 781px){
	.danhMuc{
		display: none
	}
}

</style>

<title>Trang chủ</title>
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
                //số lượng giỏ
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
		<div class = "row">
	<div class = "col-md-3 col-12 col-sm-3 danhMuc" style="overflow-y: scroll; height: 100vh ">
	<h3>THƯƠNG HIỆU</h3>
	<div class = "btn-group">
	<div class = "row">
	<%
	// đổ ra danh sách loại
	 ArrayList<Loaibean> dsLoai = (ArrayList<Loaibean>) request.getAttribute("dsLoai");
	for(Loaibean loai: dsLoai){ %>
	<div style="margin: 5px 0" class = "col-12">
	<a href="trangChuController?maLoai=<%=loai.getMaLoai()%>&tenLoai=<%=loai.getTenLoai() %>" style="width: 90%" class="text-decoration-none btn btn-outline-dark"><%=loai.getTenLoai().toUpperCase()%></a>
	</div>
	<%} %>
	</div>
	</div>
	<hr>
	
	<h3>SIZE</h3>
	<div class = "row">
		<div class = "btn-group flex-wrap">
	<%ArrayList<Integer> dsSize = (ArrayList<Integer>) request.getAttribute("dsSize");%>
	
	<%for(int size : dsSize){
		//đổ ra danh sách size
	%>
	<div class = "col-lg-3 col-md-4 col-sm-4 col-2 " > 
	
	<a href="trangChuController?size=<%=size%>" class="text-decoration-none btn btn-outline-dark" style="margin: 5px 5px 5px 0; width: 90%; height: 90%">
	<span style="justify-content: center; align-content: center; width: 100%; display: flex"><%=size %></span>
	</a>	
	</div>
	
	<%}
	%>
	
	</div>
	
	</div>
	
	<hr>
	<h3>MÀU SẮC</h3>
	
	<div class = "btn-group">
	<div class = "row">
		<%ArrayList<String> dsMauGiay =(ArrayList<String>) request.getAttribute("dsMauGiay");
		for(String mau : dsMauGiay){
		//đổ ra danh sách màu
		%>
		<div class = "col-12">
			<a href="trangChuController?mau=<%=mau%>" class="text-decoration-none btn btn-outline-dark" style="width: 90%; margin: 5px 0;"><%=mau %></a>
		</div>
		<%} %>
	</div>
	</div> 
	</div>
		
		
	<div class = "danhMucHai">
	<a class="btn btn-outline-dark danhMucHai" data-bs-toggle="collapse" href="#collapseExample3" role="button" aria-expanded="false" aria-controls="collapseExample3" style="width: 100%">
    Danh mục
  </a>
	<div class = "col-12 collapse" id="collapseExample3">
	<h3>THƯƠNG HIỆU</h3>
	<div class = "btn-group flex-wrap">
	<div class = "row">
	<%
	 ArrayList<Loaibean> dsLoai1 = (ArrayList<Loaibean>) request.getAttribute("dsLoai");
	for(Loaibean loai: dsLoai1){ %>
	<div class = "col-lg-2 col-md-4 col-sm-4 col-4">
	<a href="trangChuController?maLoai=<%=loai.getMaLoai()%>&tenLoai=<%=loai.getTenLoai() %>" style="width: 80%;margin: 5px 5px" class="text-decoration-none btn btn-outline-dark"><%=loai.getTenLoai().toUpperCase()%></a>
	</div>
	<%} %>
	</div>
	</div>
	<hr>
	
	<h3>SIZE</h3>
	<div class = "row">
	<div class = "btn-group flex-wrap">
	<%ArrayList<Integer> dsSize1 = (ArrayList<Integer>) request.getAttribute("dsSize");%>
	
	<%for(int size : dsSize1){
	%>
	<div class = "col-lg-2 col-md-3 col-sm-4 col-2 " > 
	
	<a href="trangChuController?size=<%=size%>" class="text-decoration-none btn btn-outline-dark" style="margin: 5px 5px 5px 0; width: 90%; height: 90%">
	<span style="justify-content: center; align-content: center; width: 100%; display: flex"><%=size %></span>
	</a>
	
		
	</div>
	
	<%}
	%>
	
	</div>
	
	</div>
	
	<hr>
	<h3>MÀU SẮC</h3>
	<div class = "btn-group">
	<div class = "row"> 
		<%ArrayList<String> dsMauGiay1 =(ArrayList<String>) request.getAttribute("dsMauGiay");
		for(String mau : dsMauGiay1){%>
		<div class = "col-lg-2 col-md-3 col-sm-3 col-3">
			<a href="trangChuController?mau=<%=mau%>" class="text-decoration-none btn btn-outline-dark" style="width: 80% ;margin: 5px 0;"><%=mau %></a>
		</div>
		<%} %>
	</div>
	</div>
		</div>
		
		</div>
		
		
		<div class = "col-lg-9 col-md-9 col-12 col-sm-12">
		<div class = "row">
		<%if(request.getAttribute("tieuDe") != null){%>
			<div><h3><%=request.getAttribute("tieuDe") %></h3></div>
		<%}%>
		<%Locale localeVN = new Locale("vi", "VN");
	    NumberFormat vn = NumberFormat.getInstance(localeVN);
		
		ArrayList<Giaybean> dsGiay = (ArrayList<Giaybean>) request.getAttribute("dsGiay");
		String empty = (String) request.getAttribute("empty");
		String keyNull = (String) request.getAttribute("keyNull");
		if(keyNull != null){%>
			<div><%= keyNull%></div>
		<%}
		if(empty != null ){%>
			<div><%= empty%></div>
		<%}else{
			if(keyNull == null){
			for(Giaybean giay: dsGiay){%>
			
				<div class = "col-lg-3 col-md-4 col-sm-4 col-4 shadow-sm p-3 mb-5 bg-white rounded hover-div image">
				
				<a href="matHangController?maGiay=<%=giay.getMaGiay()%>">
				<div class = "image-2">
					<img src="<%=giay.getAnh()%>" width="300" height="300" class = "img-thumbnail">
				</div><br>
				<label style="font-weight: bold; color: black"><%=giay.getTenGiay()%></label><br>
				
				<label style="color: black">Giá: <%=vn.format(giay.getGia())%>đ</label><br>
				<%if(giay.getSoLuongTon() != 0){ %>
				<label style="color: grey">Số lượng còn: <%=giay.getSoLuongTon()%></label><br>
				<%}else{ %>
				<label style="color: grey">Đã hết hàng</label><br>
				<%} %>
				</a>
			
			</div>
			<%}}} %>
			</div>
			</div>
		</div>
		
	</div>
	
	   
</body>
</html>