
						$(document).ready(function(){
							$("#btn_submit").on("click", function(){
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
									alert("không để trống email");
								}
								if (password == "") {
									alert("không để trống password")
								} 
								if((hoten != "") && (diachi != "") && (sdt != "") && (email != "") && (password != "")){
								$.ajax({
								  url: "/quanlykhoahoc/dang-ky/checkdangky",
								  method: "GET",
								  data: { email : email, password : password, hoten : hoten, diachi : diachi, sdt : sdt },
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
								  url: "/quanlykhoahoc/set-profile//checkprofile",
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
										    url: "/quanlykhoahoc/set-password/checkpassword",
											method: "GET",
											data: { passwordcu : passwordcu, passwordmoi1 : passwordmoi1, passwordmoi2 : passwordmoi2},
											success : function(response){
														
												if(response == "error1"){
													alert("bạn chưa đăng nhập");
													window.location.replace("/quanlykhoahoc/login");
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
													  	window.location.replace("/quanlykhoahoc/index");
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
										    url: "/quanlykhoahoc/set-passwordadmin/checkpassword",
											method: "GET",
											data: { passwordcu : passwordcu, passwordmoi1 : passwordmoi1, passwordmoi2 : passwordmoi2},
											success : function(response){
														
												if(response == "error1"){
													alert("bạn chưa đăng nhập");
													window.location.replace("/quanlykhoahoc/login");
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
								    url: "/quanlykhoahoc/addkhoahoc/checkkhoahoc",
									method: "GET",
									data: { loaiId : loaiId, idgiaovien : idgiaovien, ten : ten, thoigian : thoigian, chiphi :chiphi, img : img, listbaihoc: listbaihoc},
									success : function(response){	
										if(response == "error1"){
											alert("giáo viên không tồn tại");
										}else{
											alert("thêm thành công!");
											window.location.replace("/quanlykhoahoc/addkhoahoc");
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
										    url: "/quanlykhoahoc/addadmin/checkadmin",
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
								if (img == ""){
									alert("bạn chưa nhập link ảnh")
								}
								if((hoten != "") && (diachi != "") && (sdt != "") && (email != "") && (password != "") && (img != "")){
								$.ajax({
								  url: "/quanlykhoahoc/addgiaovien/checkaddgv",
								  method: "GET",
								  data: { email : email, password : password, hoten : hoten, diachi : diachi, sdt : sdt, img : img},
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
								  		window.location.replace("/quanlykhoahoc/listgiaovien");
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
								  url: "/quanlykhoahoc/addsinhvien/checksv",
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
								  		window.location.replace("/quanlykhoahoc/listhocvien");
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
								    url: "/quanlykhoahoc/set-khoahoc/checkkhoahoc",
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
						