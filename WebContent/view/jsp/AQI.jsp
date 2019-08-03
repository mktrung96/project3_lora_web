<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="refresh"  content="600;" />
<link rel="icon" href="view/asset/img/logo_dsvn.png" type="image/x-ico" />
<link href="view/asset/css/bootstrap.min.css" rel="stylesheet">
<link href="view/asset/css/jquery.dataTables.min.css" rel="stylesheet">
<link href="view/asset/css/datatables.bootstrap.css" rel="stylesheet">
<link href="view/asset/css/custom.css" rel="stylesheet">
<link href="view/asset/css/leaflet.css" rel="stylesheet">
<link href="view/asset/css/bootstrap-datepicker.css" rel="stylesheet">
<link href="view/asset/css/font-awesome.min.css" rel="stylesheet">
<title>LoraWeb</title>
<script src="view/asset/js/jquery-3.2.1.min.js"></script>
<script src="view/asset/js/bootstrap.min.js"></script>
<script src="view/asset/js/jquery.dataTables.min.js"></script>
<script src="view/asset/js/datatables.bootstrap.js"></script>
</head>
<body>
	<div class="content">
		<div class="row">
			<div class="col-md-12"
				style="margin-top: 5px; padding: 5px; margin-bottom: -10px;">
				<a href="DisplayAQI.do"> <img
					src="view/asset/img/bannerdsvn.png" class="hidden-xs"
					style="width: 100%"> <img
					src="view/asset/img/bannerdsvn-mobile.png"
					class="hidden-sm hidden-md hidden-lg" style="width: 100%">
				</a>
			</div>
		</div>
<style type="text/css">
.selectLink {
	background: transparent;
	border: 0px solid #ccc;
	text-decoration: underline;
	width: 100%
}

.div-green {
	background-color: #00e400;
	color: white;
}

.div-yellow {
	background-color: #ffff02;
	color: black;
}

.div-orange {
	background-color: #ff7e00;
	color: white;
}

.div-red {
	background-color: #ff0000;
	color: white;
}

.div-brown {
	background-color: #7f0023;
	color: white;
}

.titleParam {
	color: #4a4a4a;
}

.dataTables_info {
	display: none;
}

.col-time {
	width: 60px !important;
	float: left;
}

.col-no {
	width: 15px !important;
	float: left;
}

.col-value {
	min-width: 100px;
}

.selectLink {
	background: transparent;
	border: 0px solid #ccc;
	text-decoration: underline;
	width: 100%
}

.div-green {
	background-color: #00e400;
	color: white;
}

.div-yellow {
	background-color: #ffff02;
	color: black;
}

.div-orange {
	background-color: #ff7e00;
	color: white;
}

.div-red {
	background-color: #ff0000;
	color: white;
}

.div-brown {
	background-color: #7f0023;
	color: white;
}

.titleParam {
	color: #4a4a4a;
}

.dataTables_info {
	display: none;
}

.col-time {
	width: 60px !important;
	float: left;
}

.col-no {
	width: 15px !important;
	float: left;
}

.col-value {
	min-width: 100px;
}

@font-face {
	font-family: 'OpenSansRegular'; /*a name to be used later*/
	src: url('/asset/fonts/OpenSans-Regular.ttf');
}

@font-face {
	font-family: 'OpenSansBold'; /*a name to be used later*/
	src: url('/asset/fonts/OpenSans-Bold.ttf');
}

.button.cyan {
	background-color: #37a2d6;
	color: #fff;
}

.button.medium.hover-thin {
	padding: 5px 25px;
}

.button.cyan.hover-thin {
	border-color: #37a2d6;
}

