<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<c:choose>
	<c:when test="${MODEL=='leave'}">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script>
			$(function() {
				$("#datepicker").datepicker();
			});
		</script>
		
	</c:when>
</c:choose>

<title>homepage</title>
</head>
<body>
	<div>
		<div>
			<a href="./detail">個人資料</a>
		</div>
		<div>
			<a href="./leave">請假申請</a>
		</div>
		<div>
			<a href="./logout">登出</a>
		</div>
	</div>
	<c:choose>
		<c:when test="${MODEL=='detail'}">

			<h1>個人資料</h1>
			<dl>
				<dt>
					<b>姓名</b>
				</dt>
				<dd>${emp.realname}</dd>
				<dt>
					<b>電子郵件</b>
				</dt>
				<dd>${emp.username}</dd>
				<dt>
					<b>目前專案</b>
				</dt>
				<dd>${emp.project}</dd>
				<dt>
					<b>行動電話</b>
				</dt>
				<dd>${emp.phone}</dd>
				<dt>
					<b>工作時間</b>
				</dt>
				<dd>${fn:substring(workinghour.toworktime,0 , 5)}~${fn:substring(workinghour.offworktime,0 , 5)}</dd>
				<dt>
					<b>午休時間</b>
				</dt>
				<dd>${fn:substring(workinghour.lunchhour,0 , 5)}~${fn:substring(workinghour.afternoonworktime,0 , 5)}</dd>
			</dl>
			<form action="./alteremp">
				<input type="submit" value="修改">
			</form>
		</c:when>
		<c:when test="${MODEL=='alteremp'}">
			<h1>個人資料</h1>
			<form action="./saveemp" method="post">
				<dl>
					<dt>
						<b>姓名</b>
					</dt>
					<dd>${emp.realname}</dd>
					<dt>
						<b>電子郵件</b>
					</dt>
					<dd>${emp.username}</dd>
					<dt>
						<b>目前專案</b>
					</dt>
					<dd>
						<input type="text" name="project" value="${emp.project}">
					</dd>
					<dt>
						<b>行動電話</b>
					</dt>
					<dd>
						<input type="text" name="phone" value="${emp.phone}">
					</dd>
					<dt>
						<b>工作時間</b>
					</dt>
					<dd>
					<select name="toworktime_h" >						
						<c:forEach var="i" begin="0" end="23" varStatus="loop">
						<c:if test="${fn:substring(workinghour.toworktime,0 , 2)!=i}">
	            			<c:if test="${i<10}">
	            			
	            			<option>0${i}</option>
	            			</c:if>
            				<c:if test="${i>=10}">
            				
	            			<option>${i}</option>
            				</c:if>
            				
            			</c:if>
            			<c:if test="${fn:substring(workinghour.toworktime,0 , 2)==i}">
	            			<option selected="selected">
							${fn:substring(workinghour.toworktime,0 , 2)}
							</option>
            			</c:if>
        				</c:forEach>
					</select>
					時
					<select name="toworktime_m">
						<c:if test="${fn:substring(workinghour.toworktime,3 , 5)<30}">
							<option selected="selected">
							${fn:substring(workinghour.toworktime,3 , 5)}
							</option>
							<option>30</option>
						</c:if>
						<c:if test="${fn:substring(workinghour.toworktime,3 , 5)>0}">
						 	<option>00</option>
							<option selected="selected">
							${fn:substring(workinghour.toworktime,3 , 5)}
							</option>				
						</c:if>
					</select>
					分
					~
					<select name="offworktime_h">
						<c:forEach var="i" begin="0" end="23" varStatus="loop">
						<c:if test="${fn:substring(workinghour.offworktime,0 , 2)!=i}">
	            			<c:if test="${i<10}">
	            			
	            			<option>0${i}</option>
	            			</c:if>
            				<c:if test="${i>=10}">
            				
	            			<option>${i}</option>
            				</c:if>
            				
            			</c:if>
            			<c:if test="${fn:substring(workinghour.offworktime,0 , 2)==i}">
	            			<option selected="selected">
							${fn:substring(workinghour.offworktime,0 , 2)}
							</option>
            			</c:if>
        				</c:forEach>
					</select>
					時
					<select name="offworktime_m">
						<c:if test="${fn:substring(workinghour.offworktime,3 , 5)<30}">
							<option selected="selected">
							${fn:substring(workinghour.offworktime,3 , 5)}
							</option>
							<option>30</option>
						</c:if>
						<c:if test="${fn:substring(workinghour.offworktime,3 , 5)>0}">
						 	<option>00</option>
							<option selected="selected">
							${fn:substring(workinghour.offworktime,3 , 5)}
							</option>				
						</c:if>						
					</select>
					分
					</dd>
					
					<dt>
						<b>午休時間</b>
					</dt>
					<dd>
					<select name="lunchhour_h">						
						<c:forEach var="i" begin="0" end="23" varStatus="loop">
						<c:if test="${fn:substring(workinghour.lunchhour,0 , 2)!=i}">
	            			<c:if test="${i<10}">
	            			
	            			<option>0${i}</option>
	            			</c:if>
            				<c:if test="${i>=10}">
            				
	            			<option>${i}</option>
            				</c:if>
            				
            			</c:if>
            			<c:if test="${fn:substring(workinghour.lunchhour,0 , 2)==i}">
	            			<option selected="selected">
							${fn:substring(workinghour.lunchhour,0 , 2)}
							</option>
            			</c:if>
        				</c:forEach>
					</select>
					時
					<select name="lunchhour_m">
						<c:if test="${fn:substring(workinghour.lunchhour,3 , 5)<30}">
							<option selected="selected">
							${fn:substring(workinghour.lunchhour,3 , 5)}
							</option>
							<option>30</option>
						</c:if>
						<c:if test="${fn:substring(workinghour.lunchhour,3 , 5)>0}">
						 	<option>00</option>
							<option selected="selected">
							${fn:substring(workinghour.lunchhour,3 , 5)}
							</option>				
						</c:if>
					</select>
					分
					~
					<select name="afternoonworktime_h">
						<c:forEach var="i" begin="0" end="23" varStatus="loop">
						<c:if test="${fn:substring(workinghour.afternoonworktime,0 , 2)!=i}">
	            			<c:if test="${i<10}">
	            			
	            			<option>0${i}</option>
	            			</c:if>
            				<c:if test="${i>=10}">
            				
	            			<option>${i}</option>
            				</c:if>
            				
            			</c:if>
            			<c:if test="${fn:substring(workinghour.afternoonworktime,0 , 2)==i}">
	            			<option selected="selected">
							${fn:substring(workinghour.afternoonworktime,0 , 2)}
							</option>
            			</c:if>
        				</c:forEach>
					</select>
					時
					<select name="afternoonworktime_m">
						<c:if test="${fn:substring(workinghour.afternoonworktime,3 , 5)<30}">
							<option selected="selected">
							${fn:substring(workinghour.afternoonworktime,3 , 5)}
							</option>
							<option>30</option>
						</c:if>
						<c:if test="${fn:substring(workinghour.afternoonworktime,3 , 5)>0}">
						 	<option>00</option>
							<option selected="selected">
							${fn:substring(workinghour.afternoonworktime,3 , 5)}
							</option>				
						</c:if>
					</select>
					分
					</dd>
				</dl>
				
				
				<input type="hidden" name="username" value="${emp.username}">
				<input type="hidden" name="password" value="${emp.password}">
				<input type="hidden" name="realname" value="${emp.realname}">
				<input type="hidden" name="identity" value="${emp.identity}">
				<input type="hidden" name="department" value="${emp.department}">
			
				<input type="submit" value="儲存">
			</form>
		</c:when>



		<c:when test="${MODEL=='leave'}">
			<h1>請假申請</h1>
			<form action="./leaveAsk" method="get">
			
			<p>
				開始日期: <input type="text" name="beginleave" id="datepicker">
			</p>
			<p>
				結束日期: <input type="text" name="endleave" id="datepicker">
			</p>
			<input type="submit" value="送出">
			</form>
		</c:when>
	</c:choose>

</body>
</html>