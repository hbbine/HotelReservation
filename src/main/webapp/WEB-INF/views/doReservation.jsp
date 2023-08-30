<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    
	<!-- 달력 오픈소스 datepicker 시작 -->
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	<!-- 달력 오픈소스 datepicker 끝 -->

</head>
<body>
	<%@ include file="./inc/header.jsp" %>
	
	<div id="reservation"
		class="reservations-main pad-top-100 pad-bottom-100">
		<div class="container">
			<div class="row">
				<div class="form-reservations-box">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="wow fadeIn" data-wow-duration="1s"
							data-wow-delay="0.1s">
							<h2 class="block-title text-center">Reservations</h2>
						</div>
						<h4 class="form-title">BOOKING FORM</h4>
						<p>PLEASE FILL OUT ALL REQUIRED* FIELDS. THANKS!</p>

						<form:form modelAttribute="reservationForm" method="post" class="reservations-box" >
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-box">
									<form:hidden path="r_id" placeholder="reservationID"
										required="true" data-error="ID is required." />
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-box">
									<form:input path="m_id" placeholder="memberID"
										required="true" data-error="ID is required." />
								</div>
							</div>
							<!-- end col -->
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-box">
									<div class="form-box">
									<form:input id ="checkin"  path="r_checkin" placeholder="check In" type="text"
										required="true" data-error="Checkin is required" pattern="\d{4}-\d{2}-\d{2}"
										title="Please enter a date in the format YYYY-mm-dd." />
									<script>
										$(function() {
										$("#checkin").datepicker({
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
							<!-- end col -->
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-box">
								<form:input id="checkout" path="r_checkout" placeholder="check Out" type="text"
									required="true" data-error="Checkout is required." pattern="\d{4}-\d{2}-\d{2}"
									title="Please enter a date in the format YYYY-mm-dd." />
								<script>
									$(function() {
									$("#checkout").datepicker({
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
							<!-- end col -->
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
								<div class="form-box">
								<label for="r_type">roomType</label>
									<form:select path="r_type" class="roomType" required="true">
										<form:option value="1">RoyalSweet</form:option>
										<form:option value="2">Deluxe</form:option>
										<form:option value="3">Standard</form:option>
									</form:select>
								</div>
							</div>
							<!-- end col -->
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-box">
										<label for="r_adults">Adults</label>
										<form:select path="r_adults" class="r_adults" required="true">
											<form:option value="1">1</form:option>
											<form:option value="2">2</form:option>
											<form:option value="3">3</form:option>
										</form:select>
									</div>
								</div>
								<!-- end col -->
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-box">
										<label for="r_kids">Kids</label>
										<form:select path="r_kids" class="r_kids"
											required="true">
											<form:option value="1">1</form:option>
											<form:option value="2">2</form:option>
											<form:option value="3">3</form:option>
										</form:select>
									</div>
								</div>
							<!-- end col -->
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-box">
									<form:hidden path="r_price" placeholder="r_price"
										required="true" data-error="ID is required." />
								</div>
							</div>
							<!-- end col -->
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-box">
									<form:hidden path="CONFIRMATION_PAYMENT" placeholder="CONFIRMATION_PAYMENT"
										required="true" data-error="CONFIRMATION_PAYMENT is required." />
								</div>
							</div>
							<!-- end col -->
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="reserve-book-btn text-center">
									<button class="hvr-underline-from-center" type="submit"
										value="SEND" id="submit">BOOK MY TABLE</button>
								</div>
							</div>
							<!-- end col -->
						</form:form>
						<!-- end form -->
					</div>
					<!-- end col -->
				</div>
				<!-- end reservations-box -->
			</div>
			<!-- end row -->
		</div>
		<!-- end container -->
	</div>
	<%@ include file="./inc/footer.jsp" %>		
	<!-- end reservations-main -->

</body>
</html>