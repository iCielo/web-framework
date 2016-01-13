<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/base.jsp"%>
<title>首页</title>
</head>
<body>
	<section id="container">
		<!--header-->
		<jsp:include page="../../head.jsp" />
		<!--sidebar start-->
		<jsp:include page="../../sidebar.jsp" />
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper"></section>
		</section>
		<!--main content end-->
		<!-- Right Slidebar -->
		<jsp:include page="../../rightSlidebar.jsp" />
		<!--footer start-->
		<jsp:include page="../../footer.jsp" />
	</section>
</body>
</html>