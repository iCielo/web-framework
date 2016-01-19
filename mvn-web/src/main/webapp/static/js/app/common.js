/**
 * 基本公共类
 */
(function(window) {
	if (typeof (Common) == "undefined") {
		Common = function() {
		};
	}

	/**
	 * 提示消息
	 * 
	 * @param message
	 *            文本或函数
	 * @param p
	 *            window对象，默认为top
	 * @returns
	 */
	Common.alert = function(message, p) {
		var option = {
			title : "消息",
			type : BootstrapDialog.TYPE_PRIMARY,
			cssClass : "modal-dialog-center modal-content-wrap",
			message : function(dialog) {
				if (typeof (msg) == "function") {
					return message(dialog);
				} else {
					return message;
				}
			},
			draggable : true,
			buttons : [ {
				id : 'btn-primary',
				label : '确定',
				cssClass : 'btn-primary',
				action : function(dialog) {
					dialog.close();
				}
			} ]
		}
		if (!p) {
			p = top;
		}
		p.dialog = p.BootstrapDialog.show(option);
		return p.dialog;
	}

	/**
	 * 警告消息
	 * 
	 * @param message
	 *            文本或函数
	 * @param p
	 *            window对象，默认为top
	 * @returns
	 */
	Common.warn = function(message, p) {
		var option = {
			title : "警告",
			type : BootstrapDialog.TYPE_WARNING,
			message : function(dialog) {
				if (typeof (msg) == "function") {
					return message(dialog);
				} else {
					return message;
				}
			},
			draggable : true,
			buttons : [ {
				id : 'btn-warning',
				label : '确定',
				cssClass : 'btn-warning',
				action : function(dialog) {
					dialog.close();
				}
			} ]
		}
		if (!p) {
			p = top;
		}
		p.dialog = p.BootstrapDialog.show(option);
		return p.dialog;
	}

	/**
	 * 错误消息
	 * 
	 * @param message
	 *            文本或函数
	 * @param p
	 *            window对象，默认为top
	 * @returns
	 */
	Common.error = function(message, p) {
		var option = {
			title : "错误",
			type : BootstrapDialog.TYPE_DANGER,
			message : function(dialog) {
				if (typeof (msg) == "function") {
					return message(dialog);
				} else {
					return message;
				}
			},
			draggable : true,
			buttons : [ {
				id : 'btn-dange',
				label : '确定',
				cssClass : 'btn-danger',
				action : function(dialog) {
					dialog.close();
				}
			} ]
		}
		if (!p) {
			p = top;
		}
		p.dialog = p.BootstrapDialog.show(option);
		return p.dialog;
	}

	/**
	 * 确认提示框
	 * 
	 * @param title
	 *            标题
	 * @param message
	 * @param yes
	 *            回调方法
	 * @param no
	 *            回调方法
	 * @param p
	 *            window对象，默认为top
	 * @returns
	 */
	Common.confirm = function(title, message, yes, no, p) {
		if (!title) {
			title = "是否提交？";
		}
		var option = {
			title : title,
			type : BootstrapDialog.TYPE_PRIMARY,
			message : function(dialog) {
				if (typeof (msg) == "function") {
					return message(dialog);
				} else {
					return message;
				}
			},
			draggable : true,
			buttons : [ {
				id : 'btn-primary',
				label : '确定',
				icon : 'glyphicon glyphicon-check',
				cssClass : 'btn-primary',
				action : function(dialog) {
					if (typeof (yes) == "function") {
						yes();
					}
					dialog.close();
				}
			}, {
				id : 'btn-primary',
				icon : 'glyphicon glyphicon-check',
				label : '关闭',
				cssClass : 'btn-primary',
				action : function(dialog) {
					dialog.close();
				}
			} ],
			onhide : function(dialog) {
				if (typeof (no) == "function") {
					no();
				}
			}
		}
		if (!p) {
			p = top;
		}
		p.dialog = p.BootstrapDialog.show(option);
		return p.dialog;
	}

	/**
	 * 打开对话框
	 * 
	 * @param option
	 *            调用bootstrap dialog
	 *            具体参数参考：http://nakupanda.github.io/bootstrap3-dialog/
	 * @param p
	 *            window对象，默认为top
	 */
	Common.showDialog = function(option, p) {
		var defaultOption = {
			type : BootstrapDialog.TYPE_PRIMARY,
			size : BootstrapDialog.SIZE_NORMAL,
			cssClass : "",
			title : "消息标题",
			message : function(dialog) {
				var $message = $('<iframe src="' + dialog.getData('url') + '"></iframe>');
				$message.css({
					width : "100%",
					height : dialog.getData('height'),
					border : "none"
				})
				return $message;
			},
			closable : true,
			draggable : true,
			data : {
				'url' : 'remote.html',
				width : '600px',
				height : '500px'
			}
		};
		option = $.extend(true, {}, defaultOption, option);
		if (!p) {
			p = top;
		}
		p.dialog = p.BootstrapDialog.show(option);
//		setTimeout(function(){
//			p.$(".modal-dialog").css({
//				width : option.data.width
//			});
//		},5);
		return p.dialog;
	}

	/**
	 * 关闭当前对话框
	 * 
	 * @param p
	 */
	Common.closeDialog = function(p) {
		if (!p) {
			p = top;
		}
		if (p.dialog) {
			p.dialog.close();
			p.dialog = null;
		}
	}
}(window));