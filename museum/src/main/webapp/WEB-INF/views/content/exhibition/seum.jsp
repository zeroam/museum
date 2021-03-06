<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp"%>
<!-- main -->
<main>
<section class="sub_page_pic"></section>
<section class="sub_page_loc">
	<div class="inside">
		<ul>
			<li class="home"><a href="/museum" title="홈"> <i
					class="fab fa-fort-awesome"></i>
			</a></li>
			<li><a href="">전시</a></li>
			<li><a href="">상설전시</a></li>
			<li><a href="">국토세움실</a></li>
			<a href="#" class="btn_visual"> <i class="fas fa-arrow-up"></i>
			</a>
		</ul>
	</div>
</section>
<section class="sub_page_body">
	<div class="inside">
		<div id="lnb" class="aside">
			<%@ include file="../_aside.jsp" %>
		</div><!-- aside end -->
		<div class="main">
			<div id="sub_page_title">국토세움실</div>
			<div id="sub_page_contents"></div>
		</div>
	</div>
</section>
</main>
<%@ include file="../tail.jsp"%>
