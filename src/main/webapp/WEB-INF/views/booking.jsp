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
<!-- 달력 오픈소스 datepicker 끝 -->

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
			<div class="col-lg-4 col-md-12 wow fadeInUp">
				<div class="reservation-form">
						<div class="row g-3">
						<h2 class="block-title text-center">Reservations</h2>
						<form:form modelAttribute="reservationForm" method="post" class="reservations-box" >
							<div class="col-12 ">
								<div class="form-floating">
									<form:hidden path="r_id" placeholder="reservationID" style="width: 100%;"
										required="true" data-error="ID is required." />
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="m_id">Member ID</label>
									<form:input path="m_id" value="${ m_id }" readonly="true" style="width: 100%;"
										required="true" data-error="ID is required." />
										
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for=r_checkin>Check In</label>
									<form:input id ="r_checkin"  path="r_checkin" placeholder="check In" type="text" style="width: 100%;"
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
									<form:input id="r_checkout" path="r_checkout" placeholder="check Out" type="text" style="width: 100%;"
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
									<form:select path="r_type" class="r_type" required="true" style="width: 100%;" >
										<form:option value="1">RoyalSweet</form:option>
										<form:option value="2">Deluxe</form:option>
										<form:option value="3">Standard</form:option>
									</form:select>		
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="r_adults">Adults</label>
										<form:select path="r_adults" class="r_adults" style="width: 100%;" required="true">
											<form:option value="1">1</form:option>
											<form:option value="2">2</form:option>
											<form:option value="3">3</form:option>
									</form:select>
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<label for="r_kids">Kids</label>
									<form:select path="r_kids" class="r_kids" style="width: 100%;"
											required="true">
											<form:option value="1">1</form:option>
											<form:option value="2">2</form:option>
											<form:option value="3">3</form:option>
									</form:select>
								</div>
							</div>
							
							<div class="col-12">
								<div class="form-floating">
									<form:hidden path="r_price" placeholder="r_price"
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
									BOOK</button>
							</div>
							</form:form>
						</div>

				</div>
			</div>
		</div>
	</div>
	
	<!-- Footer Start -->
    <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
        <div class="container py-5">
            <div class="row g-5">
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Quick Link</h4>
                    <a class="btn btn-link" href="">About Us</a>
                    <a class="btn btn-link" href="">Contact Us</a>
                    <a class="btn btn-link" href="">Privacy Policy</a>
                    <a class="btn btn-link" href="">Terms & Condition</a>
                    <a class="btn btn-link" href="">FAQs & Help</a>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Contact</h4>
                    <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA</p>
                    <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>+012 345 67890</p>
                    <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@example.com</p>
                    <div class="d-flex pt-2">
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Gallery</h4>
                    <div class="row g-2 pt-2">
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="/hotelReservaion3/resources/img/hotel1.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="/hotelReservaion3/resources/img/hotel2.jpg" alt="">
                        </div>
                      
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Newsletter</h4>
                    <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
                    <div class="position-relative mx-auto" style="max-width: 400px;">
                        <input class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                        <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="copyright">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved.

                        <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                        Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a><br><br>
                        Distributed By <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
                    </div>
                    <div class="col-md-6 text-center text-md-end">
                        <div class="footer-menu">
                            <a href="">Home</a>
                            <a href="">Cookies</a>
                            <a href="">Help</a>
                            <a href="">FQAs</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->
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