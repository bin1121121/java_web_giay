<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
	.border-div{
	border-right: 0.1px solid grey
}
	@media (max-width: 992px){
	.tieuDe{
		display: none
	}
}
</style>
</head>
<body>
	<div class = "container mt-4" >
    <div class = "row">
    	<div class = "col-lg-5 border-div tieuDe"> 
    		<h1 style="display: flex; justify-content: center; align-items: center; height: 600px; font-size: 50px; font-weight: bold">Đăng nhập</h1>
    	</div>
    	<%String kq = (String) request.getAttribute("kq"); %>
    	<div class = "col-lg-7" style="display: flex; align-items: center;justify-content:center; height: 600px;"> 
    			<form action="adminDangNhapController" method="post">
    				<label style="font-weight: bold; font-size: 20px">Tên tài khoản:</label><br>
    				<input type = "text" name = "txtTKAdmin" placeholder="Nhập tên tài khoản người quản lý" class ="form-control" style="width: 300px; margin: 10px 0;">
    				<label style="font-weight: bold; font-size: 20px">Mật khẩu:</label><br>
    				<input type = "password" name = "txtMKAdmin" placeholder="Nhập mật khẩu người quản lý" class ="form-control" style=" margin: 10px 0">
    				<%if(kq != null){%>
    					<div style="color: red"><%=kq %></div>
    				<%} %>
    			
    				<div>
    					<input type = "submit" name = "btnXacNhan" value = "Đăng nhập" class = "btn btn-dark" style="margin-top: 10px">
    				</div>		
    			</form>
    		</div>
    	
    </div>
    </div>
</body>
</html>