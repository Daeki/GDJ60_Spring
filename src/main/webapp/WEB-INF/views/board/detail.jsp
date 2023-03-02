<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid">
	<div class="row">
		<h1>${boardName} Detail Page</h1>
		<h3>${dto.title}</h3>
		<h3>${dto.writer}</h3>
		<p>${dto.contents}</p>
		
		<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
			<a href="./fileDown?fileNum=${fileDTO.fileNum}">${fileDTO.oriName}</a>
		</c:forEach>
		
		
		
		<div class="my-5">
			<form action="./update" id="frm">
				<c:if test="${boardName ne 'notice'}">
					<a href="./reply?num=${dto.num}" class="btn btn-danger">답글</a>
				</c:if>
				<input type="hidden" name="num" value="${dto.num}">
				<%-- <c:if test="${dto.writer eq member.id}"> --%>
				<button id="update" type="submit" class="btn btn-primary">UPDATE</button>
				<button id="delete" type="button" class="btn btn-info">DELETE</button>
				<%-- </c:if> --%>
			</form>
		</div>
		
	</div>
</div>

<c:import url="../template/common_js.jsp"></c:import>
<script type="text/javascript" src="../resources/js/boardForm.js"></script>
</body>
</html>