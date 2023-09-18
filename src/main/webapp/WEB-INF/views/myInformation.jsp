<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<style>
    .reservation-form {
        background-color: #f8f9fa;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }

    .block-title {
        color: #333;
        font-size: 24px;
        margin-bottom: 20px;
    }

    .form-floating {
        margin-bottom: 15px;
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
		<div style=" display:flex; justify-content: center;">
			<div>
				<div class="reservation-form">
						<div class="row g-3">
						<h2 class="block-title text-center">회원정보 수정</h2>
						<form:form modelAttribute="joinForm" method="post" class="reservations-box" >
							<div class="col-12 ">
								<div class="form-floating">
								<label for="m_id">Member Id</label>
									<form:input path="m_id" value="${board.m_id}" placeholder="memberId" style="width: 100%;" readonly="true"
										required="true" data-error="ID is required." />
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="m_password">Member Password</label>
									<form:input path="m_password" value="${board.m_password}" placeholder="memberPassword" style="width: 100%;"
										required="true" data-error="Password is required." />
										
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating">
									<label for="m_name">Member Name</label>
									<form:input path="m_name" value="${board.m_name}" placeholder="memberName" style="width: 100%;"
										required="true" data-error="Name is required." />	
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating">
									<label for="m_email">Member Email</label>
									<form:input path="m_email" value="${board.m_email}" placeholder="memberEmail" style="width: 100%;"
										required="true" data-error="Email is required." />	
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating">
									<label for="m_tel">Member Tel</label>
									<form:input path="m_tel" value="${board.m_tel}" placeholder="memberTel" style="width: 100%;"
										required="true" data-error="Tel is required." />	
								</div>
							</div>
							<div class="col-12">
								<button class="btn btn-primary w-100 py-3" type="submit" value="submit" id="submit">
									수정 완료</button>
							</div>
							</form:form>
						</div>
						<div class="d-flex gap-3">
						<a href="${pageContext.request.contextPath}/deleteMember?m_id=${username}" onclick="deleteMember('${board.m_id}')"
   						class="btn btn-custom w-45"> 회원 탈퇴 </a> <!--  함수 호출방법 onclick="deleteMember('${board.m_id}')" -->
						</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="./inc/footer.jsp" %>
<script>

function deleteMember(m_id) {
    // 사용자에게 확인 메시지를 표시
    alert('정말 회원탈퇴를 진행하시겠습니까?');

    // 확인 버튼을 클릭하면 이동
    var deleteURL = '${pageContext.request.contextPath}/deleteConfirm?m_id=' + m_id;
    window.location.href = deleteURL;
}

/* function deleteMember(m_id) {
    var alertScript   = confirm('정말 회원탈퇴를 진행하시겠습니까?');

    if (alertScript == true) {
        // m_id를 URL 파라미터로 포함하여 deleteConfirm 페이지로 이동
        var deleteURL = '${pageContext.request.contextPath}/deleteConfirm?m_id=' + m_id;
        window.location.href = deleteURL;
    } else {
        // 사용자가 '취소'를 클릭한 경우, 아무 작업도 수행하지 않음
    	window.location.href = '${pageContext.request.contextPath}/myInformation';
    }
} */

</script>
</body>
</html>