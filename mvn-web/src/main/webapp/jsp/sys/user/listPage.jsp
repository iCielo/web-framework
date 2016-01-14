<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/base.jsp"%>
<title>首页</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			url : "${CP}/static/js/lib/bootstrap-table/data.json"
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
							<header class="panel-heading"> Dynamic Table </header>
							<div class="panel-body">
								<div id="toolbar">
									<button class="btn btn-primary ">
										<i class="glyphicon glyphicon-plus-sign"></i>&nbsp;新&nbsp;增
									</button>
									<button class="btn btn-primary">
										<i class="glyphicon glyphicon-edit"></i>&nbsp;修&nbsp;改
									</button>
									<button class="btn btn-primary ">
										<i class="glyphicon glyphicon-ok-circle"></i>启用
									</button>
									<button class="btn btn-primary ">
										<i class="glyphicon glyphicon-ban-circle"></i>禁用
									</button>
									<button class="btn btn-danger ">
										<i class="glyphicon glyphicon-remove"></i>&nbsp;删&nbsp;除
									</button>
								</div>
								<table id="dataTable">
									<thead>
										<tr>
											<th data-checkbox="true"></th>
											<th data-field="id" data-halign="center" data-align="center" data-visible="false"></th>
											<th data-field="name" data-halign="center" data-align="center">名称</th>
											<th data-field="price" data-halign="center" data-align="center">金额</th>
										</tr>
								</table>
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