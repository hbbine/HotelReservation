<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
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
	<div class="reservationListform">
	<h2 class="block-title text-center">예약 상황</h2>
	<table class="table table-bordered table-custom">
        <thead>
            <tr>
                <th>Date</th>
                <th>Royal Sweet</th>
                <th>Deluxe</th>
                <th>Standard</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${statusList}" var="statusList">
                <tr>
                    <td>${statusList.s_checkin}</td>
                    
                    <td>${statusList.s_royalSweet}</td>
                    <td>${statusList.s_deluxe}</td>
                    <td>${statusList.s_standard}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
    </div>
    </div>
    </div>
      
    <%@ include file="./inc/footer.jsp" %>
  </body>
</html>