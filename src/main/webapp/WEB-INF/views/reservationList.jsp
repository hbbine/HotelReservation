<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="./inc/header.jsp" %>
</head>
<body>
<!-- Header Start -->
	<div>
		<img class="img-fluid"
			src="${pageContext.request.contextPath}/resources/img/lobby.jpg"
			alt="" />
		<div class="container py-5">
			
		</div>
	</div>
	<!-- Header End -->
	
	  <div id="reservation"
		class="reservations-main pad-top-100 pad-bottom-100">
		<div class="container">
			<div class="row">
				<div class="form-reservations-box">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="wow fadeIn" data-wow-duration="1s"
							data-wow-delay="0.1s">
							<h2 class="block-title text-center">Reservation List</h2>
						</div>
						<h4 class="form-title">RESERVATION LIST</h4>
						<p>THANKS!</p>
						
						<thead>
						<tr>
						<td>체크인날짜</td>
						<td>체크아웃날짜</td>
						<td> 방</td>
						<td> 가격</td>
						</tr>
						</thead>
						
						<tbody>
						<c:forEach items="${allReservaionList }" var = "allReservaionList">
							<tr>
							<td><c:out value="${allReservaionList.r_checkin}" /></td>
							<td><c:out value="${allReservaionList.r_checkout }" /></td>
							<td><c:out value="${allReservaionList.r_type }" /></td>
							<td><c:out value="${allReservaionList.r_price }" /></td>
							</tr>
						</c:forEach>
						</tbody>
						</div></div></div></div></div>
 <%@ include file="./inc/footer.jsp" %>
</body>
</html>