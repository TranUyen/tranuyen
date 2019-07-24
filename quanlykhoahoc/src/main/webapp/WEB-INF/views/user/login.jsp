<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Elegant Login Form Flat Responsive Widget Template :: w3layouts</title>
 <!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Elegant Login Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme  -->
<link rel="stylesheet" href="<c:url value = "/file/css1/style.css"/>">
   <!-- font-awesome icons -->
<link href="<c:url value = "/file/css1/font-awesome.css"/>" rel="stylesheet"> 
<!-- //font-awesome icons -->
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">


  </head>
  <body>
<div class="login-form w3_form">
  <!--  Title-->
      <div class="login-title w3_title">
           <h1>Chào mừng đến IT-BK</h1>
      </div>
           <div class="login w3_login">
                <h2 class="login-header w3_header">Log in</h2>
                
				    <div class="w3l_grid">
                        <form class="login-container" >
                        	 <select id="roleId" name = "roleId" style="width: 350px; height: 46px;">
		                		<option value = "1" >Admin</option>
		                		<option value = "2">Sinh viên</option>
		                		<option value = "3">Giáo Viên</option>
	                		</select>
                             <input type="email" id="email" placeholder="Email" name="email" required="" >
                           
                             <input type="password" id="password" placeholder="Password" name="password" required="">
                             
                             <input type="button" id="login_submit" value="Submit" style="width: 350px; height: 40px" >
                        </form>
                       
						<div class="second-section w3_section">
		     				<div class="bottom-header w3_bottom">
		         				 <h3>OR</h3>
		    				</div>
		     			<div class="social-links w3_social">
					         <ul>
					         <!-- facebook -->
					             <li> <a class="facebook" href="#" target="blank"><i class="fa fa-facebook"></i></a></li>
					
					         <!-- twitter -->
					             <li> <a class="twitter" href="#" target="blank"><i class="fa fa-twitter"></i></a></li>
					
					         <!-- google plus -->
					             <li> <a class="googleplus" href="#" target="blank"><i class="fa fa-google-plus"></i></a></li>
					       </ul>
   						</div>
					</div>
                 
					<div class="bottom-text w3_bottom_text">
					      <p>No account yet?<a href="dang-ky">Đăng ký</a></p>
					      <h4> <a href="#">Forgot your password?</a></h4>
					</div>

       			</div>
       	</div>
  
</div>
  
  


  
<div class="footer-w3l">
		<p class="agile"> &copy; 2017 Elegant Login Form . All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
					<script type="text/javascript">
						$(document).ready(function() {
							$("#login_submit").click(function(){
								var email = $("#email").val();
								var password = $("#password").val();
								var roleId = $("#roleId").val();
								if (email == "") {
									alert("không để trống email");
								}
								else if (password == "") {
									alert("không để trống password")
								} else{
								
									$.ajax({
									  url: "/quanlykhoahoc/login/check",
									  method: "GET",
									  data: { email : email, password : password, roleId : roleId},
									  success : function(response){
									  	if (response == "error") {
									  		alert("mật khẩu hoặc email không đúng");
									  	}else if(response == "admin"){
									  		window.location.replace("/quanlykhoahoc/indexadmin");
									  	}
									  	else {
									  		window.location.replace("/quanlykhoahoc/");
									  	}
									  		}
									});
								}
							});
});
						</script>
</body>
	
</html>