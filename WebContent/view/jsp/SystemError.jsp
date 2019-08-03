<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="view/asset/css/custom.css" rel="stylesheet">
<link href="view/asset/css/bootstrap.min.css" rel="stylesheet">
<script src="view/asset/js/jquery-3.2.1.min.js"></script>
<script src="view/asset/js/bootstrap.min.js"></script>
<title>Lỗi!</title>
</head>
<body>
	<style type="text/css">
html {
	height: 100%;
}

body {
	min-height: 100%;
	padding: 0;
	margin: 0;
	position: relative;
}

/* Trick: */
body {
	position: relative;
}

body::after {
	content: '';
	display: block;
	height: 50px; /* Set same as footer's height */
}

footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 50px;
}
</style>
	<!-- Begin vung header -->
	<jsp:include page="Header.jsp" />
	<!-- End vung header -->

	<!-- Begin vung input-->
	<form action="SelectTrainCabin.do" method="get" name="inputform">
		<table class="tbl_input" border="0" width="80%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" colspan="2">
					<div style="height: 50px"></div>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><font color="red">Lỗi
						rồi!</font></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<div style="height: 70px"></div>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input class="btn" type="submit"
					value="OK" onclick="" /></td>
			</tr>
		</table>
	</form>
	<!-- End vung input -->

	<!-- Begin vung footer -->
	<jsp:include page="Footer.jsp" />
	<!-- End vung footer -->
</body>

</html>