.button.cyan.hover-thin:hover {
	background: none;
	border: 2px solid #37a2d6;
	color: #37a2d6;
}
</style>

		<div class="row">
			<div class="col-md-12" style="margin-top: 10px; padding: 5px">
				<div
					style="background: #FFFFFF; box-shadow: -1px 1px 10px 1px rgba(0, 0, 0, 0.21);">
					<div class="boxHeader">
						<div class="col-md-2 col-xs-3 col-sm-3"
							style="background: white; height: 100%;">
							<a href="DisplayAQI.do"><span class="header1"
								style="color: #40b7fb;">AQI</span></a>
						</div>
						<div class="col-md-2 col-xs-3 col-sm-3"
							style="height: 100%;">
							<a href="SelectTrainCabin.do"><span class="header1"
								style="color: #40b7fb;">Đăng xuất</span></a>
						</div>

					</div>
					<form>
					<div class="row" style="background-color: white; margin: 10px">
						<div class="col-md-6">
							<div id="div1" class="row div-${displayInfo.color}"
								style="box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21);">
								<div class="col-md-6 col-sm-6 col-xs-12">
									<div class="row text-center">
										<p style="margin-top: 10px; font-weight: bold;">Chỉ số
											chất lượng không khí</p>
									</div>
									<div id="divNumber" class="row text-center">
										<img id="pinIcon" src="${displayInfo.pinIcon}"
											style="margin-bottom: 10px; float: left; margin-right: 10px"
											width="70px" height="70px"> <span id="aqis"
											style="font-family: 'OpenSansBold'; font-size: 65px; display: table; line-height: 100%">${displayInfo.aqi}</span>
									</div>

								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<div class="row"
										style="text-align: left; padding-top: 20px; padding-left: 20px;">
										<p style="font-weight: bold; font-size: 18px;" id="title">${displayInfo.title}</p>
									</div>
									<div class="row"
										style="text-align: left; padding-right: 10px; padding-left: 20px;">
										<p id="des">${displayInfo.des}</p>
									</div>
								</div>
							</div>
							<div id="div2" class="row"
								style="background-color: white; box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21); margin-top: 10px">
								<div class="col-md-8 col-sm-6 col-xs-12"
									style="margin-bottom: -5px; padding: 10px;">
									<div class="col-md-12 col-sm-12 col-xs-12"
										style="text-align: left;">
										<i class="fa fa-map-marker"
											style="margin-left: 2px; margin-right: 2px"
											aria-hidden="true"></i> <span style="margin-left: 5px">
											Ga gần nhất: ${displayInfo.nextStation}</span>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12"
										style="text-align: left; margin-top: 10px">
										<i class="fa fa-clock-o" aria-hidden="true"></i> <span
											style="margin-left: 5px">Cập nhật lần cuối: <strong
											id="receivedDate">${displayInfo.time_record}</strong></span>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12"
									style="text-align: left; padding: 10px">
									<div class="col-md-12 col-sm-12 col-xs-12"
										style="text-align: left;" value="${displayInfo.trainID}"
										name="trainID">
										<i class="fa fa-map-marker"
											style="margin-left: 2px; margin-right: 2px"
											aria-hidden="true"></i> <span style="margin-left: 5px">
											Tàu : ${displayInfo.trainName}</span>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12"
										style="text-align: left; margin-top: 10px"
										value="${displayInfo.cabinID}" name="trainID">
										<i class="fa fa-map-marker"
											style="margin-left: 2px; margin-right: 2px"
											aria-hidden="true"></i> <span style="margin-left: 5px">
											Khoang : ${displayInfo.cabinID}</span>
									</div>
								</div>
							</div>
							<div id="div35" class="row"
								style="background-color: white; box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21); margin-top: 10px; padding: 7px">
								<div class="row">
									<div class="col-md-6 col-sm-6 col-xs-6" style="padding: 0px;">
										<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
											<div class="col-md-6 col-xs-6 col-sm-6 text-right">
												<img src="view/asset/img/icon_weather.png">
											</div>
											<div class="col-md-6 col-xs-6 col-sm-6 text-left"
												style="padding: 0px;">
												<p style="font-size: 20px;">
													<span id="temp">${displayInfo.temp}</span><span
														style="font-size: 15px;"> °C</span>
												</p>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-6" style="padding: 0px;">
										<div class="col-md-12" style="padding: 0px; margin-top: 5px">
											<div class="col-md-6 col-xs-6 col-sm-6 text-right">
												<img src="view/asset/img/icon_water.png">
											</div>
											<div class="col-md-6 col-xs-6 col-sm-6 text-left"
												style="padding: 0px;">
												<p style="font-size: 20px;">
													<span id="humi">${displayInfo.humi}</span> <span
														style="font-size: 15px;">%</span>
												</p>
											</div>
										</div>
									</div>
									
										<div class="col-md-5 col-sm-5 col-xs-12" style="padding: 0px;">
										
									</div>
									
								</div>
							</div>
							<div id="div3" class="row"
								style="background-color: white; box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21); margin-top: 10px; padding: 7px">
								<div id="aqiNomal">
									<div class="row" style="margin-left: 30px; margin-bottom: 10px">
										<div class="col-md-8 col-sm-8 col-xs-8" style="padding: 0px;">
											Nồng độ của từng khí (ppm):</div>
										<div class="col-md-4 col-sm-4 col-xs-4 text-right"
											style="padding: 0px;">
											<a href="Information.do" target="_blank"
												style="cursor: pointer; color: black"> <img width="20"
												height="20" src="view/asset/img/info.jpg"
												style="margin-right: 20px">
											</a>
										</div>
									</div>

									<div class="row">
										<div class="col-md-4 col-sm-4 col-xs-4" style="padding: 0px;">
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-6 col-xs-6 col-sm-6 text-right">
													<p style="font-size: 20px;" class="titleParam">CO</p>
												</div>
												<div class="col-md-6 col-xs-6 col-sm-6 text-left"
													style="padding: 0px;">
													<p style="font-size: 20px;" id="co">${displayInfo.co}</p>
												</div>
											</div>
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-6 col-xs-6 col-sm-6 text-right">
													<p style="font-size: 20px;" class="titleParam">C2H5-OH</p>
												</div>
												<div class="col-md-6 col-xs-6 col-sm-6 text-left"
													style="padding: 0px;">
													<p style="font-size: 20px;" id="so2">${displayInfo.ethanol}</p>
												</div>
											</div>
										</div>
										<div class="col-md-4 col-sm-4 col-xs-4" style="padding: 0px;">
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-6 col-xs-6 col-sm-6 text-right">
													<p style="font-size: 20px;" class="titleParam">C7H8</p>
												</div>
												<div class="col-md-6 col-xs-6 col-sm-6 text-left">
													<p style="font-size: 20px;" id="toluene">${displayInfo.toluene}</p>
												</div>
											</div>
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-6 col-xs-6 col-sm-6 text-right">
													<p style="font-size: 20px;" class="titleParam">C3H6O</p>
												</div>
												<div class="col-md-6 col-xs-6 col-sm-6 text-left">
													<p style="font-size: 20px;" id="acetone">${displayInfo.acetone}</p>
												</div>
											</div>
										</div>
											<div class="col-md-4 col-sm-4 col-xs-4" style="padding: 0px;">
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-6 col-xs-6 col-sm-6 text-right">
													<p style="font-size: 20px;" class="titleParam">CO2</p>
												</div>
												<div class="col-md-6 col-xs-6 col-sm-6 text-left">
													<p style="font-size: 20px;" id="co2">${displayInfo.co2}</p>
												</div>
											</div>
											
											
										</div>
									</div>


								</div>
								<div id="aqiHightLevel">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-xs-6" style="padding: 0px;">
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-4 col-sm-4 col-xs-4 text-center">
													<img src="view/asset/img/icon_weather.png">
												</div>
												<div class="col-md-8 col-sm-8 col-xs-8 text-left"
													style="padding: 0px;">
													<p style="font-size: 16px;">
														<span id="tempHight">${displayInfo.temp}</span><span
															style="font-size: 12px;"> °C</span>
													</p>
												</div>
											</div>
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-4 col-sm-4 col-xs-4 text-center">
													<p style="font-size: 16px;" class="titleParam">CO</p>
												</div>
												<div class="col-md-8 col-sm-8 col-xs-8 text-left"
													style="padding: 0px;">
													<p style="font-size: 16px;">
														<span id="coHight">${displayInfo.co}</span><span
															style="font-size: 12px;"> ppm</span>
													</p>
												</div>
											</div>
											  
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-4 col-sm-4 col-xs-4 text-center">
													<p style="font-size: 16px;" class="titleParam">toluene</p>
												</div>
												<div class="col-md-8 col-sm-8 col-xs-8 text-left"
													style="padding: 0px;">
													<p style="font-size: 16px;">
														<span id="tolueneHight">${displayInfo.toluene }</span><span
															style="font-size: 12px;"> ppm</span>
													</p>
												</div>
											</div>
											
										</div>
										<div class="col-md-4 col-sm-4 col-xs-6" style="padding: 0px;">
											<div class="col-md-12" style="padding: 0px; margin-top: 5px">
												<div class="col-md-4 col-sm-4 col-xs-4 text-center">
													<img src="view/asset/img/icon_water.png">
												</div>
												<div class="col-md-8 col-sm-8 col-xs-8 text-left"
													style="padding: 0px;">
													<p style="font-size: 16px;">
														<span id="humiHight">${displayInfo.humi }</span> <span
															style="font-size: 12px;">%</span>
													</p>
												</div>
											</div>
											  
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-4 col-sm-4 col-xs-4 text-center"
													style="padding: 0px;">
													<p style="font-size: 16px;" class="titleParam">ethanol</p>
												</div>
												<div class="col-md-8 col-sm-8 col-xs-8 text-left"
													style="padding: 0px;">
													<p style="font-size: 16px;">
														<span id="ethanolHight"></span><span
															style="font-size: 12px;">${displayInfo.ethanol } µm/m³</span>
													</p>
												</div>
											</div>
											<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-4 col-sm-4 col-xs-4 text-center"
													style="padding: 0px;">
													<p style="font-size: 16px;" class="titleParam">acetone</p>
												</div>
												<div class="col-md-8 col-sm-8 col-xs-8 text-left"
													style="padding: 0px;">
													<p style="font-size: 16px;">
														<span id="acetoneHight"></span><span
															style="font-size: 12px;">${displayInfo.acetone } µm/m³</span>
													</p>
												</div>
											</div>
											
										</div>
										<div class="col-md-4 col-sm-4 col-xs-12" style="padding: 0px;">
										<div class="col-md-12" style="margin-top: 5px; padding: 0px;">
												<div class="col-md-4 col-sm-4 col-xs-4 text-center"
													style="padding: 0px;">
													<p style="font-size: 16px;" class="titleParam">CO2</p>
												</div>
												<div class="col-md-8 col-sm-8 col-xs-8 text-left"
													style="padding: 0px;">
													<p style="font-size: 16px;">
														<span id="acetoneHight"></span><span
															style="font-size: 12px;">${displayInfo.co2 } µm/m³</span>
													</p>
												</div>
											</div>	
											
										</div>
									</div>

								</div>
							</div>
							<form>
								<div id="div4" class="row"
									style="background-color: white; box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21); margin-top: 10px; padding: 7px; margin-bottom: 15px;">
									<div class="row"
										style="padding-left: 15px; padding-right: 15px">

										<div class="col-md-12" style="padding: 0px; padding-top: 3px;">
											<div class="col-md-3 col-sm-3 col-xs-6 text-center"
												style="padding: 0px; margin-top: 2px;">
												<span
													style="color: #40b7fb; font-size: 20px; font-weight: bold;">Thống
													k&ecirc; ngày</span>
											</div>
											<div class="col-md-3 col-sm-3 col-xs-6" style="padding: 0px">
												<select id="indexType" class="form-control"
													style="width: 98%; margin-top: 2px"
													name="typeDateStatistic">
													<option value="aqi">AQI</option>
													<c:forEach var="liStatParams" items="${liStatParams}">
														<option
															value="<c:out value="${liStatParams.statName}" escapeXml="true"/>"
															<c:if test="${typeDateStatistic eq liStatParams.statName}">selected</c:if>>
															<c:out value="${liStatParams.note}" escapeXml="true" />
														</option>
													</c:forEach>
												</select>
											</div>

											<div class="col-md-2 col-sm-2 col-xs-6" style="padding: 0px">
												<input id="datepicker" class="form-control datepicker"
													type="text" name="selDate"
													style="width: 98%; margin-top: 2px;"
													value="${displayInfo.selDate}"></input>
											</div>
											<div class="col-md-3 col-sm-2 col-xs-6" style="padding: 0px">
												<button type="submit" id="btnSubmit" 
													class="button medium hover-thin cyan"
													style="margin-top: 2px;">Thực hiện</button>
											</div>
										</div>

									</div>
									<div class="col-md-12"
										style="padding-left: 15px; padding-right: 15px; margin-top: 10px">
										<div class="col-md-12" style="border-bottom: 1px solid #eee;"></div>
									</div>
									<div class="col-md-12">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="col-md-12 col-sm-12 col-xs-12"
												style="height: 250px">
												<style>
