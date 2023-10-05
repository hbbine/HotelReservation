<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="./inc/header.jsp" %>
	<!-- Header Start -->
	<div>
		<img class="img-fluid"
			src="${pageContext.request.contextPath}/resources/img/lobby3.jpg"
			alt="" />
		<div class="container py-5"></div>
	</div>
	<!-- Header End -->
    
    <!-- About -->

	<div class="about">
		<div class="container">

				

			<div class="row about_row">
				<!-- About Content -->
				<div class="col-lg-6">
					<div class="about_content">
					<div class="about_title"><h2>The REMERE / 10 years of excellence</h2></div>
						<div class="about_text">
							<p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse nec faucibus velit.
							Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse nec faucibus velit. Quisque eleifend orci ipsum, a bibendum lacus suscipit sit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse nec faucibus velit. Quisque eleifend orci ipsum, a bibendum lacus suscipit sit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse nec faucibus velit. Quisque eleifend orci.
							 Quisque eleifend orci ipsum, a bibendum lacus suscipit sit. </p>
						</div>
						
					</div>
				</div>
				
				<!-- About Images -->
				<div class="col-lg-6">
					<div class="about_images d-flex flex-row align-items-start justify-content-between flex-wrap">
						<div id="map" style="width: 650px; height: 300px;"></div>
						<script type="text/javascript"
							src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	7ed8d8be49cca6b786ccfaef22a8a687"></script>
						<script>
							var container = document.getElementById('map');
							var options = {
								center : new kakao.maps.LatLng( 33.564658088086865,
										 126.78332531740388 ),
								level : 3
							};

							var map = new kakao.maps.Map(container, options);
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>

			</div>
		</div>
	</div>


    <!-- Service Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-4">
                <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                    <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/hotel3-1.jpg" alt="" />
                    <div class="service-item text-center pt-3">
                            <h5>Infinity Pool</h5>
                            <p>Diam elitr kasd sed at elitr sed ipsum justo dolor sed clita amet diam</p>
                        </div>
                </div>
                     <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                    <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/gallery_05.jpg" alt="" />
                    <div class="service-item text-center pt-3">
                            <h5>Excellent Restaurant</h5>
                            <p>Dilicious food and comfortable seats available</p>
                        </div>
                </div>
                       <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                    <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/details_2.jpg" alt="" />
                    <div class="service-item text-center pt-3">
                            <h5>Comfortable Rooms</h5>
                            <p>You can relax in our Excellent rooms</p>
                        </div>
                </div>
                       <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                    <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/user_1.jpg" alt="" />
                    <div class="service-item text-center pt-3">
                            <h5>Customer Satiscation</h5>
                            <p>We do our best for our customer satisfaction</p>
                        </div>
                </div>
      
            </div>
        </div>
    </div>
    <!-- Service End -->

  <%@ include file="./inc/footer.jsp" %>
</body>

</html>

</html>