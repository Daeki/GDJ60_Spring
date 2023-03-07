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
		<h1 class="col-md-7 text-center">${boardName} Add Page</h1>
	</div>
	
	<div class="row justify-content-center my-4">
		<form class="col-md-7" action="./add" method="post" enctype="multipart/form-data">
			<div class="mb-3">
			  <label for="writer" class="form-label">작성자</label>
			  <input type="text" name="writer" readonly value="${member.id}" class="form-control" id="writer">
			</div>
			
			<div class="mb-3">
			  <label for="title" class="form-label">제목</label>
			  <input type="text" name="title" class="form-control" id="title" placeholder="제목 입력">
			</div>
	
			<div class="mb-3">
			  <label for="contents" class="form-label">내용</label>
			  <textarea name="contents" class="form-control" id="contents" placeholder="내용 입력" rows="7"></textarea>
			</div>
			
			<div id="fileList" class="my-5">
<!--  				<div class="input-group mb-3">
					<input type="file" class="form-control" id="files" name="files">
					<button type="button" class="btn btn-outline-danger">X</button>
				</div>  -->
				<button type="button" class="btn btn-primary" id="fileAdd">ADD</button>
			</div>
						
			<div class="mb-3">
				<button class="my btn btn-danger" type="submit">글쓰기</button>
			</div>
		
		</form>
	</div>
</div>

<c:import url="../template/common_js.jsp"></c:import>
<script src="../resources/js/fileManger.js"></script>
<script>
	setMax(5);
	setParam('files');
	$("#contents").summernote();
</script>
</body>
</html>