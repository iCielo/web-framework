$(function() {

	//滚动条优化
	$("html").niceScroll({
		styler : "fb",
		cursorcolor : "#e8403f",
		cursorwidth : '6',
		cursorborderradius : '10px',
		background : '#404040',
		spacebarenabled : false,
		cursorborder : '',
		autohidemode : false,
		zindex : '1000'
	});
	
	//下拉列表值初始化
	$("select[data-option-value]").each(function(){
		$(this).val($(this).attr("data-option-value"));
	});

});

// right slidebar
$(function() {

	

	jQuery('#sidebar .sub-menu > a').click(function() {
		var o = ($(this).offset());
		diff = 250 - o.top;
		if (diff > 0)
			$("#sidebar").scrollTo("-=" + Math.abs(diff), 500);
		else
			$("#sidebar").scrollTo("+=" + Math.abs(diff), 500);
	});

	$('.fa-bars').click(function() {
		if ($('#sidebar > ul').is(":visible") === true) {
			$('#main-content').css({
				'margin-left' : '0px'
			});
			$('#sidebar').css({
				'margin-left' : '-210px'
			});
			$('#sidebar > ul').hide();
			$("#container").addClass("sidebar-closed");
		} else {
			$('#main-content').css({
				'margin-left' : '210px'
			});
			$('#sidebar > ul').show();
			$('#sidebar').css({
				'margin-left' : '0'
			});
			$("#container").removeClass("sidebar-closed");
		}
	});

	function responsiveView() {
		var wSize = $(window).width();
		if (wSize <= 768) {
			$('#container').addClass('sidebar-close');
			$('#sidebar > ul').hide();
		}

		if (wSize > 768) {
			$('#container').removeClass('sidebar-close');
			$('#sidebar > ul').show();
		}
	}
	$(window).on('load', responsiveView);
	$(window).on('resize', responsiveView);

	$('.tooltips').tooltip();

	$("#sidebar").niceScroll({
		styler : "fb",
		cursorcolor : "#e8403f",
		cursorwidth : '3',
		cursorborderradius : '10px',
		background : '#404040',
		spacebarenabled : false,
		cursorborder : ''
	});

});