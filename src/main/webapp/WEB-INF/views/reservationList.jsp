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

.red-cell {
	background-color: red;
	color: white; /* 텍스트 색상을 흰색으로 변경할 수도 있습니다. */
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
	<div>
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
            <c:forEach items="${statusList}" var="status">
                <tr>
                    <td>${status.s_checkin}</td>
                    <td>
                    	<c:choose>
                    		<c:when test="${status.s_royalSweet == '예약불가능'}">
                    			<span class="red-cell">${status.s_royalSweet}</span>
                    		</c:when>
                    		<c:otherwise>
                    			<a href="${pageContext.request.contextPath}/bookingCheck" style="color: blue;">${status.s_royalSweet}</a>
                    		</c:otherwise>
                    	</c:choose>
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${status.s_deluxe == '예약불가능'}">
                    			<span class="red-cell">${status.s_deluxe}</span>
                    		</c:when>
                    		<c:otherwise>
                    			<a href="${pageContext.request.contextPath}/bookingCheck" style="color: blue;">${status.s_deluxe}</a>
                    		</c:otherwise>
                    	</c:choose>
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${status.s_standard == '예약불가능'}">
                    			<span class="red-cell">${status.s_standard}</span>
                    		</c:when>
                    		<c:otherwise>
                    			<a href="${pageContext.request.contextPath}/bookingCheck" style="color: blue;">${status.s_standard}</a>
                    		</c:otherwise>
                    	</c:choose>
                    </td>
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