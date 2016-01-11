<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String contextPath = request.getContextPath();//工程名
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ contextPath;//绝对路径，如http://localhost:8080/contextPath
	request.setAttribute("CP", contextPath);
	request.setAttribute("AP", basePath);
%>
<script type="text/javascript">
	var CP = "${contextPath}";
	var AP = "${basePath}";
</script>

<!--引入css-->
<link rel="stylesheet" type="text/css" href="${CP}/static/css/base.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/css/style.css" />

<!--引入js-->
<script type="text/javascript" src="${CP}/static/js/lib/jquery/jquery.js"></script>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<%-- <link href="${CP}/static/js/lib/sb-admin-2/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${CP}/static/js/lib/sb-admin-2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script> --%>

<!-- font-awesome -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/font-awesome-4.5.0/css/font-awesome.min.css" />
<%-- <link href="${CP}/static/js/lib/sb-admin-2/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> --%>

<!-- MetisMenu CSS -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/sb-admin-2/bower_components/metisMenu/dist/metisMenu.min.css" />
<script type="text/javascript" src="${CP}/static/js/lib/sb-admin-2/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Timeline CSS -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/sb-admin-2/dist/css/timeline.css" />

<!-- Custom CSS -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/sb-admin-2/dist/css/sb-admin-2.css" />

<!-- Morris Charts CSS -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/sb-admin-2/bower_components/morrisjs/morris.css" />

<script type="text/javascript" src="${CP}/static/js/lib/sb-admin-2/dist/js/sb-admin-2.js"></script>

<script type="text/javascript" src="${CP}/static/js/core/common.js"></script>
<script type="text/javascript" src="${CP}/static/js/app/common.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!--meta-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">