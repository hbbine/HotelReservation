<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/resources/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="">
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&amp;family=Nunito:wght@600;700;800&amp;display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${pageContext.request.contextPath}/resources/lib/animate/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
           
</head>
<body>

    <!-- Spinner Start -->
    <div id="spinner" class="bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->


   <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
        <a href="${pageContext.request.contextPath}/index" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
            <h2 class="m-0 text-primary"><img src='${pageContext.request.contextPath}/resources/img/logo.png' style="width:40px;"></img>REMERE</h2>
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                <a href="${pageContext.request.contextPath}/index" class="nav-item nav-link active">Home</a>
                <a href="${pageContext.request.contextPath}/about" class="nav-item nav-link">About</a>
      
                
                  <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Rooms</a>
                    <div class="dropdown-menu fade-down m-0">
                        <a href="${pageContext.request.contextPath}/royalsweet" class="dropdown-item">RoyalSweet</a>
                        <a href="${pageContext.request.contextPath}/deluxe" class="dropdown-item">Deluxe</a>
                        <a href="${pageContext.request.contextPath}/standard" class="dropdown-item">Standard</a>
                      
                    </div>
                </div>
                
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Reservation</a>
                    <div class="dropdown-menu fade-down m-0">
                        <a href="${pageContext.request.contextPath}/reservationList" class="dropdown-item">예약상황</a>
                        <a href="${pageContext.request.contextPath}/booking" class="dropdown-item">예약하기</a>
                        <a href="${pageContext.request.contextPath}/reservation" class="dropdown-item">관리자페이지</a>
                        <a href="${pageContext.request.contextPath}/reservation" class="dropdown-item">관리자 로그아웃</a>
                      
                    </div>
                </div>
                
                  <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Dinning</a>
                    <div class="dropdown-menu fade-down m-0">
                        <a href="team.html" class="dropdown-item">premium</a>
                        <a href="testimonial.html" class="dropdown-item">family</a>
                        <a href="testimonial.html" class="dropdown-item">couple</a>
                       
                    </div>
                </div>
                <a href="${pageContext.request.contextPath}/login" class="nav-item nav-link">Login<i class="fa fa-arrow-right ms-3"></i></a>
            </div>
            <a href="${pageContext.request.contextPath}/join" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Join Now<i class="fa fa-arrow-right ms-3"></i></a>
        </div>
    </nav>
    <!-- Navbar End -->
     <!-- Carousel Start -->
    <div class="container-fluid p-0 mb-5">
        <div class="owl-carousel header-carousel position-relative">
            <div class="owl-carousel-item position-relative">
                <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/hotel2.jpg" alt="">
                <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" style="background: rgba(24, 29, 56, .7);">
                    <div class="container">
                        <div class="row justify-content-start">
                            <div class="col-sm-10 col-lg-8">
                                <h5 class="text-primary text-uppercase mb-3 animated slideInDown">Welcome to REMERE</h5>
                                <h1 class="display-3 text-white animated slideInDown">OUTDOOR OCEAN POOL</h1>
                                <p class="fs-5 text-white mb-4 pb-2">하늘과 바다가 맞닿은 듯한 인피니티풀에서 지금껏 느껴보지 못한 영혼의 휴식을 경험해보시기 바랍니다.</p>
                                <a href="${pageContext.request.contextPath}/about" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Read More</a>
                                <a href="${pageContext.request.contextPath}/join" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Join Now</a> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="owl-carousel-item position-relative">
                <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/hotel1.jpg" alt="">
                <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" style="background: rgba(24, 29, 56, .7);">
                    <div class="container">
                        <div class="row justify-content-start">
                            <div class="col-sm-10 col-lg-8">
                                <h5 class="text-primary text-uppercase mb-3 animated slideInDown">REMERE hotel & resort</h5>
                                <h1 class="display-3 text-white animated slideInDown">Every Special Moments in REMERE</h1>
                                <p class="fs-5 text-white mb-4 pb-2">하늘 위의 작은 바다, 환상적인 오션뷰와 함께 달콤한 휴식을 즐기세요</p>
                             	<a href="${pageContext.request.contextPath}/about" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Read More</a>
                                <a href="${pageContext.request.contextPath}/join" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Join Now</a> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Carousel End -->


   <%@ include file="./inc/footer.jsp" %>
</body>
</html>