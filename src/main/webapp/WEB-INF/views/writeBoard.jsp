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

	<div class="container">
    <div style=" display:flex; justify-content: center;">
        <div class="col-lg-6 col-md-12 wow fadeInUp">
            <div class="reservation-form">
                <div class="row g-3">
                    <h2 class="block-title text-center">Q & A</h2>
                    <form:form modelAttribute="boardForm" method="post" class="reservations-box">
                        <div class="col-12 ">
                            <div class="form-floating">
                                <form:hidden path="b_id" placeholder="boardID" style="width: 100%;"
                                    required="true" data-error="ID is required." />
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-floating">
                                <label for="m_id">Member ID</label>
                                <form:input path="m_id" value="${m_id}"  style="width: 100%;"
                                    required="true" data-error="ID is required." />
                            </div>
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
                                <label for="b_content">Board Content</label>
                                <form:textarea path="b_content" placeholder="Board Content"
                                    style="width: 100%; height: 200px;" required="true" data-error="Content is required."></form:textarea>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-floating">
                                <label for="b_viewcnt">Board ViewCnt</label>
                                <form:input path="b_viewcnt" placeholder="boardviewcnt" style="width: 100%;"
                                    required="true" data-error="ViewCnt is required." />
                            </div>
                        </div>
                        <div class="col-12">
                            <button class="btn btn-primary w-100 py-3" type="submit" value="submit" id="submit">
                                Write</button>
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