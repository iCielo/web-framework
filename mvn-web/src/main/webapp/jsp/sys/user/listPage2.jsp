<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/base.jsp"%>
<title>首页</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').bootstrapTable({
			height : 520,
			toolbar : "",
			singleSelect : true,
			clickToSelect : true,
			pagination : "true",
			toolbarAlign : "right",
			idField : "id",
			sidePagination : "server",
			method : "post",
			contentType : "application/x-www-form-urlencoded",
			url : "${CP}/static/js/lib/bootstrap-table/data.json",
			columns : [ [ {
				checkbox : true,
				align : 'center',
				valign : 'middle'
			}, {
				title : '',
				field : 'id',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				title : '名称',
				field : 'name',
				align : 'center',
				valign : 'middle'
			}, {
				title : '金额',
				field : 'price',
				align : 'center',
				valign : 'middle'
			} ] ]
		});
	});
</script>
</head>
<body>
	<section id="container">
		<!--header-->
		<jsp:include page="../../head.jsp" />
		<!--sidebar start-->
		<jsp:include page="../../sidebar.jsp" />
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading">
								Dynamic Table 
							</header>
							<div class="panel-body">
								<table id="dataTable" data-side-pagination="server" data-pagination="false" data-height="500"></table>
							</div>
						</section>
					</div>
				</div>
			</section>
		</section>
		<!--main content end-->
		<!-- Right Slidebar -->
		<jsp:include page="../../rightSlidebar.jsp" />
		<!--footer start-->
		<jsp:include page="../../footer.jsp" />
	</section>
</body>
</html>