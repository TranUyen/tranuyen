<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>IT-BK đăng ký</title>
 <!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Elegant Login Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //custom-theme  -->
<link rel="stylesheet" href="<c:url value = "file/css1/style.css"/>">
   <!-- font-awesome icons -->
<link href="<c:url value ="file/css1/font-awesome.css"/>" rel="stylesheet"> 
<!-- //font-awesome icons -->
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  </head>
  <body>
<div class="login-form w3_form">
  <!--  Title-->
      <div class="login-title w3_title">
           <h1>Đăng Ký để tham gia học tập</h1>
      </div>
           <div class="login w3_login">
                <h2 class="login-header w3_header">Đăng ký</h2>
				    <div class="w3l_grid">
                        <form class="login-container">
                        	
                        	 <input type="text" id="hoten" placeholder="hoten" Name="hoten" required="" >
                        	 <input type="text" id="diachi" placeholder="diachi" Name="diachi" required="" >
                             <input type="email" id="email" placeholder="Email" Name="email" required="" >
                             <input type="text" id = "sdt" placeholder="sdt" Name="sdt" required="" >
                             <input type="password" id = "password" placeholder="password" Name="password" required="">
                             <input type="button" id="btn_submit" value="Submit" style="width: 350px; height: 40px" >
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
      <p>No account yet?<a href="login">login</a></p>
      <h4> <a href="#">Forgot your password?</a></h4>
</div>

       </div>
       </div>
  
</div>
  
  


  
<div class="footer-w3l">
		<p class="agile"> &copy; 2017 Elegant Login Form . All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
</div>

	
 <script src="<c:url value = "file/assets/js/jquery.dangky.js"/>"></script> 
</body>
</html>