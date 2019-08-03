<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>LoraWeb</title>
<link rel="icon" 
	href="view/asset/img/logo_dsvn.png"
	type="image/x-ico" />
<link href="view/asset/css/bootstrap.min.css" rel="stylesheet">
<script src="view/asset/js/jquery-3.2.1.min.js"></script>
<script src="view/asset/js/bootstrap.min.js"></script>

<style type="text/css">
.errMsg {
	font-weight: bold;
	color: #FF0000;
	text-align: left;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.account-wall {
	margin-top: 20px;
	padding: 40px 0px 20px 0px;
	background-color: #f7f7f7;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.login-title {
	color: #555;
	font-size: 18px;
	font-weight: 400;
	display: block;
}

.profile-img {
	width: 96px;
	height: 96px;
	margin: 0 auto 10px;
	display: block;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
}

.need-help {
	margin-top: 10px;
}

.new-account {
	display: block;
	margin-top: 10px;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Đường sắt Việt Nam</h1>
				<div class="account-wall">
					
					<img class="profile-img"
						src="view/asset/img/logo_dsvn.png"
						alt="">
				
					<form class="form-signin" action="SelectTrainCabin.do"
						method="post" charset=UTF-8>
						<div>
							<div class="errMsg" colspan="2">
								<c:forEach items="${listError}" var="error">${error}<br>
								</c:forEach>
							</div>
						</div>
						<input type="text" class="form-control" placeholder="Mã tàu"
							required autofocus name="trainname"
							value="<c:out value="${trainName}" escapeXml="true"/>" size="22"
							onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
							 <input type="text"
							class="form-control" placeholder="Số hiệu khoang" required
							name="cabinId" value="" size="22"
							onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						<button class="btn btn-lg btn-primary btn-block" type="submit">
							Truy cập</button>

					</form>
				</div>

			</div>
		</div>
	</div>




</body>
</html>



