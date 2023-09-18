<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>관리자 페이지</title>
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
    <h2 class="block-title text-center">관리자 페이지</h2>
    <div class="container py-5"></div>
    <div style="display: flex; justify-content: center;">
    
        <a href="${pageContext.request.contextPath}/admin/reservationList" class="btn btn-primary" style="margin-right: 10px;">회원 예약 수정</a>

        <a href="/admin/editAdminPosts" class="btn btn-primary" style="margin-right: 10px;">관리자 글 수정</a>

        <a href="/admin/editRoomIntroduction" class="btn btn-primary" style="margin-right: 10px;">방 소개 수정</a>

        <a href="/admin/editMemberInfo" class="btn btn-primary" style="margin-right: 10px;">회원 정보 수정</a>
    </div>
</div>
<div class="container py-5"></div>
<%@ include file="./inc/footer.jsp"%>


</body>
</html>
