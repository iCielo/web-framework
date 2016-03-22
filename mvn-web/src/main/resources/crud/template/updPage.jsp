<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>${table.menuName} - 修改</title>
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
				url : "${CP}${table.controllerUrl}?method=updEntity",
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
				#set($entity="{entity")
				#foreach( $item in $columns )
				#if( ${item.primaryKey} == '1')
					<input type="hidden" id="${item.javaName}" name="${item.javaName}" value="${mark}${entity}.$item.javaName}">
				#end
				#end
				#foreach( $item in $columns )
				#if( ${item.primaryKey} != '1' &&  ${item.javaName} != 'opUserId' &&  ${item.javaName} != 'opTime' && ${item.inputType} != 'hidden')
					<div class="form-group">
						<label class="col-sm-3 col-xs-3 control-label">#if( ${item.nullable} != 1 )<span class="form-must">*</span>#end ${item.label}：</label>
						<div class="col-sm-8 col-xs-8">
							#if( ${item.inputType} == 'input' )
								<input class="form-control"#if( ${item.placeholder} ) placeholder=" ${item.placeholder}" #end type="input" id="${item.javaName}" name="${item.javaName}"  value="<c:out value="${mark}${entity}.$item.javaName}"/>"/>
							#end
							#if( ${item.inputType} == 'textarea' )
								<textarea class="form-control"#if( ${item.placeholder} ) placeholder=" ${item.placeholder}" #end id="${item.javaName}" name="${item.javaName}">${mark}${entity}.$item.javaName}</textarea>
							#end
							#if( ${item.inputType} == 'select' )
								<select class="form-control input-sm" id="${item.javaName}" name="${item.javaName}" data-option-value="${mark}${entity}.$item.javaName}">
									<option value="">--请选择--</option>
								</select>
							#end
							#if( ${item.inputType} == 'radio' )
								<input type="radio"  id="${item.javaName}" name="${item.javaName}"/>${item.label}
							#end
							#if( ${item.inputType} == 'check' )
								<input type="checkbox"  id="${item.javaName}" name="${item.javaName}"/>${item.label}
							#end
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