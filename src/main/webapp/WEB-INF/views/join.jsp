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
		<div style=" display:flex; justify-content: center;">
			<div class="col-lg-4 col-md-12 wow fadeInUp">
				<div class="reservation-form">
						<div class="row g-3">
						<h2 class="block-title text-center">Join</h2>
						<form:form modelAttribute="joinForm" method="post" class="reservations-box" >
							<div class="col-12 ">
								<div class="form-floating">
								<label for="m_id">Member Id</label>
									<form:input path="m_id" placeholder="memberId" style="width: 100%;"
										required="true" data-error="ID is required." />
								</div>
								<!-- id ajax 중복체크 -->
								<span class="id_input_ok">사용 가능한 아이디입니다.</span> 
								<span class="id_input_already">중복된 아이디 입니다.</span>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="m_password">Member Password</label>
									<form:input path="m_password" placeholder="memberPassword" style="width: 100%;"
										required="true" data-error="Password is required." />
										
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating">
									<label for="m_name">Member Name</label>
									<form:input path="m_name" placeholder="memberName" style="width: 100%;"
										required="true" data-error="Name is required." />	
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating">
									<label for="m_email">Member Email</label>
									<form:input path="m_email" placeholder="memberEmail" style="width: 100%;"
										required="true" data-error="Email is required." />	
								</div>
							</div>
							<div class="col-12">
								<div class="form-floating">
									<label for="m_tel">Member Tel</label>
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
	
	<script>
    // 아이디 중복검사
    $('form input[name="m_id"]').on("propertychange change keyup paste input", function() { //form input 엘리먼트를 찾아서 중복검사 수행
        var memberId = $(this).val();
        var data = { memberId: memberId };
        $.ajax({
            type: "post",
            url: "/hotelReservaion3/memberIdChk",
            data: data,
            success: function(result) {
                if(result != 'fail'){
                    $('.id_input_ok').css("display", "inline-block");
                    $('.id_input_already').css("display", "none");
                    $('#submit').prop('disabled', false); //중복이 아닐경우 경우 제출 가능 , 버튼
                } else {
                    $('.id_input_already').css("display", "inline-block");
                    $('.id_input_ok').css("display", "none");
                    $('#submit').prop('disabled', true); //중복일경우 제출 불가능
                }
            }
        });
    });
</script>
	
</body>
</html>