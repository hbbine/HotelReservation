<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%-- 로그인 정보가 있는 경우 --%>
<c:if test="${not empty sessionScope.LoginDTO}">
    <%-- 로그인 헤더를 출력합니다. --%>
    <jsp:include page="./inc/loginHeader.jsp" />
</c:if>

<%-- 로그인 정보가 없는 경우 --%>
<c:if test="${empty sessionScope.LoginDTO}">
    <%-- 일반 헤더를 출력합니다. --%>
    <jsp:include page="./inc/header.jsp" />
</c:if>    
<!-- Header Start -->
	<div>
		<img class="img-fluid"
			src="${pageContext.request.contextPath}/resources/img/lobby3.jpg"
			alt="" />
		<div class="container py-5">
			
		</div>
	</div>
<!-- Header End -->

<div class="container">
		<div style=" display:flex; justify-content: center;">
			<div class="col-lg-4 col-md-12 wow fadeInUp">
				<div class="reservation-form">
						<div class="row g-3">
						<h2 class="block-title text-center">Login</h2>
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