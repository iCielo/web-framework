<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="base.jsp"%>

<style type="text/css">
.panel {
	margin-bottom: 0px;
}
</style>
<script type="text/javascript" src="${CP }/static/js/lib/flatlab/js/bootstrap-switch.js"></script>
<script type="text/javascript" src="${CP }/static/js/lib/nice-validator-0.10.0/jquery.validator.js?local=zh-CN"></script>

<script type="text/javascript">
	$(function() {
		$("[data-toggle='switch']").wrap('<div class="switch" data-on-label="启用"  data-off-label="禁用"/>').parent()
				.bootstrapSwitch();
	});
</script>