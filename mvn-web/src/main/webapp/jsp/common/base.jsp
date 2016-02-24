<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="dict" uri="/dict"  %>
<%
	String contextPath = request.getContextPath();//工程名
	String absolutePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ contextPath;//绝对路径，如http://localhost:8080/contextPath
	request.setAttribute("CP", contextPath);
	request.setAttribute("AP", absolutePath);
%>
<script type="text/javascript">
	var CP = "${CP}";
	var AP = "${AP}";
</script>

<!--meta-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- 基础css -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/bootstrap-table/bootstrap-table.css"/>
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/font-awesome-4.5.0/css/font-awesome.min.css" />
<!-- flatlab -->
<link rel="stylesheet" type="text/css" href="${CP }/static/js/lib/flatlab/css/style.css" />
<link rel="stylesheet" type="text/css" href="${CP }/static/js/lib/flatlab/css/style-responsive.css" />
<%-- <link rel="stylesheet" type="text/css" href="${CP }/static/js/lib/flatlab/css/bootstrap-reset.css" /> --%>
<!-- 自定义css -->
<link rel="stylesheet" type="text/css" href="${CP}/static/css/base.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/css/style.css" />

<!--基础js-->
<script type="text/javascript" src="${CP}/static/js/lib/jquery/jquery.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/jquery/jquery.form.js"></script>

<!-- layer -->
<script type="text/javascript" src="${CP}/static/js/lib/layer/layer.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/layer/myLayer.js"></script>

<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${CP }/static/js/lib/flatlab/js/jquery.scrollTo.min.js"></script>
<script type="text/javascript" src="${CP }/static/js/lib/flatlab/js/jquery.nicescroll.js"></script>
<script type="text/javascript" src="${CP}/static/js/core/lang/string.js"></script>
<script type="text/javascript" src="${CP}/static/js/core/common.js"></script>
<script type="text/javascript" src="${CP}/static/js/app/common.js"></script>
<script type="text/javascript" src="${CP}/static/js/app/base.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="${CP}/static/js/lib/html5/html5shiv.js"></script>
    <script src="${CP}/static/js/lib/html5/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->