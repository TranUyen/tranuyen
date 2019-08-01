<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>IT-BK | Profile</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="<c:url value ="/file/assets/img/favicon.ico"/>" type="image/x-icon">

    <!-- Font awesome -->
    <link href="<c:url value ="/file/assets/css/font-awesome.css"/>" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="<c:url value ="/file/assets/css/bootstrap.css"/>" rel="stylesheet">   
    <!-- Slick slider -->
    <link rel="stylesheet" type="text/css" href="<c:url value ="/file/assets/css/slick.css"/>">          
    <!-- Fancybox slider -->
    <link rel="stylesheet" href="<c:url value ="/file/assets/css/jquery.fancybox.css"/>" type="text/css" media="screen" /> 
    <!-- Theme color -->
    <link id="switcher" href="<c:url value ="/file/assets/css/theme-color/default-theme.css"/>" rel="stylesheet">    

    <!-- Main style sheet -->
    <link href="<c:url value ="/file/assets/css/style.css"/>" rel="stylesheet">    

   
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,400italic,300,300italic,500,700' rel='stylesheet' type='text/css'>
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      
    <![endif]-->
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  </head>
  <body>
  
  <!--START SCROLL TOP BUTTON -->
    <a class="scrollToTop" href="#">
      <i class="fa fa-angle-up"></i>      
    </a>
  <!-- END SCROLL TOP BUTTON -->

  <!-- Start header  -->
  <header id="mu-header">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-md-12">
          <div class="mu-header-area">
            <div class="row">
              <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                <div class="mu-header-top-left">
                  <div class="mu-top-email">
                    <i class="fa fa-envelope"></i>
                    <span>info@markups.io</span>
                  </div>
                  <div class="mu-top-phone">
                    <i class="fa fa-phone"></i>
                    <span>(568) 986 652</span>
                  </div>
                </div>
              </div>
              <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                <div class="mu-header-top-right">
                  <nav>
                    <ul class="mu-top-social-nav">
                      <li><a href="#"><span class="fa fa-facebook"></span></a></li>
                      <li><a href="#"><span class="fa fa-twitter"></span></a></li>
                      <li><a href="#"><span class="fa fa-google-plus"></span></a></li>
                      <li><a href="#"><span class="fa fa-linkedin"></span></a></li>
                      <li><a href="#"><span class="fa fa-youtube"></span></a></li>
                    </ul>
                  </nav>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- End header  -->
 <!-- Start menu -->
  <section id="mu-menu">
    <nav class="navbar navbar-default" role="navigation">  
      <div class="container">
        <div class="navbar-header">
          <!-- FOR MOBILE VIEW COLLAPSED BUTTON -->
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <!-- LOGO -->              
          <!-- TEXT BASED LOGO -->
          <a class="navbar-brand" href="index.html"><i class="fa fa-university"></i><span>IT-BK</span></a>
          <!-- IMG BASED LOGO  -->
          <!-- <a class="navbar-brand" href="index.html"><img src="<c:url value ="file/assets/img/logo.png"/>" alt="logo"></a> -->
        </div>
        <c:if test = "${empty sinhvien && empty giaovien}">
        <div id="navbar" class="navbar-collapse collapse">
          <ul id="top-menu" class="nav navbar-nav navbar-right main-nav">
            <li class="active"><a href="index">Home </a></li>            
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Courses <span class="fa fa-angle-down"></span></a>
              <ul class="dropdown-menu" role="menu">
              	<li><a href="course">Tất cả khóa học </a></li>
                <li><a href="<c:url value ="/course/1"/>">Seminar </a></li>                
                <li><a href="<c:url value ="/course/2"/>">Đào tạo nội bộ</a></li>
                <li><a href="<c:url value ="/course/3"/>">Đào tạo bên ngoài</a></li>                
              </ul>
            </li> 
            <li><a href="contact">Contact</a></li>
			<li><a href="login">Đăng Nhập</a></li>
            <li><a href="dang-ky">Đăng Ký</a></li>
          </c:if> 
          <c:if test = "${not empty sinhvien || not empty giaovien}">
	          <div id="navbar" class="navbar-collapse collapse">
	          <ul id="top-menu" class="nav navbar-nav navbar-right main-nav">
	            <li class="active"><a href="index">Home </a></li>            
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Courses <span class="fa fa-angle-down"></span></a>
	              <ul class="dropdown-menu" role="menu">
	              	<li><a href="course">Tất cả khóa học </a></li>
	                <li><a href="<c:url value ="/course/1"/>">Seminar </a></li>                
	                <li><a href="<c:url value ="/course/2"/>">Đào tạo nội bộ</a></li>
	                <li><a href="<c:url value ="/course/3"/>">Đào tạo bên ngoài</a></li>                
	              </ul>
	            </li>     
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Chức năng <span class="fa fa-angle-down"></span></a>
              <c:if test="${not empty sinhvien}">
              <ul class="dropdown-menu" role="menu">
                <li><a href="hocphi.html">Học phí</a></li>
                <li><a href="<c:url value ="/course2"/>">Khóa học đang học</a></li>
              </ul>
              </c:if>
              <c:if test="${not empty giaovien}">
              <ul class="dropdown-menu" role="menu">
                <li><a href="hocphi.html">Thêm Khóa Học</a></li>
                <li><a href="<c:url value ="/course3"/>">Khóa học đang dạy</a></li>
              </ul>
              </c:if>
              <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Cá Nhân <span class="fa fa-angle-down"></span></a>
	            <ul class="dropdown-menu" role="menu">
	             <li><a href="<c:url value ="/profile"/>">Profile </a></li>
	             <li><a href="<c:url value ="/set-profile"/>">Thay đổi thông tin </a></li> 
              	 <li><a href="<c:url value ="/set-password"/>">Đổi password</a></li>
              	</ul>
              </li>
              <li><a href="<c:url value ="/dang-xuat"/>">Đăng xuất</a></li>
            </li>
            </c:if>
              </ul>               
            <li><a href="#" id="mu-search-icon"><i class="fa fa-search"></i></a></li>
          </ul>                     
        </div><!--/.nav-collapse -->        
      </div>     
    </nav>
  </section>
  <div class="mu-contact-content" >           
    <div class="row">
      <div class="col-md-12" style="padding-top: 60px; padding-left: 350px">
        <div class="mu-contact-left" style="margin-left: 60px" >
        <h2 style="margin-left: 40px">Thay đổi password</h2>
          <form class="contactform">                  
            <p class="comment-form-author">
              <p></p>
              <p><i> Password cũ: </i></p>
              <input type="password"  size="50" value="" name="passwordcu" id="passwordcu">
            </p>
            <p class="comment-form-email">
              <p></p>
              <p><i> Password mới: </i></p>
              <input type="password"  size="50" value="" name="passwordmoi1" id="passwordmoi1">
            </p>
            <p class="comment-form-url">
              <p></p>
              <p><i> Password mới: </i></p>
              <input type="password" size="50" name="passwordmoi2" id="passwordmoi2" >  
            </p>
            <p class="comment-form-url" style="margin-top: 30px">
              <input type="button" value="Submit"  name="submit" id="btn2_submit" style="width: 425px; background-color: #aad4ff; height: 30px">
            </p>        
          </form>
        </div>
      </div>
  <!-- jQuery library -->
  <script src="<c:url value = "/file/assets/js/jquery.min.js"/>"></script>  
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="assets/js/bootstrap.js"></script>   
  <!-- Slick slider -->
  <script type="text/javascript" src="<c:url value = "/file/assets/js/slick.js"/>"></script>
  <!-- Counter -->
  <script type="text/javascript" src="<c:url value = "/file/assets/js/waypoints.js"/>"></script>
  <script type="text/javascript" src="<c:url value = "/file/assets/js/jquery.counterup.js"/>"></script>  
  <!-- Mixit slider -->
  <script type="text/javascript" src="<c:url value = "/file/assets/js/jquery.mixitup.js"/>"></script>
  <!-- Add fancyBox -->        
  <script type="text/javascript" src="<c:url value = "/file/assets/js/jquery.fancybox.pack.js"/>"></script>

  <!-- Custom js -->
  <script src="<c:url value = "/file/assets/js/custom.js"/>"></script> 
  <script src="<c:url value = "file/assets/js/jquery.dangky.js"/>"></script>
  <!-- <script type="text/javascript">
	$(document).ready(function(){
		$("#btn_submit").on("click", function(){
				var passwordcu = $("#passwordcu").val();
				var passwordmoi1 = $("#passwordmoi1").val();
				var passwordmoi2 = $("#passwordmoi2").val();
								
				if(passwordcu == ""){
									
					alert("bạn chưa nhập password cũ");
				}
								
				if (passwordmoi1 == "") {
					alert("password mới");
				}
								
				if (passwordmoi2 == "") {
					alert("xác nhận lại password mới");
				}
							
				if((passwordcu != "") && (passwordmoi1 != "") && (passwordmoi2 != "") ){
					$.ajax({
					    url: "http://localhost:8080/quanlykhoahoc/set-password/checkpassword",
						method: "GET",
						data: { passwordcu : passwordcu, passwordmoi1 : passwordmoi1, passwordmoi2 : passwordmoi2},
						success : function(response){
									
							if(response == "error1"){
								alert("bạn chưa đăng nhập");
								window.location.replace("http://localhost:8080/quanlykhoahoc/login");
							}else if(response == "error2"){
								alert("password không đúng");
							}else if (response == "error3") {
						  		alert("mật khẩu mới phải có ít nhất 8 ký tự");
							}else if(response == "error4"){
								alert("xác nhận lại mật khẩu mới");
							}else if(response == "error"){
								alert("đổi mật khẩu không thành công")
							}else{
								  	alert("thay đổi mật khẩu thành công");
								  	window.location.replace("http://localhost:8080/quanlykhoahoc/index");
							}
						  }	  	
						
					});
				  }
				});
			});
		</script>
-->
  </body>
</html>