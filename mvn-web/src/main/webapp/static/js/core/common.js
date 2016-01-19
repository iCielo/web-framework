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
		if(!href){
			href =  window.location.href;
		}
		if(href.startWith(AP)){
			return href.replace(AP, "");
		}else if(href.startWith(CP)){
			return href.replace(CP, "");	
		}
	}
}());