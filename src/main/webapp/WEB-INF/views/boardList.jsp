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
</style>

</head>
<body>
	<%@ include file="./inc/header.jsp"%>

	<div class="container">
		<div style="display: flex; justify-content: center;">
			<div class="col-lg-4 col-md-12 wow fadeInUp">
				<div class="boardListform">
					<h2 class="block-title text-center">Q & A</h2>
					<table class="table table-bordered table-custom">
						<thead>
							<tr>
								<th>글 번호</th>
								<th>제목</th>
								<th>아이디</th>
								<th>작성날짜</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<!-- 여기에 서버에서 가져온 데이터를 반복문으로 표시 -->
							<c:forEach var="list" items="${boardList}">
								<tr>
									<td>${list.b_id}</td>
									<td><a href="${pageContext.request.contextPath}/boardOneview?b_id=${list.b_id}">${list.b_title}</a></td>
									<td>${list.m_id}</td> <!-- 세션아이디 값넣기 -->
									<td>${list.b_date}</td>
									<td>${list.b_viewcnt}</td>
								</tr>
							</c:forEach>
							<a href="${pageContext.request.contextPath}/writeBoard"
								class="nav-item nav-link">Write<i
								class="fa fa-arrow-right ms-3"></i></a>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="./inc/footer.jsp"%>
</body>
</html>