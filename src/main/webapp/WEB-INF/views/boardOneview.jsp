<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
/* 사용자 정의 버튼 스타일 */
.btn-custom {
    background-color: white; /* 흰색 배경 */
    border-color: #06BBCC !important; /* 테두리 선 (파란색) */
    color: #06BBCC !important;  /* 글자 색상 (파란색) */
}
 .id_input_ok{
		color:green;
		display: none;
	}

	.id_input_already{
		color:red; 
		display: none;
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
        <div class="col-lg-8 col-md-12 wow fadeInUp">
				<div class="boardViewForm">
					<table class="table table-bordered table-custom">
						<tbody>
							<tr>
								<td colspan="5" style="background-color: #f0f0f0;">
									 <h4 class="text-center" style="font-weight: bold;">${board.b_title}</h4>
								</td>

							</tr>
							<tr>
								<td colspan="5">
									<div class="form-group">
										<textarea class="form-control" rows="10" readonly="true">${board.b_content}</textarea>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="1">작성자</td>
								<td colspan="3">${board.m_id}</td>
								<td colspan="1">조회수: ${board.b_viewcnt}</td>
							</tr>
						</tbody>
					</table>
					<div class="col-12 mt-3 d-flex justify-content-between align-items-center">
						<a href="${pageContext.request.contextPath}/boardList"
							class="btn btn-primary w-45"> 목록 </a>
						<div class="d-flex gap-3">
							<a href="${pageContext.request.contextPath}/updateBoard?b_id=${board.b_id}" onclick="updateBoard'${board.m_id}')"
								class="btn btn-custom w-45"> 수정 </a>
							<a href="${pageContext.request.contextPath}/deleteBoard?b_id=${board.b_id}"
								class="btn btn-custom w-45"> 삭제 </a>	
						</div>
					</div>
					<div id="alertMessage" style="display:none;"></div>
				</div>
			</div>
    </div>
</div>
	<%@ include file="./inc/footer.jsp"%>
<script>
$(document).ready(function() {
    // 경고 스크립트가 설정되어 있는 경우 실행
    var alertScript = "${param.alertScript}";
    if (alertScript && alertScript.trim() !== "") {
        eval(alertScript);
    }
});
</script>

<script>
function updateBoard(m_id) {
	var alertScript = "${param.alertScript}";
	if (alertScript && alertScript.trim() !== "") {
		eval(alertScript);
	}
}
</script>
	
</body>
</html>