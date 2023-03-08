<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container-fluid">

	<div class="row justify-content-center my-4">
		<h1 class="col-md-7 text-center">${boardName} Update Page</h1>
	</div>
	
	<div class="row justify-content-center my-4">
		<form class="col-md-7" action="./update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${dto.num}">
			<div class="mb-3">
			  <label for="writer" class="form-label">작성자</label>
			  <input type="text" name="writer" readonly value="${dto.writer}" class="form-control" id="writer">
			</div>
			
			<div class="mb-3">
			  <label for="title" class="form-label">제목</label>
			  <input type="text" name="title" class="form-control" value="${dto.title}" id="title" placeholder="제목 입력">
			</div>
	
			<div class="mb-3">
			  <label for="contents" class="form-label">내용</label>
			  <textarea name="contents" class="form-control" id="contents" placeholder="내용 입력" rows="7">${dto.contents}</textarea>
			</div>
			
			<div id="fileList" class="my-5">	
				<button type="button" class="btn btn-primary" id="fileAdd">ADD</button>
				
				<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
					<div class="input-group mb-3 my-3">
						  <div class="input-group-text">
						    <input class="form-check-input mt-0 deleteCheck" type="checkbox" name="fileNum" value="${fileDTO.fileNum}" aria-label="Checkbox for following text input">
						  </div>
						  <input type="text" disabled value="${fileDTO.oriName}" class="form-control" aria-label="Text input with checkbox">
					</div>
				</c:forEach>
			</div>
						
			<div class="mb-3 my-5">
				<button class="my btn btn-danger" type="submit">글쓰기</button>
			</div>
		
		</form>
	</div>
</div>

<script src="../resources/js/fileManger.js"></script>
<script>
	setMax(5);
	setParam('addFiles');
	setCount('${dto.boardFileDTOs.size()}');
	$("#contents").summernote();
</script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>