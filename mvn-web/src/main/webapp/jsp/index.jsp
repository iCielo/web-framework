<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./common/base.jsp"%>
<title>首页</title>

<style type="text/css">
</style>

<script type="text/javascript">
	$(function() {
		$("#div_main").height($(window).height() - $(".header").height() - $("footer").height() - 51);
		$("[real-href]").click(function() {
			$("li,a").removeClass("active");
			$(this).parent().parent().siblings("a").addClass("active");
			$(this).parent().addClass("active");
			ifr_main.location.href = $(this).attr("real-href");
		});
	});
</script>
</head>
<body style="overflow: hidden;">
	<section id="container">
		<!--header-->
		<jsp:include page="head.jsp" />
		<!--sidebar start-->
		<jsp:include page="sidebar.jsp" />
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div id="div_main">
					<iframe id="ifr_main" name="ifr_main" style="width: 100%; height: 100%; border: none;" src="${CP}/sys/users/listPage"></iframe>
				</div>
			</section>
		</section>
		<!--main content end-->
		<!-- Right Slidebar -->
		<jsp:include page="rightSlidebar.jsp" />
		<!--footer start-->
		<jsp:include page="footer.jsp" />
	</section>
</body>
</html>