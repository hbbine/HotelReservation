<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
 <%@ include file="./inc/header.jsp" %>

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