canvas {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
}
</style>
												<canvas id="canvas"
													style="margin-top: 10px; width: 100%; height: 100%"></canvas>
											</div>
										</div>
									</div>
									<div class="col-md-12 text-right" style="margin-top: 20px">
										<p style="font-style: italic; font-size: smaller;">* Biểu
											đồ sử dụng giá trị AQI quy đổi</p>
									</div>
								</div>
								<div id="divChart2" class="row"
									style="background-color: white; box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21); margin-top: 10px; padding: 7px; margin-bottom: 15px;">
									<div class="row"
										style="padding-left: 15px; padding-right: 15px">
										<div class="col-md-12" style="padding: 0px; padding-top: 3px;">

											<div class="col-md-3 col-sm-3 col-xs-6 text-center"
												style="padding: 0px; margin-top: 2px;">
												<span
													style="color: #40b7fb; font-size: 20px; font-weight: bold;">Thống
													kê tháng</span>
											</div>
											<div class="col-md-3 col-sm-3 col-xs-6" style="padding: 0px">
												<select id="indexType" class="form-control"
													style="width: 98%; margin-top: 2px"
													name="typeMonthStatistic">
													<option value="aqi">AQI</option>
													<c:forEach var="liStatParams" items="${liStatParams}">
														<option
															value="<c:out value="${liStatParams.statName}" escapeXml="true"/>"
															<c:if test="${typeMonthStatistic eq liStatParams.statName}">selected</c:if>>
															<c:out value="${liStatParams.note}" escapeXml="true" />
														</option>
													</c:forEach>
												</select>
											</div>

											<div class="col-md-2 col-sm-2 col-xs-6" style="padding: 0px">
												<input id="monthpicker2" class="form-control monthpicker"
													type="text" name="selMonth"
													style="width: 98%; margin-top: 2px"
													value="${displayInfo.selMonth}">
											</div>
											<div class="col-md-3 col-sm-2 col-xs-6" style="padding: 0px">
												<button type="submit" class="button medium hover-thin cyan"
													style="margin-top: 2px;">Thực hiện</button>
											</div>

										</div>
									</div>
									<div class="col-md-12"
										style="padding-left: 15px; padding-right: 15px; margin-top: 10px">
										<div class="col-md-12" style="border-bottom: 1px solid #eee;"></div>
									</div>
									<div class="col-md-12">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="col-md-12 col-sm-12 col-xs-12"
												style="height: 250px">
												<style>
