<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>数据字典 - 修改</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				seq : "required;integer;",
				status : "required;length(~50);",
				sort : "required;length(~255);",
				remark : "length(~255);",
				dictKey : "required;length(~255);remote[${CP}/sys/dictionary.do?method=isRepeat, id, sort]",
				dictValue : "required;length(~255);",
			}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}/sys/dictionary.do?method=updEntity",
				data : $(this).serialize(),
				success : function(data) {
					if (parent.ifr_main && typeof (parent.ifr_main.query) == 'function') {
						parent.ifr_main.query();
					} else if (typeof (parent.query) == 'function') {
						parent.query();
					}
					MyLayer.close();
				}
			})
		});
	});
</script>
</head>
<body>
	<section class="panel">
		<div class="panel-body">
			<form class="form-horizontal tasi-form" method="post" id="form">
				<input type="hidden" id="id" name="id" value="${entity.id}">
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label"><span class="form-must">*</span>分类：
					</label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" type="text" id="sort" name="sort" value="<c:out value="${entity.sort}"/>" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label"><span class="form-must">*</span>字典键：
					</label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" type="text" id="dictKey" name="dictKey" value="<c:out value="${entity.dictKey}"/>" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label"><span class="form-must">*</span>字典值：
					</label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" type="text" id="dictValue" name="dictValue" value="<c:out value="${entity.dictValue}"/>" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label"><span class="form-must">*</span>排序值：
					</label>
					<div class="col-sm-8 col-xs-8">
						<input class="form-control" type="text" id="seq" name="seq" value="<c:out value="${entity.seq}"/>" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label"><span class="form-must">*</span>状态：
					</label>
					<div class="col-sm-8 col-xs-8">
						<dict:select cssClass="form-control input-sm" sort="STATUS" id="status" name="status" key="${entity.status }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 col-xs-3 control-label">备注：</label>
					<div class="col-sm-8 col-xs-8">
						<textarea class="form-control" placeholder="" id="remark" name="remark">${entity.remark}</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="text-center">
						<button class="btn btn-primary" type="submit">
							<i class="glyphicon glyphicon-ok"></i>&nbsp;确定
						</button>
						<button class="btn btn-primary" type="button" onclick="MyLayer.close();">
							<i class="glyphicon glyphicon-remove"></i>&nbsp;关闭
						</button>
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>
