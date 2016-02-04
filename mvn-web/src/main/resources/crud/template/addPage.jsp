<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>${table.menuName} - 新增</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
			#foreach( $item in $columns )
			#if( ${item.rules} != '' && ${item.primaryKey} != '1' &&  ${item.javaName} != 'opUserId' &&  ${item.javaName} != 'opTime' )
			${item.javaName} : "${item.rules}",
			#end
			#end 
			}
		});
		$('#form').on('valid.form', function(e) {
			Common.ajax({
				url : "${CP}${table.controllerUrl}?method=addEntity",
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
				#foreach( $item in $columns )
				#if( ${item.primaryKey} != '1' &&  ${item.javaName} != 'opUserId' &&  ${item.javaName} != 'opTime')
					<div class="form-group">
						<label class="col-sm-2 col-xs-2 control-label">${item.label}：#if( ${item.nullable} != 1 )<span class="form-must">*</span> #end</label>
						<div class="col-sm-4 col-xs-4">
							<input class="form-control"#if( ${item.placeholder} ) placeholder=" ${item.placeholder}" #end type="text" id="${item.javaName}" name="${item.javaName}"/>
						</div>
					</div> 
				#end
				#end
				<div class="form-group">
					<div class="text-center">
						<button class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-ok"></i>&nbsp;确定</button>
						<button class="btn btn-primary" type="button" onclick="MyLayer.close();"><i class="glyphicon glyphicon-remove"></i>&nbsp;关闭</button>
					</div>
				</div>
			</form>
		</div>
	</section>
</body>
</html>