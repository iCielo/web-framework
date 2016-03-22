<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--sidebar start-->
<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">
			<li><a href="index.html"> <i class="fa fa-dashboard"></i> <span>Dashboard</span>
			</a></li>

			<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-laptop"></i> <span>系统管理</span></a>
				<ul class="sub">
					<li><a href="javascript:;" real-href="${CP }/sys/user.do?method=listPage">用户管理</a></li>
					<li><a href="javascript:;" real-href="${CP }/sys/role.do?method=list">角色管理</a></li>
					<li><a href="javascript:;" real-href="${CP }/sys/resource.do?method=list">资源管理</a></li>
					<li><a href="javascript:;" real-href="${CP }/sys/dictionary.do?method=list">字典管理</a></li>
				</ul>
			</li>
			<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-laptop"></i> <span>代码工厂</span></a>
				<ul class="sub">
					<li><a href="javascript:;" real-href="${CP }/crud/table.do?method=list">数据库表</a></li>
					<li><a href="javascript:;" real-href="${CP }/crud/column.do?method=list">表字段</a></li>
				</ul>
			</li>

			<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-laptop"></i> <span>Layouts</span>
			</a>
				<ul class="sub">
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/boxed_page.html">Boxed Page</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/horizontal_menu.html">Horizontal Menu</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/header-color.html">Different Color Top bar</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/mega_menu.html">Mega Menu</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/language_switch_bar.html">Language Switch Bar</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/email_template.html" target="_blank">Email Template</a></li>
				</ul></li>

			<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-book"></i> <span>UI Elements</span>
			</a>
				<ul class="sub">
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/general.html">General</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/buttons.html">Buttons</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/modal.html">Modal</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/toastr.html">Toastr Notifications</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/widget.html">Widget</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/slider.html">Slider</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/nestable.html">Nestable</a></li>
					<li><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/font_awesome.html">Font Awesome</a></li>
				</ul></li>

			<!--multi level menu start-->
			<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-sitemap"></i> <span>Multi level Menu</span>
			</a>
				<ul class="sub">
					<li><a href="javascript:;">Menu Item 1</a></li>
					<li class="sub-menu"><a href="javascript:;" real-href="${CP }/static/js/lib/flatlab/boxed_page.html">Menu Item 2</a>
						<ul class="sub">
							<li><a href="javascript:;">Menu Item 2.1</a></li>
							<li class="sub-menu"><a href="javascript:;">Menu Item 3</a>
								<ul class="sub">
									<li><a href="javascript:;">Menu Item 3.1</a></li>
									<li><a href="javascript:;">Menu Item 3.2</a></li>
								</ul></li>
						</ul></li>
				</ul></li>
			<!--multi level menu end-->

		</ul>
		<!-- sidebar menu end-->
	</div>
</aside>
<!--sidebar end-->