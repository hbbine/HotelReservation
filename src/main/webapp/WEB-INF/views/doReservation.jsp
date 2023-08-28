<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="./inc/header.jsp" %>


  

<!-- Header Start -->
	<div>
		<img class="img-fluid"
			src="${pageContext.request.contextPath}/resources/img/lobby.jpg"
			alt="" />
		<div class="container py-5">
			
		</div>
	</div>
	<!-- Header End -->
<body>
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
									<form:input path="r_checkin" placeholder="checkinDate"
										required="true" data-error="Checkin is required" pattern="\d{4}-\d{2}-\d{2}"
										title="Please enter a date in the format YYYY-mm-dd." />
								</div>
							</div>
							<!-- end col -->
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-box">
								<form:input path="r_checkout" placeholder="checkoutDate"
										required="true" data-error="Checkout is required." pattern="\d{4}-\d{2}-\d{2}"
										title="Please enter a date in the format YYYY-mm-dd." />
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
	<!-- end reservations-main -->
	
 <%@ include file="./inc/footer.jsp" %>
  <!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- jQuery UI -->
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

<!-- jQuery UI CSS -->
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
</body>
</html>