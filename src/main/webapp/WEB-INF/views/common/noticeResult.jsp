<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row offset-md-3 col-md-3">
		<table class="table table-hover">
			<tbody>
				<c:forEach items="${list}" var="dto" varStatus="i">
					<tr>
						<td>						
						<a href="./detail?num=${dto.num}">${dto.title}</a>
						
						<c:if test="${i.first}">
							${dto.contents}
						</c:if>
						
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
	</div>