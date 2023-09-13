<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	.error-message{
	color:block;
	font-weight: bold;
	fond-size: 16px;
	text-align:center;
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
			<div class="col-lg-4 col-md-12 wow fadeInUp">
				<div class="reservation-form">
						<div class="row g-3">
						<h2 class="block-title text-center">Login</h2>
						<br><br>
						<p class="error-message">로그인 정보가 틀렸습니다. 다시 입력해 주세요</p>
						<form:form modelAttribute="loginForm" method="post" class="reservations-box" >
							<div class="col-12 ">
								<div class="form-floating">
								<label for="m_id">Id</label>
									<form:input path="m_id" placeholder="memberId" style="width: 100%;"
										required="true" data-error="ID is required." />
								</div>
							</div>
							<div class="col-12 ">
								<div class="form-floating">
								<label for="m_password">Password</label>
									<form:input path="m_password" type="pasword" placeholder="memberPassword" style="width: 100%;"
										required="true" data-error="Password is required." />
								</div>
							</div>
							<div class="col-12">
								<button class="btn btn-primary w-100 py-3" type="submit" value="submit" id="submit">
									Login Now</button>
							</div>
							</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<%@ include file="./inc/footer.jsp" %>
	
</body>
</html>