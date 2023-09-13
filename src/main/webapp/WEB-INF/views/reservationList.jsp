<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약을 원하시는 날짜를 선택해 주세요</title>
<style>
  body {
    font-family: Arial, sans-serif;
  }
  .container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }
  #calendar {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }
  #calendar th, #calendar td {
    padding: 10px;
    text-align: center;
  }
  #calendar th {
    background-color: #f5f5f5;
  }
  #calendar td {
    border: 1px solid #ccc;
  }
  #calendarTitle {
    font-size: 18px;
    font-weight: bold;
    padding: 10px 0;
    text-align: center;
  }
  .prev-next-buttons {
    cursor: pointer;
  }
  .prev-next-buttons:hover {
    background-color: #f5f5f5;
  }
  .reserve-button {
    margin: 3px;
    background-color: white;
    padding: 5px 10px;
    border: 1px solid #ccc;
    cursor: pointer;
  }
  .reserve-button:hover {
    background-color: #f0f0f0;
  }
</style>
</head>
<script type="text/javascript">
var today = new Date();

function buildCalendar() {
  var row = null;
  var cnt = 0;
  var calendarTable = document.getElementById("calendar");
  var calendarTableTitle = document.getElementById("calendarTitle");
  calendarTableTitle.innerHTML = today.getFullYear() + "년" + (today.getMonth() + 1) + "월";

  var firstDate = new Date(today.getFullYear(), today.getMonth(), 1);
  var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
  while (calendarTable.rows.length > 2) {
    calendarTable.deleteRow(calendarTable.rows.length - 1);
  }

//첫 번째 행에 빈 셀 추가
  row = calendarTable.insertRow();
  for (var i = 0; i < firstDate.getDay(); i++) {
    cell = row.insertCell();
    cnt += 1;
  }

//날짜 출력
  for (var i = 1; i <= lastDate.getDate(); i++) {
    cell = row.insertCell();
    cnt += 1;

    cell.setAttribute('id', i);
    cell.align = "center";

    var dateText = document.createElement('div');
    dateText.innerHTML = i;
    cell.appendChild(dateText);

    for (var j = 0; j < 3; j++) {
      var reserveButton = document.createElement('button');
      reserveButton.innerHTML = '예약가능 room ' + (j + 1);
      //reserveButton.style.border = "none";
      reserveButton.style.margin = "3px"; // 버튼 사이 간격 추가
      reserveButton.style.backgroundColor = "white"; // 배경색 하얀색으로 변경
      reserveButton.style.padding = "5px 10px"; // 내부 여백 설정
      reserveButton.onclick = function () {
        var clickedYear = today.getFullYear();
        var clickedMonth = 1 + today.getMonth();
        var clickedDate = this.parentElement.getAttribute('id');

        clickedDate = clickedDate >= 10 ? clickedDate : '0' + clickedDate;
        clickedMonth = clickedMonth >= 10 ? clickedMonth : '0' + clickedMonth;
        var clickedYMD = clickedYear + "-" + clickedMonth + "-" + clickedDate;

        opener.document.getElementById("date").value = clickedYMD;
        self.close();
      };
      cell.appendChild(reserveButton);
    }
    
	//토요일 문제 여기서 고쳐야함
    if (cnt % 7 == 0) {
     cell.innerHTML = "<font color=skyblue>" + i + "</font>";
      row = calendarTable.insertRow();
    } else{
    	cell.innerHTML = i;
    	
    }
  }


}

function prevCalendar(){
	today = new Date(today.getFullYear(), today.getMonth()-1, today.getDate());
	buildCalendar();
}

function nextCalendar(){
	today = new Date(today.getFullYear(), today.getMonth()+1, today.getDate());
	buildCalendar();
}
</script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<table>
 <c:forEach items="${allReservationList}" var="reservation">
            <tr>
                <td>${reservation.r_checkin}</td>
                <td>${reservation.r_type}</td>
            </tr>
        </c:forEach>


</table>

<div class="container">
  <table id="calendar" align="center">
    <tr>
      <td class="prev-next-buttons" align="center" onclick="prevCalendar()"> ◀ </td>
      <td colspan="5" align="center" id="calendarTitle">yyyy년 m월</td>
      <td class="prev-next-buttons" align="center" onclick="nextCalendar()"> ▶ </td>
    </tr>
    <tr>
      <th class="weekday">일</th>
      <th class="weekday">월</th>
      <th class="weekday">화</th>
      <th class="weekday">수</th>
      <th class="weekday">목</th>
      <th class="weekday">금</th>
      <th class="weekday">토</th>
    </tr>
  </table>
</div>
<%@ include file="./inc/footer.jsp" %>
<script type="text/javascript">
  buildCalendar();
  
  
  
</script>
</body>
</html>
    