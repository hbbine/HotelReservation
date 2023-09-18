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
	max-width: 800px; 
    margin: 0 auto; 
	font-size: 16px;
}

/* 표의 헤더 셀(제목 행)에 스타일을 적용합니다. */
.table-custom thead th {
	background-color: #f0f0f0;
	font-weight: bold;
	 padding: 10px;
}
/* 표의 데이터 셀에 스타일을 적용합니다. */
.table-custom tbody td {
	 padding: 10px;
}

.admin-row {
    
    color: red; 
}

.table tbody tr:hover {
    background-color: #f5f5f5; /* 호버 시 배경색 변경 */
    cursor: pointer; /* 호버 시 커서 모양 변경 (손가락 모양) */
}
</style>

</head>
<body>
<%@ include file="../inc/header.jsp" %>
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
			<div>
				<div class="boardListform">
					<h4 class="block-title text-center"> &nbsp; &nbsp; 전체 회원 예약 내역</h4>
					<br/>
					<h6 class="block-title text-left"> &nbsp; &nbsp; 클릭하면 수정하기로 들어갑니다</h6>
					<table class="table table-bordered table-custom">
						<thead>
							<tr>
								<th>예약번호</th>
								<th>id</th>
								<th>Check In</th>
								<th>Check Out</th>
								<th>Room Type</th>
								<th>Adults</th>
								<th>Kids</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
							<!-- 여기에 서버에서 가져온 데이터를 반복문으로 표시 -->
							<c:forEach var="list" items="${list}">
								<tr>
									<td>${list.r_id}</td>
									<td><a href="${pageContext.request.contextPath}/admin/updateReservation?r_id=${list.r_id}">${list.m_id}</a></td>
									<td>${list.r_checkin}</td>
									<td>${list.r_checkout}</td>
									<td>${list.r_type}</td>
									<td>${list.r_adults}</td>
									<td>${list.r_kids}</td>
									<td>${list.r_price}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../inc/footer.jsp"%>
</body>
</html>