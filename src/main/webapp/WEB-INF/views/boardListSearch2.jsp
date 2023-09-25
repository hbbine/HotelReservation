<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>boardList</title>
    <style>

/* 컨테이너 스타일 */
.container-custom {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	margin-top: 20px;
}

/* 제목 스타일 */
.block-title {
	font-size: 30px;
	text-align: center;
	margin-bottom: 20px;
	font-weight: bold;
}

/* 테이블 스타일 */
.table-custom {
	width: 100%;
	font-size: 16px;
	border-collapse: collapse;
}

/* 테이블 헤더 스타일 */
.table-custom thead th {
	background-color: #f0f0f0;
	font-weight: bold;
	text-align: center;
	padding: 10px;
	border: 1px solid #ddd;
}

/* 테이블 데이터 셀 스타일 */
.table-custom tbody td {
	text-align: center;
	padding: 10px;
	border: 1px solid #ddd;
}

/* 관리자 행 스타일 */
.admin-row {
	color: red;
	font-weight: bold;
}

/* 페이지네이션 스타일 */
.pagination {
	display: flex;
	justify-content: center;
	list-style: none;
	padding: 0;
}

.pagination li {
	margin: 0 5px;
}

.pagination .page-item.active .page-link {
	background-color: white; /* 흰색 배경 */
	border-color: #06BBCC !important; /* 테두리 선 (파란색) */
	color: #06BBCC !important; /* 글자 색상 (파란색) */
}

.pagination .page-link {
	background-color: white; /* 흰색 배경 */
	border-color: #06BBCC !important; /* 테두리 선 (파란색) */
	color: #06BBCC !important; /* 글자 색상 (파란색) */
}



</style>
</head>
<body>
    <%@ include file="./inc/header.jsp" %>
    <!-- Header Start -->
    <div class="header">
        <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/lobby3.jpg" alt="" />
    </div>
    <!-- Header End -->

    <div class="container-custom">
        <div class="block-title">Q & A</div>
        <table class="table-custom">
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
                <c:forEach var="list" items="${list}">
                    <tr class="${list.is_admin ? 'admin-row' : ''}">
                        <td>${list.b_id}</td>
                        <td><a href="${pageContext.request.contextPath}/boardOneview?b_id=${list.b_id}" style="color: ${list.is_admin ? 'red' : 'inherit'};">${list.b_title}</a></td>
                        <td>${list.m_id}</td> <!-- 세션 아이디 값 넣기 -->
                        <td>${list.b_date}</td>
                        <td>${list.b_viewcnt}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
         <div style="display: flex; justify-content: flex-end;">
             <a href="${pageContext.request.contextPath}/writeBoard" class="btn btn-primary">Write</a>
         </div>

		<!-- 페이징 -->
		<div>
			<ul class="pagination">
				<!-- 이전 -->
				<li class="page-item ${newPagedto.pre}" id="pre" style="display: ${newPagedto.pre ? 'block' : 'none'};">
				<a class="page-link" href="${pageContext.request.contextPath}/boardListSearch2?page=${newPagedto.page - 1}&searchType=${newPagedto.searchType}&keyword=${newPagedto.keyword}"
				aria-label="Previous">이전</a></li>

				<!-- 현재 블록 -->
				<c:forEach var="i" begin="${newPagedto.startNum}" end="${newPagedto.lastNum}">
    				<li class="page-item ${newPagedto.page == i ? 'active' : ''}">
        			<a class="page-link" href="${pageContext.request.contextPath}/boardListSearch2?page=${i}&searchType=${newPagedto.searchType}&keyword=${newPagedto.keyword}"
            		style="${newPagedto.page == i ? 'font-weight: bold;' : ''}">${i}</a>
    			</li>
				</c:forEach>

				<!-- 다음 -->
				<li class="page-item ${newPagedto.next}" id="next" style="display: ${newPagedto.next ? 'block' : 'none'};">
				<a class="page-link" href="${pageContext.request.contextPath}/boardListSearch2?page=${newPagedto.page + 1}&searchType=${newPagedto.searchType}&keyword=${newPagedto.keyword}"
				aria-label="Next">다음</a></li>
			</ul>
		</div>


		<!-- 검색 폼 -->
		<div style="text-align: center;">
			<form action="${pageContext.request.contextPath}/boardListSearch2" method="get">
				<!-- GET 방식으로 폼 전송 -->
				<select name="searchType">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="writer">작성자</option>
				</select> <input type="text" name="keyword" />
				<button type="submit">검색</button>
			</form>
		</div>

	</div>
    <%@ include file="./inc/footer.jsp" %>
</body>
</html>