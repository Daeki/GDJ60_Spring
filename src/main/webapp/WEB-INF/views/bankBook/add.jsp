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
	<div class="row justify-content-center my-4">
		<h1 class="col-md-7 text-center">상품 등록 Page</h1>
	</div>
	
	<div class="row justify-content-center my-4">
		<form class="col-md-7" action="./add" method="post" enctype="multipart/form-data">
			<div class="mb-3">
			  <label for="bookName" class="form-label">제품명</label>
			  <input type="text" name="bookName" class="form-control" id="bookName" placeholder="제품명 입력">
			</div>
			
			<div class="mb-3">
			  <label for="bookRate" class="form-label">이자율</label>
			  <input type="text" name="bookRate" class="form-control" id="bookRate" placeholder="이자율 입력">
			</div>
	
			<div class="mb-3">
			  <label for="bookDetail" class="form-label">상세설명</label>
			  <textarea name="bookDetail" class="form-control" id="bookDetail" placeholder="설명 입력" rows="7"></textarea>
			</div>
			
			<div id="fileList">
				<!-- <div class="mb-3">
				<label for="files" class="form-label">Image</label>
				<input type="file" class="form-control" id="files" name="pic">
				</div> -->
				<button type="button" id="fileAdd">ADD</button>
			</div>
			
			
				
<!-- 	
			<div class="mb-3">
				<label class="form-label">판매여부</label>
				<div class="form-check">
				  <input class="form-check-input" checked type="radio" name="bookSale" id="bookSale1" value="1">
				  <label class="form-check-label" for="bookSale1">
				    판매중
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="bookSale" id="bookSale2" value="0">
				  <label class="form-check-label" for="bookSale2">
				    판매중단
				  </label>
				</div>		
			</div>
	 -->		
			<div class=" mb-3 form-check form-switch">
			   <label class="form-check-label" for="bookSale">판매여부</label>
			   <input name="bookSale" class="form-check-input" value="1" type="checkbox" role="switch" id="bookSale">
			</div>
			
			<div class="mb-3">
				<button class="my btn btn-danger" type="submit">등록</button>
			</div>
		
		</form>
	</div>
</div>

<script src="../resources/js/fileManger.js"></script>
<script>
	setMax(3);
	// setParam('f');
</script>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>