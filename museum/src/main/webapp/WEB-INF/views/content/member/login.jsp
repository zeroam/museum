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
			<li><a href="">회원서비스</a></li>
			<li><a href="">로그인</a></li>
			<a href="#" class="btn_visual"> <i class="fas fa-arrow-up"></i>
			</a>
		</ul>
	</div>
</section>
<section class="sub_page_body">
	<div class="inside login_page">
		<div class="login_title">
			<div>관리자 로그인</div>
		</div>
		<form action="/museum/login" method="post">
			<label for="user">아이디</label>
			<input type="text" name="user" id="user"><br/>
			<label for="pass">비밀번호</label>
			<input type="password" name="pass" id="pass"><br/>
			<input class="btn" type="submit" value="로그인">
		</form>	
	</div>
</section>
<script>
	// 로그인 실패시
	if(${login} == false) {
		alert('해당 회원 정보가 없습니다. 다시 한번 확인해 주세요.');
	}
</script>
</main>
<%@ include file="../tail.jsp"%>
