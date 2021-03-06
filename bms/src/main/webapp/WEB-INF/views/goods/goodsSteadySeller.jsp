<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<body>
	
	<div id="ad_sub_banner">
		<img width="770" height="117" src="${contextPath}/resources/image/sub_banner02.jpg">
	</div>
	
	<div class="main_book" >
		<h3>스테디셀러</h3>
		<c:forEach var="item" items="${steadyseller }" >
			<div class="book">
				<a href="${contextPath}/goods/goodsDetail.do?goodsId=${item.goodsId }"><img class="link"  src="${contextPath}/resources/image/1px.gif"> </a>
				<img width="121" height="154" src="${contextPath}/thumbnails.do?goodsId=${item.goodsId}&fileName=${item.goodsFileName}">
				<div class="title">${item.goodsTitle }</div>
				<div class="price"><fmt:formatNumber  value="${item.goodsPrice}" type="number" var="goodsPrice" />${goodsPrice}원</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>



   
   