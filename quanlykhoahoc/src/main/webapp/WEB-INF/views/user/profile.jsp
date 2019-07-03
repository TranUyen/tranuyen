<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Course | Profile</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="<c:url value ="file/assets/img/favicon.ico"/>" type="image/x-icon">

    <!-- Font awesome -->
    <link href="<c:url value ="file/assets/css/font-awesome.css"/>" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="<c:url value ="file/assets/css/bootstrap.css"/>" rel="stylesheet">   
    <!-- Slick slider -->
    <link rel="stylesheet" type="text/css" href="<c:url value ="file/assets/css/slick.css"/>">          
    <!-- Fancybox slider -->
    <link rel="stylesheet" href="<c:url value ="file/assets/css/jquery.fancybox.css"/>" type="text/css" media="screen" /> 
    <!-- Theme color -->
    <link id="switcher" href="<c:url value ="file/assets/css/theme-color/default-theme.css"/>" rel="stylesheet">    

    <!-- Main style sheet -->
    <link href="<c:url value ="file/assets/css/style.css"/>" rel="stylesheet">    

   
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,400italic,300,300italic,500,700' rel='stylesheet' type='text/css'>
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

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
          <a class="navbar-brand" href="index.html"><i class="fa fa-university"></i><span>CourseOnline</span></a>
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
              <ul class="dropdown-menu" role="menu">
                <li><a href="hocphi.html">Học phí</a></li>
                <li><a href="course.html">Khóa học đã hoàn thành</a></li>
              </ul>
              <li><a href="login">Cá nhân</a></li>
              <li><a href="login">Đăng xuất</a></li>
            </li>
            </c:if>
              </ul>               
            <li><a href="#" id="mu-search-icon"><i class="fa fa-search"></i></a></li>
          </ul>                     
        </div><!--/.nav-collapse -->        
      </div>     
    </nav>
  </section>
  <!-- End menu -->
  <!-- Start search box -->
  <div id="mu-search">
    <div class="mu-search-area">      
      <button class="mu-search-close"><span class="fa fa-close"></span></button>
      <div class="container">
        <div class="row">
          <div class="col-md-12">            
            <form class="mu-search-form">
             <input type="search" placeholder="Type Your Keyword(s) & Hit Enter">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End search box -->
 <!-- Page breadcrumb -->
 <section id="mu-page-breadcrumb">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="mu-page-breadcrumb-area">
           <h2>Profile</h2>
           <ol class="breadcrumb">
            <li><a href="#">Home</a></li>            
            <li class="active">Profile</li>
          </ol>
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- End breadcrumb -->

 <!-- Start contact  -->
 <section id="mu-contact">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="mu-contact-area">
          <!-- start title -->
          
          <!-- end title -->
          <!-- start contact content -->
           <c:if test = "${not empty sinhvien}">  
          <div class="mu-contact-content">           
            <div class="row">
              <div class="col-md-6">
                <div class="mu-contact-left" style ="padding-left: 200px">
                  <form class="contactform">
                                   
                    <p class="comment-form-author">
                     
                      <h3><b>${sinhvien.getHoten()}<b></h3>
                    </p>
                    <p class="comment-form-email">
                      <label for="email">Email <span class="required">*</span></label>
                      <p> ${sinhvien.getEmail()}</p>
                    </p>
                    <p class="comment-form-url">
                      <label for="subject">Địa chỉ</label>
                      <p>${sinhvien.getDiachi()}</p> 
                    </p>
                    <p class="comment-form-url">
                      <label for="subject">số điên thoại</label>
                      <p>${sinhvien.getSdt()}</p>
                    </p>
                  </form>
                </div>
              </div>
              <div class="col-md-6">
                
                  <img src="data:image/jpeg;base64,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" width="300" height="350" frameborder="0" style="border:0" allowfullscreen>
                </div>
              </div>
            </div>
          </div>
           </c:if> 
           <c:if test="${not empty giaovien}">
           <div class="mu-contact-content">           
            <div class="row">
              <div class="col-md-6">
                <div class="mu-contact-left" style ="padding-left: 200px">
                  <form class="contactform">
                                   
                    <p class="comment-form-author">
                     
                      <h3><b>${giaovien.getHoten()}<b></h3>
                    </p>
                    <p class="comment-form-email">
                      <label for="email">Email <span class="required">*</span></label>
                      <p> ${giaovien.getEmail()}</p>
                    </p>
                    <p class="comment-form-url">
                      <label for="subject">Địa chỉ</label>
                      <p>${giaovien.getDiachi()}</p> 
                    </p>
                    <p class="comment-form-url">
                      <label for="subject">số điên thoại</label>
                      <p>${giaovien.getSdt()}</p>
                    </p>
                  </form>
                </div>
              </div>
              <div class="col-md-6">
                
                  <img src="${giaovien.getImg()}" width="300" height="350" frameborder="0" style="border:0" allowfullscreen>
                </div>
              </div>
            </div>
          </div>
           </c:if>
          <!-- end contact content -->
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- End contact  -->
 

  <!-- Start footer -->
  <footer id="mu-footer">
    <!-- start footer top -->
    <div class="mu-footer-top">
      <div class="container">
        <div class="mu-footer-top-area">
          <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3">
              <div class="mu-footer-widget">
                <h4>Information</h4>
                <ul>
                  <li><a href="#">About Us</a></li>
                  <li><a href="">Features</a></li>
                  <li><a href="">Course</a></li>
                  <li><a href="">Event</a></li>
                  <li><a href="">Sitemap</a></li>
                  <li><a href="">Term Of Use</a></li>
                </ul>
              </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3">
              <div class="mu-footer-widget">
                <h4>Student Help</h4>
                <ul>
                  <li><a href="">Get Started</a></li>
                  <li><a href="#">My Questions</a></li>
                  <li><a href="">Download Files</a></li>
                  <li><a href="">Latest Course</a></li>
                  <li><a href="">Academic News</a></li>                  
                </ul>
              </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3">
              <div class="mu-footer-widget">
                <h4>News letter</h4>
                <p>Get latest update, news & academic offers</p>
                <form class="mu-subscribe-form">
                  <input type="email" placeholder="Type your Email">
                  <button class="mu-subscribe-btn" type="submit">Subscribe!</button>
                </form>               
              </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3">
              <div class="mu-footer-widget">
                <h4>Contact</h4>
                <address>
                  <p>P.O. Box 320, Ross, California 9495, USA</p>
                  <p>Phone: (415) 453-1568 </p>
                  <p>Website: www.markups.io</p>
                  <p>Email: info@markups.io</p>
                </address>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- end footer top -->
    <!-- start footer bottom -->
    <div class="mu-footer-bottom">
      <div class="container">
        <div class="mu-footer-bottom-area">
          <p>&copy; All Right Reserved. Designed by <a href="http://www.markups.io/" rel="nofollow">MarkUps.io</a></p>
        </div>
      </div>
    </div>
    <!-- end footer bottom -->
  </footer>
  <!-- End footer -->





  
  <!-- jQuery library -->
  <script src="<c:url value ="file/assets/js/jquery.min.js"/>"></script>  
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="<c:url value ="file/assets/js/bootstrap.js"/>"></script>   
  <!-- Slick slider -->
  <script type="text/javascript" src="<c:url value ="file/assets/js/slick.js"/>"></script>
  <!-- Counter -->
  <script type="text/javascript" src="<c:url value ="file/assets/js/waypoints.js"/>"></script>
  <script type="text/javascript" src="<c:url value ="file/assets/js/jquery.counterup.js"/>"></script>  
  <!-- Mixit slider -->
  <script type="text/javascript" src="<c:url value ="file/assets/js/jquery.mixitup.js"/>"></script>
  <!-- Add fancyBox -->        
  <script type="text/javascript" src="<c:url value ="file/assets/js/jquery.fancybox.pack.js"/>"></script>

  <!-- Custom js -->
  <script src="<c:url value = "file/assets/js/custom.js"/>"></script> 

  </body>
</html>