canvas {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
}
</style>
												<canvas id="canvas2"
													style="margin-top: 10px; width: 100%; height: 100%;"></canvas>
											</div>
										</div>
									</div>
									<div class="col-md-12 text-right" style="margin-top: 20px">
										<p style="font-style: italic; font-size: smaller;">* Biểu
											đồ sử dụng gi&aacute; trị AQI quy đổi</p>
									</div>
								</div>
						</div>
						<!-- </form>-->
						<div id="divEnd" class="col-md-6" style="padding-right: 0px;">
							<div id="divMap" class="row"
								style="margin: 0px; box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21); padding: 0px;">
								<div id="mapGoogle" style="width: 100%"></div>
							</div>
							<div id="divInfo" class="row text-center"
								style="background-color: white; box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21); margin: 0px; margin-bottom: 10px; margin-top: 10px; padding-top: 15px;">
								<div data-toggle="tooltip" data-placement="top"
									title="0 - 50 : Chất lượng kh&ocirc;ng kh&iacute; tốt"
									class="col-md-2 col-sm-2 col-xs-4 col-md-offset-1 col-sm-offset-1"
									style="padding: 0px;">
									<img src="view/asset/img/icon_detail_green.png"
										style="margin-bottom: 5px">
									<p>Tốt</p>
								</div>
								<div data-toggle="tooltip" data-placement="top"
									title="51 - 100 : Nh&oacute;m nhạy cảm n&ecirc;n hạn chế thời gian ở b&ecirc;n ngo&agrave;i"
									class="col-md-2 col-sm-2 col-xs-4" style="padding: 0px;">
									<img src="view/asset/img/icon_detail_yellow.png"
										style="margin-bottom: 5px">
									<p>Trung b&igrave;nh</p>
								</div>
								<div data-toggle="tooltip" data-placement="top"
									title="101 - 200 : Nh&oacute;m nhạy cảm cần hạn chế thời gian ở b&ecirc;n ngo&agrave;i"
									class="col-md-2 col-sm-2 col-xs-4" style="padding: 0px;">
									<img src="view/asset/img/icon_detail_orange.png"
										style="margin-bottom: 5px">
									<p>K&eacute;m</p>
								</div>
								<div data-toggle="tooltip" data-placement="top"
									title="201 - 300 : Nh&oacute;m nhạy cảm tr&aacute;nh ra ngo&agrave;i. Những người kh&aacute;c hạn chế ở b&ecirc;n ngo&agrave;i"
									class="col-md-2 col-sm-2 col-xs-4" style="padding: 0px;">
									<img src="view/asset/img/icon_detail_red.png"
										style="margin-bottom: 5px">
									<p>Xấu</p>
								</div>
								<div data-toggle="tooltip" data-placement="top"
									title="300+ : Mọi người n&ecirc;n ở trong nh&agrave;"
									class="col-md-2 col-sm-2 col-xs-4" style="padding: 0px;">
									<img src="view/asset/img/icon_detail_brown.png"
										style="margin-bottom: 5px">
									<p>Nguy hiểm</p>
								</div>
							</div>

							<!--<form>  -->
								<div id="divChart3" class="row"
									style="background-color: white; box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21); margin: 0px; margin-bottom: 15px; margin-top: 15px; padding-top: 15px;">

									<div class="row"
										style="padding-left: 15px; padding-right: 15px">

										<div class="col-md-12" style="padding: 0px;">
											<div class="col-md-5 col-sm-6 col-xs-6 text-center"
												style="padding: 0px; margin-top: 2px;">
												<span
													style="color: #40b7fb; font-size: 18px; font-weight: bold;">Tỷ
													lệ thời gian &ocirc; nhiễm</span>
											</div>
											<div class="col-md-4 col-sm-4 col-xs-6" style="padding: 0px">
												<input id="datepicker3" class="form-control datepicker"
													value="${displayInfo.selDate3}" name="selDate3"
													style="width: 98%; margin-top: 2px;">
											</div>
											<div class="col-md-3 col-sm-2 col-xs-6" style="padding: 0px">
												<button type="submit" 
													class="button medium hover-thin cyan"
													style="margin-top: 2px;">Thực hiện</button>
											</div>
										</div>
									</div>

									<div class="col-md-12"
										style="padding-left: 15px; padding-right: 15px; margin-top: 10px">
										<div class="col-md-12" style="border-bottom: 1px solid #eee;"></div>
									</div>
									<div class="col-md-12">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="col-md-12 col-sm-12 col-xs-12"
												style="height: 250px">
												<style>
