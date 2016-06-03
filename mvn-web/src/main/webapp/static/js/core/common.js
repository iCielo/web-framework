/**
 * 基本公共类
 */
(function() {
	if (typeof (Common) == "undefined") {
		Common = function() {
		};
	}

	/**
	 * 获取链接的相对路径
	 * 
	 * @returns
	 */
	Common.getLinkHref = function(href) {
		if (!href) {
			href = window.location.href;
		}
		if (href.startWith(AP)) {
			return href.replace(AP, "");
		} else if (href.startWith(CP)) {
			return href.replace(CP, "");
		}
	};

	/**
	 * 是否回车事件
	 * 
	 * @param event
	 * @returns {Boolean}
	 */
	Common.isEnterKey = function(event) {
		var e = event ? event : (window.event ? window.event : null);
		if (e.keyCode == 13) {
			return true;
		}
		return false;
	};

	/**
	 * 是否指定的keyCode
	 * 
	 * @param event
	 * @param keyCode
	 * @returns {Boolean}
	 */
	Common.isAppointKey = function(event, keyCode) {
		var e = event ? event : (window.event ? window.event : null);
		if (e.keyCode == keyCode) {
			return true;
		}
		return false;
	};
}());