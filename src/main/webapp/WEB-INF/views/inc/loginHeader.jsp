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
                <a href="${pageContext.request.contextPath}/loginConfirm" class="nav-item nav-link active">Home</a>
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
                    <a href="${pageContext.request.contextPath}/boardList" class="nav-item nav-link">Q & A</a>
                <!--     <div class="dropdown-menu fade-down m-0">
                        <a href="team.html" class="dropdown-item">premium</a>
                        <a href="testimonial.html" class="dropdown-item">family</a>
                        <a href="testimonial.html" class="dropdown-item">couple</a>
                       
                    </div> -->
                </div>
            </div>
             <div class="nav-item dropdown">
             
              <%-- 세션에서 아이디 추출 --%>
              <%
              	String username = (String) session.getAttribute("m_id");
              %>
               <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><%= username %>님 환영합니다!</a>
                <div class="dropdown-menu fade-down m-0">
                    <a href="${pageContext.request.contextPath}/myPage" class="dropdown-item">My Page</a>    
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Logout<i class="fa fa-arrow-right ms-3"></i></a>
        </div>
    </nav>
    <!-- Navbar End -->
<body>

</body>
</html>