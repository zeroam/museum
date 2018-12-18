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
			<li><a href="">문화행사</a></li>
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
			<div id="sub_page_title">문화행사</div>
			<div id="contents">
				<form action="event_write" method="post" enctype="multipart/form-data">
					<input type="hidden" name="cate" value="event">
					<input type="hidden" name="author" value="${member.user}">
					<div class="news_section">
						<div class="write_sec">
							<table>
								<tr>
									<td>제목</td>
									<td><input type="text" name="title" placeholder="제목을 입력하세요." required></td>
								</tr>
								<tr>
									<td>내용</td>
									<td class="textarea"><textarea name="content" id="content" rows=20 required></textarea></td>
								</tr>
								<tr>
									<td>첨부</td>
									<td><input type="file" name="fname"></td>
								</tr>
							</table>		
						</div>
					</div>
					<div class="list_write">
						<a class="btn txtc" href="/museum/event">목록</a> <input
							class="btn txtc" type="submit" id="write" value="글쓰기" />
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
</main>
<%@ include file="../tail.jsp"%>
