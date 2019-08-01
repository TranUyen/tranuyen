
						$(document).ready(function(){
							$("#btn_submit").on("click", function(){
								var email = $("#email").val();
								var password = $("#password").val();
								var hoten = $("#hoten").val();
								var diachi = $("#diachi").val();
								var sdt = $("#sdt").val();
								
								if(hoten == ""){
									$("#error1").empty();
									$("#error1").append("<i>Bạn chưa điền họ tên</i>");
								}else $("#error1").empty();
								if(diachi == ""){
									$("#error2").empty();
									$("#error2").append("<i>Bạn chưa điền dịa chỉ</i>");
								}else
									$("#error2").empty();
								if(sdt == ""){
									$("#error4").empty();
									$("#error4").append("<i>Bạn chưa điền số điện thoại</i>");
								}else $("#error4").empty();
								if (email == "") {
									$("#error3").empty();
									$("#error3").append("<i>Bạn chưa điền email</i>");
								}else $("#error3").empty();
								if (password == "") {
									$("#error5").empty();
									$("#error5").append("<i>Bạn chưa điền password</i>");
								} else $("#error5").empty();
								if((hoten != "") && (diachi != "") && (sdt != "") && (email != "") && (password != "")){
								$.ajax({
								  url: "/uyenttt/dang-ky/checkdangky",
								  method: "GET",
								  data: { email : email, password : password, hoten : hoten, diachi : diachi, sdt : sdt },
								  success : function(response){
									if(response == "emailfalse"){
										$("#error3").empty();
										$("#error3").append("<i>Email không hợp lệ phải có @</i>");
									}else if(response == "passwordfalse"){
										$("#error5").empty();
										$("#error5").append("<i>Mật khẩu có ít nhất 8 ký tự</i>");
									}else if(response == "sdtfalse"){
										$("#error4").empty();
										$("#error4").append("<i>Số điện thoại không hợp lệ</i>");
								  	}else if (response == "error") {
								  		alert("tài khoản đã tồn tại");
								  	}else {
								  		window.location.replace("/quanlykhoahoc/login");
								  		alert("đăng ký thành công");
								  	}
								  	
								  		}
								});
								}
							});
});
						
						$(document).ready(function(){
							$("#btn1_submit").on("click", function(){
								
								var hoten = $("#hoten").val();
								var diachi = $("#diachi").val();
								var sdt = $("#sdt").val();
								
								$.ajax({
								  url: "/uyenttt/set-profile/checkprofile",
								  method: "GET",
								  data: {hoten : hoten, diachi : diachi, sdt : sdt },
								  success : function(response){
									if(response == "error1"){
										alert("số điện thoại không hợp lệ");
									}else if(response == "ok"){
										alert("thay đổi thông tin thành công");
										window.location.replace("/quanlykhoahoc/profile");
									}else {
								  		alert("lỗi");
								  	}
								  	
								  }
								});
								
							});
							
});
						$(document).ready(function(){
							$("#btn2_submit").on("click", function(){
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
										    url: "/uyenttt/set-password/checkpassword",
											method: "GET",
											data: { passwordcu : passwordcu, passwordmoi1 : passwordmoi1, passwordmoi2 : passwordmoi2},
											success : function(response){
														
												if(response == "error1"){
													alert("bạn chưa đăng nhập");
													window.location.replace("/uyenttt/login");
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
													  	window.location.replace("/uyenttt/index");
												}
											  }	  	
											
										});
									  }
									});
								});
						$(document).ready(function(){
							$("#btn3_submit").on("click", function(){
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
										    url: "/uyenttt/set-passwordadmin/checkpassword",
											method: "GET",
											data: { passwordcu : passwordcu, passwordmoi1 : passwordmoi1, passwordmoi2 : passwordmoi2},
											success : function(response){
														
												if(response == "error1"){
													alert("bạn chưa đăng nhập");
													window.location.replace("/uyenttt/login");
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
													  	window.location.replace("/quanlykhoahoc/indexadmin");
												}
											  }	  	
											
										});
									  }
									});
								});
						
						
						$(document).ready(function(){
					        $("#add-row").click(function(){
					            var markup = "<tr class = 'tr'><td><input type='text' class='name' style='border: #ffffff'></td><td><input type='text' class='tgbatdau' style='border: #ffffff'></td><td><input type='text' class='tgketthuc' style='border: #ffffff'></td></tr>";
					            $(".tbody").append(markup);
					        });
					        
					        $("#submit-khoahoc").click(function(){
					        	
					        	var array = [];
					        	var table=document.getElementById('dataTable');
								var loaiId = $("#loaiId").val();
								var idgiaovien = $("#idgiaovien").val();
								var ten = $("#ten").val();
								var thoigian = $("#thoigian").val();
								var chiphi = $("#chiphi").val();
								var img = $("#img").val();
								
								$( ".tr" ).each(function() {
									array.push({
										name : $(this).find(".name").val(),
										tgbatdau : $(this).find(".tgbatdau").val(),
										tgketthuc : $(this).find(".tgketthuc").val()
										
									});
									});
									 
								
								var listbaihoc = JSON.stringify(array);
								console.log(listbaihoc);
								if(ten ==""){
									alert("bạn chưa điền ten");

								}
								
								if(thoigian ==""){
									alert("bạn chưa điền thoi gian");
								}
								
								$.ajax({
								    url: "/uyenttt/addkhoahoc/checkkhoahoc",
									method: "GET",
									data: { loaiId : loaiId, idgiaovien : idgiaovien, ten : ten, thoigian : thoigian, chiphi :chiphi, img : img, listbaihoc: listbaihoc},
									success : function(response){	
										if(response == "error1"){
											alert("giáo viên không tồn tại");
										}else{
											alert("thêm thành công!");
											window.location.replace("/uyenttt/addkhoahoc");
										}
									  }	  	
									
								});
								  
							});
					    }); 
						
						
						$(document).ready(function(){
							$("#btn4_submit").on("click", function(){
									var email = $("#email").val();
									var password = $("#password").val();
									var name = $("#name").val();
													
									if(name == ""){
														
										alert("bạn chưa điền học tên");
									}
													
									if (email == "") {
										alert("bạn chưa nhập email");
									}
													
									if (password == "") {
										alert("bạn chưa nhập password");
									}
												
									if((name != "") && (email != "") && (password != "") ){
										$.ajax({
										    url: "/uyenttt/addadmin/checkadmin",
											method: "GET",
											data: { email : email, password : password, name : name},
											success : function(response){
														
												if(response == "emailfalse"){
													alert("email không hợp lệ phải có @");
												}else if(response == "passwordfalse"){
													alert("password ít nhất 8 ký tự");
												}else if (response == "error") {
											  		alert("tài khoản đã tồn tại");
												}else {
													  	window.location.replace("/quanlykhoahoc/indexadmin");
													  	alert("đăng ký thành công");
												}
											  }	  	
											
										});
									  }
									});
								});
						
						$(document).ready(function(){
							$("#btn5_submit").on("click", function(){
								var email = $("#email").val();
								var password = $("#password").val();
								var hoten = $("#hoten").val();
								var diachi = $("#diachi").val();
								var sdt = $("#sdt").val();
								var img = $("#img").val();
								
								if(hoten == ""){
									$("#error1").empty();
									$("#error1").append("<i>Chưa điền họ tên giáo viên</i>");
								}else $("#error1").empty();
									
								if(diachi == ""){
									$("#error3").empty();	
									$("#error3").append("<i>Chưa điền địa chỉ</i>");
								}else $("#error3").empty();
								if(sdt == ""){
									$("#error4").empty();	
									$("#error4").append("<i>Chưa điền số điện thoại</i>");
								}else $("#error4").empty();	
								if (email == "") {
									$("#error2").empty();	
									$("#error2").append("<i>Chưa điền Email</i>");
								}else $("#error2").empty();	
								if (password == "") {
									$("#error5").empty();	
									$("#error5").append("<i>Chưa điền Password</i>");
								}else $("#error5").empty();
								if (img == ""){
									$("#error6").empty();	
									$("#error6").append("<i>Chưa điền link ảnh</i>");
								}else $("#error6").empty();
								if((hoten != "") && (diachi != "") && (sdt != "") && (email != "") && (password != "") && (img != "")){
								$.ajax({
								  url: "/uyenttt/addgiaovien/checkaddgv",
								  method: "GET",
								  data: { email : email, password : password, hoten : hoten, diachi : diachi, sdt : sdt, img : img},
								  success : function(response){
									if(response == "emailfalse"){
										$("#error2").empty();	
										$("#error2").append("<i>email không hợp lệ phải có @</i>");
										
									}else if(response == "passwordfalse"){
										$("#error5").empty();	
										$("#error5").append("<i>Password có ít nhất 8 ký tự</i>");
									}else if(response == "sdtfalse"){
										$("#error4").empty();	
										$("#error4").append("<i>Số điện thoại chưa hợp lệ</i>");
								  	}else if (response == "error") {
								  		alert("tài khoản đã tồn tại");
								  	}else {
								  		window.location.replace("/uyenttt/listgiaovien");
								  		alert("đăng ký thành công");
								  	}
								  	
								  }
								});
								}
							});
						});
						
						
						$(document).ready(function(){
							$("#sv_submit").on("click", function(){
								var email = $("#email").val();
								var password = $("#password").val();
								var hoten = $("#hoten").val();
								var diachi = $("#diachi").val();
								var sdt = $("#sdt").val();
								
								
								if(hoten == ""){
									alert("bạn chưa điền học tên");
								}
								if(diachi == ""){
									alert("bạn chua điền địa chỉ");
								}
								if(sdt == ""){
									alert("bạn chưa điền số điện thoại");
								}
								if (email == "") {
									alert("bạn chưa nhập email");
								}
								if (password == "") {
									alert("bạn chưa nhập password");
								}
								
								if((hoten != "") && (diachi != "") && (sdt != "") && (email != "") && (password != "")){
								$.ajax({
								  url: "/uyenttt/addsinhvien/checksv",
								  method: "GET",
								  data: { email : email, password : password, hoten : hoten, diachi : diachi, sdt : sdt},
								  success : function(response){
									if(response == "emailfalse"){
										alert("email không hợp lệ phải có @");
									}else if(response == "passwordfalse"){
										alert("password ít nhất 8 ký tự");
									}else if(response == "sdtfalse"){
										alert("số điện thoại không hợp lệ ")
								  	}else if (response == "error") {
								  		alert("tài khoản đã tồn tại");
								  	}else {
								  		window.location.replace("/uyenttt/listhocvien");
								  		alert("thêm thành công");
								  	}
								  	
								  }
								});
								}
							});
						});
						
						$(document).ready(function(){
					        
					        
					        $("#chinhsua-khoahoc").click(function(){
					        	
					        	var array = [];
					        	var table=document.getElementById('dataTable');
								var loaiId = $("#loaiId").val();
								var idgiaovien = $("#idgiaovien").val();
								var ten = $("#ten").val();
								var thoigian = $("#thoigian").val();
								var chiphi = $("#chiphi").val();
								var img = $("#img").val();
								
								$( ".tr" ).each(function() {
									array.push({
										name : $(this).find(".name").val(),
										tgbatdau : $(this).find(".tgbatdau").val(),
										tgketthuc : $(this).find(".tgketthuc").val()
										
									});
									});
									 
								
								var listbaihoc = JSON.stringify(array);
								console.log(listbaihoc);
								$.ajax({
								    url: "/uyenttt/set-khoahoc/checkkhoahoc",
									method: "GET",
									data: { loaiId : loaiId, idgiaovien : idgiaovien, ten : ten, thoigian : thoigian, chiphi :chiphi, img : img, listbaihoc: listbaihoc},
									success : function(response){	
										if(response == "ok"){
											alert("chỉnh sửa thành công!");
											
										}else{
											alert("chỉnh sửa không thành công")
										}
									  }	  	
									
								});
								  
							});
					    }); 
						