canvas {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
}
</style>
												<canvas id="canvas3"
													style="margin-top: 10px; width: 100%; height: 100%;"></canvas>
											</div>
										</div>
									</div>

									<div class="col-md-12 text-right" style="margin-top: 20px">
										<p style="font-style: italic; font-size: smaller;">* Biểu
											đồ sử dụng gi&aacute; trị AQI quy đổi</p>
									</div>

								</div>
							<!-- </form> -->
						</div>

						<!-- div table -->

						<!-- <form> -->
							<div class="col-md-12"
								style="padding-right: 0px; padding-bottom: 30px;">
								<div class="row"
									style="background-color: white; box-shadow: 0 1px 6px 1px rgba(0, 0, 0, 0.21); margin-right: 0px; padding-bottom: 7px;">
									<h3
										style="color: #40b7fb; font-size: 20px; font-weight: bold; margin-left: 20px;">Truy
										vấn dữ liệu đo</h3>

									<div class="col-md-5 col-sm-5 col-xs-12">
										<!-- <div class="form-group"> -->
										<label class="col-md-3 col-sm-4 col-xs-6 control-label">Thời
											gian</label>
										<div class="col-md-9 col-sm-8 col-xs-6">
											<input id="datepicker4" class="form-control datepicker"
												value="${displayInfo.selDate4}" name="selDate4"
												style="width: 98%; margin-top: 2px;">
										</div>
									</div>
									<div class="col-md-3 col-sm-2 col-xs-6">
										<button type="submit" id="btnSubmit"
											class="button medium hover-thin cyan" style="margin-top: 2px;">Thực hiện</button>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12"
										style="margin-top: 30px; margin-bottom: 30px">
										<div class="table-responsive mb-40" id="tableContainer">
										
											<table class="table" id="sample_1">
												<thead>
													<tr role="row">
														<th class="text-center col-no sorting_asc" tabindex="0"
															aria-controls="sample_1" rowspan="1" colspan="1"
															aria-sort="ascending"
															aria-label="STT: activate to sort column descending"
															style="width: 26px;">STT</th>
														<th class="col-time sorting" tabindex="0"
															aria-controls="sample_1" rowspan="1" colspan="1"
															aria-label="Ng&amp;agrave;y: activate to sort column ascending"
															style="width: 60px;">Ngày</th>
														<th class="col-time sorting" tabindex="0"
															aria-controls="sample_1" rowspan="1" colspan="1"
															aria-label="Giờ: activate to sort column ascending"
															style="width: 60px;">Giờ</th>
														<th class="col-value sorting" tabindex="0"
															aria-controls="sample_1" rowspan="1" colspan="1"
															aria-label="Nhiệt độ (°C): activate to sort column ascending"
															style="width: 104px;">Nhiệt độ (°C)</th>
														<th class="sorting" tabindex="0" aria-controls="sample_1"
															rowspan="1" colspan="1"
															aria-label="Độ ẩm (%): activate to sort column ascending"
															style="width: 68px;">Độ ẩm (%)</th>
															<!--  
														<th class="sorting" tabindex="0" aria-controls="sample_1"
															rowspan="1" colspan="1"
															aria-label="&amp;Aacute;p suất (pa): activate to sort column ascending"
															style="width: 81px;">Áp suất (pa)</th>
															-->
														<th class="sorting" tabindex="0" aria-controls="sample_1"
															rowspan="1" colspan="1"
															aria-label="CO (ppm): activate to sort column ascending"
															style="width: 64px;">CO (ppm)</th>
														<th class="sorting" tabindex="0" aria-controls="sample_1"
															rowspan="1" colspan="1"
															aria-label="NO2 (ppm): activate to sort column ascending"
															style="width: 73px;">C2H5-OH (ppm)</th>
														<th class="sorting" tabindex="0" aria-controls="sample_1"
															rowspan="1" colspan="1"
															aria-label="SO2 (ppm): activate to sort column ascending"
															style="width: 71px;">C7H8 (ppm)</th>
														<th class="sorting" tabindex="0" aria-controls="sample_1"
															rowspan="1" colspan="1"
															aria-label="O3 (ppm): activate to sort column ascending"
															style="width: 63px;">C3H6O (ppm)</th>
														<th class="sorting" tabindex="0" aria-controls="sample_1"
															rowspan="1" colspan="1"
															aria-label="O3 (ppm): activate to sort column ascending"
															style="width: 63px;">CO2 (ppm)</th>
														
													</tr>
												</thead>

												<tbody>
													<c:forEach var="record" items="${displayInfo.listRecord}">
														<tr role="row" class="odd">
															<td class="text-center col-no sorting_1">${record.stt}</td>
															<td class=" col-time">${record.dateRecord}</td>
															<td class=" col-time">${record.timeRecord}</td>
															<td class=" col-value">${record.temp}</td>
															<td>${record.humi}</td>
															<td>${record.co}</td>
															<td>${record.ethanol}</td>
															<td>${record.toluene}</td>
															<td>${record.acetone}</td>
															<td>${record.co2}</td>
															
														</tr>
													</c:forEach>
												</tbody>

											</table>

											<!-- Begin vung paging -->
											<c:if test="${displayInfo.totalPage > 1 }">
												<div class="dataTables_paginate paging_bootstrap_number"
													id="sample_1_paginate">
													<ul class="pagination" style="visibility: visible;">
														<!-- phan next -->
														<c:if test="${displayInfo.pageFirstBack >= 0}">
															<li class="prev disabled"><a
																href="DisplayAQI.do?type=paging&currentPage=${displayInfo.pageFirstBack }&selDate4=${displayInfo.selDate4}"
																title="Prev">&lt;&lt;</a></li>
														</c:if>
														<!-- End phan next -->


														<c:forEach items="${displayInfo.listPaging}" var="page">
															<c:if test="${page == displayInfo.currentPage}">
															<li class="active"><a
																href="DisplayAQI.do?type=paging&currentPage=${page}&selDate4=${displayInfo.selDate4}">${page}</a></li>
															</c:if>
															<c:if test="${page != displayInfo.currentPage}">
															<li><a
																href="DisplayAQI.do?type=paging&currentPage=${page}&selDate4=${displayInfo.selDate4}">${page}</a>
															</li>
															</c:if>
															
															
														</c:forEach>
														<!-- phan next -->

														<c:if
															test="${displayInfo.pageFirstNext <= displayInfo.totalPage}">
															<li class="next"><a
																href="DisplayAQI.do?type=paging&currentPage=${displayInfo.pageFirstNext }&selDate4=${displayInfo.selDate4}"
																title="Next">&gt;&gt;</a></li>
														</c:if>
														<!-- End phan next -->
													</ul>
												</div>
											</c:if>

											

										</div>
									</div>
								</div>
							</div>
						<!-- </form> -->

					</div>
					 </form> 
				</div>
			</div>

			<div class="col-md-12" style="margin-top: 10px; padding: 5px">
				<div
					style="background: #FFFFFF; box-shadow: -1px 1px 10px 1px rgba(0, 0, 0, 0.21);">
				</div>
			</div>
		</div>
	</div>

	<footer class="footerCustom">
		<div class="container">
			<p class="textFooter">
				<img src="view/asset/img/logo_bk.png" width="25px">
				&emsp;Powered by <a href="#">LAB thầy Nguyễn Hoàng Dũng</a><br>

			</p>
		</div>
		<div id="map2" style="width: 100%;"></div>
	</footer>

	<script src="view/asset/js/chartJS/Chart.bundle.js"></script>
	<script src="view/asset/js/chartJS/utils.js"></script>
	<script src="view/asset/js/leaflet.js"></script>
	<script src="view/asset/js/bootstrap-datepicker.js"></script>

	<script
		src="https://maps.google.com/maps/api/js?key=AIzaSyBrDdWn62iUUAq5ft_HzGME9tbLv-k10Vg&callback=initMap"
		type="text/javascript"></script>


	<div id="alert" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Lỗi</h4>
				</div>
				<div class="modal-body">
					<p id="message"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Đ&oacute;ng</button>
				</div>
			</div>

		</div>
	</div>


	<script type="text/javascript">
		function setMargin() {
			divNumber = $("#divNumber").width();
			pinIcon = $("#pinIcon").width();
			aqis = $("#aqis").width();
			margin = (divNumber - (pinIcon + aqis + 10)) / 2;
			$("#pinIcon").css('margin-left', margin + 'px');
		}

		$(function() {
			showHideAQI(1);
			setMargin();
			setHeightMap();
			window.onresize = function(event) {
				setMargin();
				setHeightMap();
			};

			$('[data-toggle="tooltip"]').tooltip();

			function showHideAQI(data) {
				if (data) {
					$("#aqiNomal").css("display", "block");
					$("#aqiHightLevel").css("display", "none");
					$("#receivedDate").css("display", "table-cell");
					$("#receivedDateHight").css("display", "none");
				} else {
					$("#aqiNomal").css("display", "none");
					$("#aqiHightLevel").css("display", "block");
					$("#receivedDate").css("display", "none");
					$("#receivedDateHight").css("display", "table-cell");
				}
				setHeightMap();
			}

			// change date chart 1 - bar
			$('#datepicker').datepicker({
				format : "yyyy-mm-dd",
			})
			// change month chart 2 - bar
			$('#monthpicker2').datepicker({
				format : "yyyy-mm",
				viewMode : "months",
				minViewMode : "months",
			});

			// change date chart 3 - Pie
			$('#datepicker3').datepicker({
				format : "yyyy-mm-dd",
			});

			// date div table
			$('#datepicker4').datepicker({
				format : "yyyy-mm-dd",
			});
			$('#datepicker4').val(thisDateFormat);

		})
		function setHeightMap() {
			var div1 = $("#div1").height();
			var div2 = $("#div2").height();
			var div3 = $("#div3").height();
			var div35 = $("#div35").height();
			var div4 = $("#div4").height();
			var divInfo = $("#divInfo").height();
			if ($(window).width() > 768) {
				height = div1 + div2 + div3 + div35 + div4 - divInfo + 55;
				$("#divMap").height(height);
				$("#mapGoogle").height(height);
			} else {
				$("#divEnd").css("padding-left", "0px");
				$("#divMap").height(250);
				$("#mapGoogle").height(250);
			}
		}

		// initialize the map on the "map" div with a given center and zoom
		latDefault = ${displayInfo.latitude};
		lngDefault = ${displayInfo.longitude};
		myLatLng = new google.maps.LatLng(latDefault, lngDefault);
		var map = new google.maps.Map(document.getElementById('mapGoogle'), {
			zoom : 14,
			center : myLatLng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		});

		var marker = new google.maps.Marker({
			position : myLatLng,
			map : map,
			title : 'Hello World!'
		});
	</script>

	<script type="text/javascript">
		var color = Chart.helpers.color;

		// biến chart 1 - Bar
		var dataChart1 = new Array();
		dataChart1.push("${displayInfo.listParamAqiDateStat[0]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[1]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[2]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[3]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[4]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[5]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[6]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[7]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[8]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[9]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[10]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[11]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[12]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[13]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[14]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[15]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[16]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[17]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[18]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[19]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[20]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[21]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[22]}")
		dataChart1.push("${displayInfo.listParamAqiDateStat[23]}")

		// color từng cột
		colorAQI = new Array();

		colorAQI[0] = '${displayInfo.colorAQIDateStat[0]}'
		colorAQI[1] = '${displayInfo.colorAQIDateStat[1]}'
		colorAQI[2] = '${displayInfo.colorAQIDateStat[2]}'
		colorAQI[3] = '${displayInfo.colorAQIDateStat[3]}'
		colorAQI[4] = '${displayInfo.colorAQIDateStat[4]}'
		colorAQI[5] = '${displayInfo.colorAQIDateStat[5]}'
		colorAQI[6] = '${displayInfo.colorAQIDateStat[6]}'
		colorAQI[7] = '${displayInfo.colorAQIDateStat[7]}'
		colorAQI[8] = '${displayInfo.colorAQIDateStat[8]}'
		colorAQI[9] = '${displayInfo.colorAQIDateStat[9]}'
		colorAQI[10] = '${displayInfo.colorAQIDateStat[10]}'
		colorAQI[11] = '${displayInfo.colorAQIDateStat[11]}'
		colorAQI[12] = '${displayInfo.colorAQIDateStat[12]}'
		colorAQI[13] = '${displayInfo.colorAQIDateStat[13]}'
		colorAQI[14] = '${displayInfo.colorAQIDateStat[14]}'
		colorAQI[15] = '${displayInfo.colorAQIDateStat[15]}'
		colorAQI[16] = '${displayInfo.colorAQIDateStat[16]}'
		colorAQI[17] = '${displayInfo.colorAQIDateStat[17]}'
		colorAQI[18] = '${displayInfo.colorAQIDateStat[18]}'
		colorAQI[19] = '${displayInfo.colorAQIDateStat[19]}'
		colorAQI[20] = '${displayInfo.colorAQIDateStat[20]}'
		colorAQI[21] = '${displayInfo.colorAQIDateStat[21]}'
		colorAQI[22] = '${displayInfo.colorAQIDateStat[22]}'
		colorAQI[23] = '${displayInfo.colorAQIDateStat[23]}'

		// khai báo chart 1
		new Chart(document.getElementById("canvas"), {

			type : 'bar',
			data : {
				labels : [ "00h", "", "", "03h", "", "", "06h",
						"", "", "09h", "", "", "12h", "", "",
						"15h", "", "", "18h", "", "", "21h", "",
						"" ],
				datasets : [

				{
					label : "",
					backgroundColor : colorAQI,
					data : dataChart1,
				} ]
			},

			options : {
				responsive : true,
				legend : {
					display : false,
					item : {
						hidden : false
					}
				},
				scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true,
						}
					} ]
				},
				title : {
					display : false,
					text : 'Biểu đồ thống kê AQI ngay'
				}
			}
		});

		// biến chart 2 - Bar
		var dataChart2 = new Array();
		dataChart2.push("${displayInfo.listParamAqiMonthStat[0]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[1]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[2]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[3]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[4]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[5]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[6]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[7]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[8]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[9]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[10]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[11]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[12]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[13]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[14]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[15]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[16]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[17]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[18]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[19]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[20]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[21]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[22]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[23]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[24]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[25]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[26]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[27]}")
		dataChart2.push("${displayInfo.listParamAqiMonthStat[28]}")

		var colorAQI2 = new Array();
		colorAQI2.push('${displayInfo.colorAQIMonthStat[0]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[1]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[2]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[3]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[4]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[5]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[6]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[7]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[8]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[9]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[10]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[11]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[12]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[13]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[14]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[15]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[16]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[17]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[18]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[19]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[20]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[21]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[22]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[23]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[24]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[25]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[26]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[27]}')
		colorAQI2.push('${displayInfo.colorAQIMonthStat[28]}')

		var labelChart2 = new Array();
		labelChart2 = [ "1", "", "", "", "5", "", "", "", "", "10",
				"", "", "", "", "15", "", "", "", "", "20",
				"", "", "", "", "25", "", "", "" ]
		var countDayInMonth = ${displayInfo.countDayInMonth}
		switch (countDayInMonth) {
		case 29:
			labelChart2.push("")
			dataChart2.push("${displayInfo.listParamAqiMonthStat[29]}")
			colorAQI2.push('${displayInfo.colorAQIMonthStat[29]}')

			break;
		case 30:
			labelChart2.push("")
			labelChart2.push("30")
			dataChart2.push("${displayInfo.listParamAqiMonthStat[29]}")
			dataChart2.push("${displayInfo.listParamAqiMonthStat[30]}")
			colorAQI2.push('${displayInfo.colorAQIMonthStat[29]}')
			colorAQI2.push('${displayInfo.colorAQIMonthStat[30]}')

			break;
		case 31:
			labelChart2.push("")
			labelChart2.push("30")
			labelChart2.push("")
			dataChart2.push("${displayInfo.listParamAqiMonthStat[29]}")
			dataChart2.push("${displayInfo.listParamAqiMonthStat[30]}")
			dataChart2.push("${displayInfo.listParamAqiMonthStat[31]}")

			colorAQI2.push('${displayInfo.colorAQIMonthStat[29]}')
			colorAQI2.push('${displayInfo.colorAQIMonthStat[30]}')
			colorAQI2.push('${displayInfo.colorAQIMonthStat[31]}')

			break;

		default:
			break;
		}

		// khai báo chart 2

		new Chart(document.getElementById("canvas2"), {

			type : 'bar',
			data : {
				labels : labelChart2,
				datasets : [ {
					label : "",
					backgroundColor : colorAQI2,
					data : dataChart2,
				} ]
			},

			options : {
				responsive : true,
				legend : {
					display : false,
					item : {
						hidden : false
					}
				},
				scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true,
						}
					} ]
				},
				title : {
					display : false,
					text : 'Biểu đồ thống kê AQI tháng'
				}
			}
		});

		// data chart 3
		var dataChart3 = new Array();
		dataChart3.push("${displayInfo.listRatePoll[0]}")
		dataChart3.push("${displayInfo.listRatePoll[1]}")
		dataChart3.push("${displayInfo.listRatePoll[2]}")
		dataChart3.push("${displayInfo.listRatePoll[3]}")
		dataChart3.push("${displayInfo.listRatePoll[4]}")
		dataChart3.push("${displayInfo.listRatePoll[5]}")

		var labelsPie = [];
		var labelsPie = [ "Tốt", "Trung bình", "Kém", "Xấu", "Nguy hại",
				"Không có dữ liệu" ];
		var colorPieChart3 = [ "#00e400", "#ffff02", "#ff7e00", "#ff0000",
				"#7f0023", "#eee" ];
		var pieChartData = {
			datasets : [ {
				data : dataChart3,
				backgroundColor : [ "#00e400", "#ffff02", "#ff7e00", "#ff0000",
						"#7f0023", "#eee" ],
			} ],
			labels : labelsPie
		};

		var optionData = {
			responsive : true,
			legend : {
				display : false,
				item : {
					hidden : false
				}
			},
			title : {
				display : false,
			},
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true,
					}
				} ]
			}
		}

		var optionDataPie = {
			responsive : true,
			legend : {
				position : 'bottom',
			},
			title : {
				display : false,
			},
		}
		// Khai báo chart 3
		var chart3 = document.getElementById("canvas3").getContext("2d");
		window.myPie = new Chart(chart3, {
			type : 'pie',
			data : pieChartData,
			options : optionDataPie,
		});
	</script>
</body>
</html>