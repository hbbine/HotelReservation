<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<!-- 달력 오픈소스 datepicker 시작 -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>


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
		<div style=" display:flex; justify-content: center;">
			<div>
				<div class="reservation-form">
						<div class="row g-3">
						<h2 class="block-title text-center">Reservations</h2>
						<form:form modelAttribute="reservationForm" method="post" class="reservations-box" >
							<div class="col-12 ">
								<div class="form-floating">
									<form:hidden path="r_id" placeholder="reservationID" style="width: 100%;" value="${reservation.r_id }" 
										required="true" data-error="ID is required." />
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="m_id">Member ID</label>
									<form:input path="m_id" value="${reservation.m_id }" readonly="true" style="width: 100%;"
										required="true" data-error="ID is required." />
										
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for=r_checkin>Check In</label>
									<form:input id ="r_checkin" value="${ reservation.r_checkin }"   path="r_checkin" placeholder="check In" type="text" style="width: 100%;"
										required="true" data-error="Checkin is required" pattern="\d{4}-\d{2}-\d{2}"
										title="Please enter a date in the format YYYY-mm-dd." />
									<script>
										$(function() {
										$("#r_checkin").datepicker({
											minDate : new Date(),
											maxDate : '+365d',
											dateFormat : 'yy-mm-dd',
											showMonthAfterYear : true,
											dayNamesMin : ['월', '화', '수', '목', '금', '토', '일' ], // 요일의 한글 형식.
											monthNamesShort : ['1월', '2월', '3월', '4월', '5월', '6월', '7월',
																'8월', '9월', '10월', '11월', '12월' ] // 월의 한글 형식.
											});
										});
									</script>		
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="r_checkout">Check Out</label>
									<form:input id="r_checkout" value="${ reservation.r_checkout }"  path="r_checkout" placeholder="check Out" type="text" style="width: 100%;"
									required="true" data-error="Checkout is required." pattern="\d{4}-\d{2}-\d{2}"
									title="Please enter a date in the format YYYY-mm-dd." />
									<script>
										$(function() {
										$("#r_checkout").datepicker({
											minDate : new Date(),
											maxDate : '+365d',
											dateFormat : 'yy-mm-dd',
											showMonthAfterYear : true,
											dayNamesMin : ['월', '화', '수', '목', '금', '토', '일' ], // 요일의 한글 형식.
											monthNamesShort : ['1월', '2월', '3월', '4월', '5월', '6월', '7월',
																'8월', '9월', '10월', '11월', '12월' ] // 월의 한글 형식.
											});
										});
									</script>		
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="r_type">Room Type</label>
									<form:select path="r_type"  value="${ reservation.r_type }"  class="r_type" required="true" style="width: 100%;" >
										<form:option value="1">RoyalSweet</form:option>
										<form:option value="2">Deluxe</form:option>
										<form:option value="3">Standard</form:option>
									</form:select>	
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="r_adults">Adults</label>
										<form:select path="r_adults" value="${ reservation.r_adults }"  class="r_adults" style="width: 100%;" required="true">
											<form:option value="1">1</form:option>
											<form:option value="2">2</form:option>
											<form:option value="3">3</form:option>
									</form:select>
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="r_kids">Kids</label>
									<form:select path="r_kids" value="${ reservation.r_kids }"  class="r_kids" style="width: 100%;"
											required="true">
											<form:option value="1">1</form:option>
											<form:option value="2">2</form:option>
											<form:option value="3">3</form:option>
									</form:select>
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<form:hidden path="r_price" value="${ reservation.r_price }" placeholder="r_price"
										required="true" data-error="ID is required." />
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<form:hidden path="CONFIRMATION_PAYMENT" placeholder="CONFIRMATION_PAYMENT"
										required="true" data-error="CONFIRMATION_PAYMENT is required." />
								</div>
							</div>

							<div class="col-12">
								<button class="btn btn-primary w-100 py-3" type="submit" value="submit" id="submit">
									예약 수정</button>
							</div>
							<div class="d-flex gap-3 mt-3">
    							<a href="${pageContext.request.contextPath}/admin/reservationList" class="btn btn-custom w-45">목록</a>
							</div>
							</form:form>
						</div>

				</div>
			</div>
		</div>
	</div>
    
<script>
$(document).ready(function() {
    // 경고 창 표시 함수
    function showAlert(message) {
        alert(message);
    }

    // 경고 스크립트가 설정되어 있는 경우 실행
    var alertScript = "${param.alertScript}";
    if (alertScript && alertScript.trim() !== "") {
        showAlert(alertScript);
    }
});
</script>

    <!-- JavaScript Libraries -->
 	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/hotelReservaion3/resources/lib/wow/wow.min.js"></script>
    <script src="/hotelReservaion3/resources/lib/easing/easing.min.js"></script>
    <script src="/hotelReservaion3/resources/lib/waypoints/waypoints.min.js"></script>
    <script src="/hotelReservaion3/resources/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="/hotelReservaion3/resources/js/main.js"></script>
</body>
</html>