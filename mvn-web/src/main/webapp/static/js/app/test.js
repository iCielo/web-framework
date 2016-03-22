var script = document.createElement('script');
script.setAttribute('src', 'http://code.jquery.com/jquery-1.8.0.min.js');
document.body.appendChild(script);
var url = "http://weibo.com/aj/mblog/del?ajwvr=6";
$(".WB_frame_c .WB_cardwrap:visible").each(function() {
	var mid = $(this).attr("mid");
	var content = $(this).find(".WB_text").text().trim();
	if (!confirm("是否删除？内容：" + content)) {
		return;
	}
	if (mid) {
		$.ajax({
			url : url,
			type : "post",
			async : true,
			data : {
				mid : mid
			},
			success : function(data) {
				if (data.code && data.code == '100000') {
					$(this).remove();					
				}
			}
		});		
	}
});
