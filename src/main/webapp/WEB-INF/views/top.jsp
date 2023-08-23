<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>홈페이지 테스트</title>
<style type='text/css'>
td {
	font-size: 12px; /* 단위(px) 추가 */
	text-align: center;
}

a:link, a:visited, a:hover, a:active { 
	text-decoration: none;
}
</style>

<script language='javascript' type='text/javascript'>
	var muCnt = 5; 

	function fncShow(pos) {
		for (var i = 0; i < muCnt; i++) {
			var obj = document.getElementById("menu" + i);
			var obj2 = document.getElementById("m" + i);
			if (i == pos) {
				obj.style.display = '';
				obj2.style.color = "#ff0000";
			} else {
				obj.style.display = 'none';
				obj2.style.color = "#000000";
			}
		}
	}

	function fncHide(pos) {
		var obj = document.getElementById("menu" + pos);
		obj.style.display = 'none';
	}
</script>
</head>
<body>
	<div style="background-color:#FBF8EF;">
	<table cellpadding='0' cellspacing='1' border='0' width='750'>
		<tr>
			<td width='150'><a href='main.jsp' target="main"><img
					src='${pageContext.request.contextPath}/resources/img/logo.jpg' alt="업로드 실패" width='140' height='50' border='0'></a></td>
			<td>
				<table cellpadding='0' cellspacing='1' border='0' width='600'
					height='60'>
					<tr height='30'>
						<td width='100' onmouseover='fncShow(0);' id='m0'><b>Introduction</b></td>
						<td width='100' onmouseover='fncShow(1);' id='m1'><b>오시는길</b></td>
						<td width='100' onmouseover='fncShow(2);' id='m2'><b>Activity</b></td>
						<td width='100' onmouseover='fncShow(3);' id='m3'><b>Reservation</b></td>
						<td width='100' onmouseover='fncShow(4);' id='m4'><b>Q&A</b></td>
						<td width='100'></td>
					</tr>
					<tr height='30'>
						<td colspan='6'>
							<table id='menu0' style='display: none;' cellpadding='0'
								cellspacing='0' border='0' width='600' height='30'>
								<tr>
									<td width='0'></td>
									<td width='600' style='text-align: left;'>
										<a href='${pageContext.request.contextPath}/main' target="main"> 
										<span 
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | Hotel Treasure</span></a>
											 
										<a href='${pageContext.request.contextPath}/a_01' target="main"> 
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | Royal</span></a> 
											
										<a href='${pageContext.request.contextPath}/a_02' target=main>
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | Deluxe</span></a> 
											
										<a href='${pageContext.request.contextPath}/a_03' target=main>
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | Standard</span></a>
										</td>
									</tr>
							</table>
							
							<table id='menu1' style='display: none;' cellpadding='0'
								cellspacing='0' border='0' width='600' height='30'>
								<tr>
									<td width='100'></td>
									<td width='500' style='text-align: left;'>
										<a href='b_01.jsp' target="main"> 
										<span 
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 조아 리조트 찾아오는길</span></a>
											 
										<a href='b_02.jsp' target=main> 
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 대중교통이용</span></a> 
										<a href='b_03.jsp' target=main> 
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 자가용이용</span></a> 
										</td>
									</tr>
							</table>
							
							<table id='menu2' style='display: none;' cellpadding='0'
								cellspacing='0' border='0' width='600' height='30'>
								<tr>
									<td width='200'></td>
									<td width='400' style='text-align: left;'>
										<a href='c_01.jsp' target="main"> 
										<span 
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 높아산 </span></a>
											 
										<a href='c_02.jsp' target=main> 
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 조아해수욕장 </span></a> 
										<a href='c_03.jsp' target=main> 
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 따끈온천 </span></a> 
										</td>
									</tr>
							</table>
							
							
								<table id='menu3' style='display: none;' cellpadding='0'
								cellspacing='0' border='0' width='600' height='30'>
								<tr>
									<td width='300'></td>
									<td width='600' style='text-align: left;'>
										<a href='d_01.jsp' target="main"> 
										<span 
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 예약상황 </span></a>
											 
										<a href='d_02.jsp' target=main> 
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 예약하기 </span></a> 
										<a href='adm_allview.jsp' target=main> 
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 관리자 페이지 </span></a> 
										<a href='adm_logout.jsp' target=main> 
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 관리자 로그아웃 </span></a> 
										</td>
								</tr>
								</table>
								
								<table id='menu4' style='display: none;' cellpadding='0'
								cellspacing='0' border='0' width='600' height='30'>
								<tr>
									<td width='350'></td>
									<td width='250' style='text-align: left;'>
										<a href='e_01.jsp' target="main"> 
										<span 
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 리조트소식 </span></a>
											 
										<a href='e_02.jsp' target=main> 
										<span
											onmouseover="this.style.color='#ff0000'"
											onmouseout="this.style.color='#000000'"> | 이용후기 </span></a> 
										</td>
									</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
	</table>
	</div>
</body>
</html>