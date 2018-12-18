<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp"%>
<script src="/museum/js/board.js"></script>
<!-- main -->
<main>
<section class="sub_page_pic"></section>
<section class="sub_page_loc">
	<div class="inside">
		<ul>
			<li class="home"><a href="/museum" title="홈"> <i
					class="fab fa-fort-awesome"></i>
			</a></li>
			<li><a href="">소식</a></li>
			<li><a href="">새소식</a></li>
			<a href="#" class="btn_visual"> <i class="fas fa-arrow-up"></i>
			</a>
		</ul>
	</div>
</section>
<section class="sub_page_body">
	<div class="inside">
		<div id="lnb" class="aside">
			<%@ include file="../_aside.jsp"%>
		</div>
		<!-- aside end -->
		<div class="main">
			<div id="sub_page_title">새 소식</div>
			<div id="contents">
				<form action="news_update" method="post">
					<input type="hidden" name="seq" value="${vo.seq}">
					<input type="hidden" name="cate" value="news">
					<input type="hidden" name="author" value="${member.user}">
					<div class="news_section">
						<div class="write_sec">
							<table>
								<tr>
									<td>제목</td>
									<td><input type="text" name="title" placeholder="제목을 입력하세요." value="${vo.title}" required></td>
								</tr>
								<tr>
									<td>내용</td>
									<td class="textarea">
									<textarea name="content" id="content" rows=20 required>
										${vo.content}								
									</textarea></td>
								</tr>
							</table>		
						</div>
					</div>
					<div class="list_write">
						<a class="btn txtc" href="/museum/donationlist">목록</a> <input
							class="btn txtc" type="submit" id="write" value="글수정" />
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
</main>
<%@ include file="../tail.jsp"%>
