<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

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

	<div class="container">
		<div style=" display:flex; justify-content: center;">
			<div class="col-lg-4 col-md-12 wow fadeInUp">
				<div class="reservation-form">
						<div class="row g-3">
						<h2 class="block-title text-center">Join</h2>
						<form:form modelAttribute="joinForm" method="post" class="reservations-box" >
							<div class="col-12 ">
								<div class="form-floating">
								<label for="memberId">Member Id</label>
									<form:input path="m_id" placeholder="memberId" style="width: 100%;"
										required="true" data-error="ID is required." />
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="memberPassword">Member Password</label>
									<form:input path="m_password" placeholder="memberPassword" style="width: 100%;"
										required="true" data-error="Password is required." />
										
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating">
									<label for="memberName">Member Name</label>
									<form:input path="m_name" placeholder="memberName" style="width: 100%;"
										required="true" data-error="Name is required." />	
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating">
									<label for="memberEmail">Member Email</label>
									<form:input path="m_email" placeholder="memberEmail" style="width: 100%;"
										required="true" data-error="Email is required." />	
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating">
									<label for="memberTel">Member Tel</label>
									<form:input path="m_tel" placeholder="memberTel" style="width: 100%;"
										required="true" data-error="Tel is required." />	
								</div>
							</div>
							<div class="col-12">
								<button class="btn btn-primary w-100 py-3" type="submit" value="submit" id="submit">
									Join Now</button>
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