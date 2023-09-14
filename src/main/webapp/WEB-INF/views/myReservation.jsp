<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
<style>
/* CSS 스타일을 적용할 표의 클래스를 지정합니다. */
.table-custom {
	width: 100%;
	font-size: 16px;
}

/* 표의 헤더 셀(제목 행)에 스타일을 적용합니다. */
.table-custom thead th {
	background-color: #f0f0f0;
	font-weight: bold;
}
/* 표의 데이터 셀에 스타일을 적용합니다. */
.table-custom tbody td {
	
}

.admin-row {
    
    color: red; 
}
</style>

</head>
<body>
<%@ include file="./inc/header.jsp" %>
	<!-- Header Start -->
	<div>
		<img class="img-fluid"
			src="${pageContext.request.contextPath}/resources/img/lobby3.jpg"
			alt="" />
		<div class="container py-5"></div>
	</div>
	<!-- Header End -->

	<div class="container">
		<div style="display: flex; justify-content: center;">
			<div class="col-lg-4 col-md-12 wow fadeInUp">
				<div class="boardListform">
					<h4 class="block-title text-center"> &nbsp; &nbsp;${username}님의 예약 내역</h4>
					<table class="table table-bordered table-custom">
						<thead>
							<tr>
								<th>예약번호</th>
								<th>id</th>
								<th>checkin</th>
								<th>checkout</th>
								<th>room Type</th>
								<th>adults</th>
								<th>kids</th>
								<th>price</th>
							</tr>
						</thead>
						<tbody>
							<!-- 여기에 서버에서 가져온 데이터를 반복문으로 표시 -->
							<c:forEach var="reservation" items="${myReservation}">
								<tr>
									<td>${reservation.r_id}</td>
									<td>${reservation.m_id}</td>
									<td>${reservation.r_checkin}</td>
									<td>${reservation.r_checkout}</td>
									<td>${reservation.r_type}</td>
									<td>${reservation.r_adults}</td>
									<td>${reservation.r_kids}</td>
									<td>${reservation.r_price}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="./inc/footer.jsp"%>
</body>
</html>