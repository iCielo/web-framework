<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>表字段 - 修改</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				javaMethodName : "length(~255);",
				dictType : "length(~50);",
				placeholder : "length(~100);",
				tableName : "required;length(~50);",
				label : "required;length(~50);",
				columnType : "required;length(~50);",
				dictList : "length(~255);",
				inputType : "required;length(~50);",
				columnName : "required;length(~50);",
				javaName : "required;length(~50);",
				javaType : "required;length(~50);",
			}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}/crud/column.do?method=updEntity",
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
				<input type="hidden" id="id" name="id" value="${entity.id}" />				
				<input type="hidden" id="javaMethodName" name="javaMethodName" value="${entity.javaMethodName}" />
				<input type="hidden" id="primaryKey" name="primaryKey" value="${entity.primaryKey}" />
				<input type="hidden" id="nullable" name="nullable" value="${entity.nullable}" />

				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">表名</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="tableName" name="tableName"
							value="<c:out value="${entity.tableName}"/>" readonly="readonly">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">列名 </label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="columnName" name="columnName"
							value="<c:out value="${entity.columnName}"/>" readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">数据类型</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="columnType" name="columnType"
							value="<c:out value="${entity.columnType}"/>" readonly>
					</div>
					<label class="col-sm-2 col-xs-2 control-label">字符长度</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="length" name="length" value="<c:out value="${entity.length}"/>"
							readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">java名称</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="javaName" name="javaName" value="<c:out value="${entity.javaName}"/>"
							readonly>
					</div>
					<label class="col-sm-2 col-xs-2 control-label">java类型</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="javaType" name="javaType" value="<c:out value="${entity.javaType}"/>"
							readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">显示名 <span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="label" name="label" value="<c:out value="${entity.label}"/>">
					</div>
					<label class="col-sm-2 col-xs-2 control-label">输入提示 </label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="placeholder" name="placeholder"
							value="<c:out value="${entity.placeholder}"/>">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">录入类型： <span class="form-must">*</span>
					</label>
					<div class="col-sm-4 col-xs-4">
						<select class="form-control input-sm" id="inputType" name="inputType" data-option-value="${entity.inputType}">
							<option value="">--请选择--</option>
							<option value="input">输入框</option>
							<option value="textarea">文本域</option>
							<option value="select">下拉框</option>
							<option value="radio">单选框</option>
							<option value="checkbox">复选框</option>
							<option value="hidden">隐藏域</option>
							<option value="not_show">不显示</option>							
						</select>
					</div>
					<label class="col-sm-2 col-xs-2 control-label">校验规则 
					</label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="rules" name="rules" value="<c:out value="${entity.rules}"/>">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-xs-2 control-label">数据字典类型 </label>
					<div class="col-sm-4 col-xs-4">
						<select class="form-control" id="dictType" name="dictType" data-option-value="${entity.dictType}">
							<option value="">--请选择--</option>
							<c:forEach items="${sortList }" var="item">
								<option value="${item.sort }">${item.sort }</option>
							</c:forEach>
						</select>
					</div>
					<label class="col-sm-2 col-xs-2 control-label">自定义数据字典 </label>
					<div class="col-sm-4 col-xs-4">
						<input class="form-control" type="text" id="dictList" name="dictList" value="<c:out value="${entity.dictList}"/>">
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
