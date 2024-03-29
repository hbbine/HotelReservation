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
					<table class="table table-bordered table-custom">
						<thead>
							<tr>
								<th>ID</th>
								<th>Password</th>
								<th>Name</th>
								<th>Email</th>
								<th>Tel</th>
								<th>탈퇴</th>
							</tr>
						</thead>
						<tbody>
							<!-- 여기에 서버에서 가져온 데이터를 반복문으로 표시 -->
							<c:forEach var="list" items="${list}">
								<tr>
									<td><a href="${pageContext.request.contextPath}/admin/updateMemberInfo?m_id=${list.m_id}">${list.m_id}</a></td>
									<td>${list.m_password}</td>
									<td>${list.m_name}</td>
									<td>${list.m_email}</td>
									<td>${list.m_tel}</td>
									<td>
           	 							<button class="delete-button" data-m-id="${list.m_id}">탈퇴</button>
        							</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<div style="display: flex; justify-content: center;">
        			<a href="${pageContext.request.contextPath}/admin/adminPage" class="btn btn-primary" style="margin-right: 10px;">관리자페이지</a>
        			</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../inc/footer.jsp"%>
	
	<script>
	$(document).ready(function() {
	    // "삭제" 버튼 클릭 시 예약 삭제 동작 실행
	    $(".delete-button").click(function() {
	        var mId = $(this).data("m-id");
	        if (confirm("예약을 삭제하시겠습니까?")) {
	            // 삭제를 진행할 AJAX 요청을 여기에 추가
	            $.ajax({
	                url: "${pageContext.request.contextPath}/admin/deleteMember?m_id=" + mId,
	                type: "GET",
	                success: function(data) {
	                    // 삭제가 성공하면 페이지를 다시 로드하거나 예약 목록 업데이트 등의 작업을 수행할 수 있습니다.
	                    location.reload();
	                },
	                error: function() {
	                    alert("삭제 중 오류가 발생했습니다.");
	                }
	            });
	        }
	    });
	});
	</script>
</body>
</html>