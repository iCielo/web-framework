/**
 * 基本公共类
 */
(function(window) {

	if (typeof (MyLayer) == "undefined") {
		MyLayer = function() {
		};
	}

	/**
	 * 打开对话框
	 * 
	 * @param options
	 * @param winDom
	 */
	MyLayer.open = function(options, winDom) {
		if (typeof (winDom) == 'undefined') {
			winDom = top;
		}
		var defaultOption = {
			type : 2,
			title : '标题',
			shadeClose : true,
			shade : 0.8,
			area : [ '50%', '50%' ],
			content : ''// 可以是iframe的url
		};
		options = $.extend(true, {}, defaultOption, options);
		winDom.layer.open(options);
	}

	/**
	 * 关闭对话框
	 * 
	 * @param callback
	 *            回调方法
	 * @param winDom
	 */
	MyLayer.close = function(winDom) {
		if (typeof (winDom) == 'undefined') {
			winDom = top;
		}
		var index = winDom.layer.getFrameIndex(window.name); // 先得到当前iframe层的索引
		winDom.layer.close(index); // 再执行关闭
	}

	/**
	 * layer的对话框提示
	 * 
	 * @param content
	 * @param options
	 * @param yes
	 * @param winDom
	 *            window对象，可为空，默认为top
	 * @returns
	 */
	MyLayer.alert = function(content, options, yes, winDom) {
		if (typeof (winDom) == 'undefined') {
			winDom = top;
		}
		return winDom.layer.alert(content, options, yes);
	}

	/**
	 * 确认对话框
	 * 
	 * @param content
	 * @param options
	 * @param yes
	 *            确认回调，function
	 * @param cancel
	 *            取消回调，function
	 * @param winDom
	 *            window对象，可为空，默认为top
	 * @returns
	 */
	MyLayer.confirm = function(content, yes, cancel, options, winDom) {
		if (typeof (winDom) == 'undefined') {
			winDom = top;
		}
		var defaultOption = {
			btn : [ '确认', '取消' ]
		}

		var yesFunc = function(index) {
			if (typeof (yes) == 'function') {
				yes(index);
			}
			winDom.layer.close(index);
		};

		var cancelFunc = function(index) {
			if (typeof (cancel) == 'function') {
				cancel(index);
			}
			winDom.layer.close(index);
		};

		options = $.extend(true, {}, defaultOption, options);
		return winDom.layer.confirm(content, options, yesFunc, cancelFunc);

	}

	/**
	 * layer的消息提示
	 * 
	 * @param content
	 *            内容
	 * @param options
	 *            选项，可为空
	 * @param end
	 *            可为空，function//do something
	 * @param winDom
	 *            window对象，可为空，默认为top
	 * @returns
	 */
	MyLayer.msg = function(content, options, end, winDom) {
		if (typeof (winDom) == 'undefined') {
			winDom = top;
		}
		return winDom.layer.msg(content, options, end);
	}
}(window));