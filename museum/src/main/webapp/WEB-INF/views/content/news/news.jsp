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
			<div id="sub_page_title">새소식</div>
			<div id="contents">
				<form name="searchForm" action="museum/news">
					<div class="search">
						<input type="hidden" name="page" value="1"> <select
							class="searchField" name="searchField">
							<option value="all">전체</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="author">작성자</option>
						</select> <input type="search" class="searchValue" name="searchValue"
							value="" />
						<button type="button" class="btn_search" name="btn_search">검색</button>
					</div>
				</form>
				<div class="board_count">
					<div class="ctn">
						<span>총</span> <strong>${mapper.total}</strong> <span>건</span>
					</div>
				</div>
				<div class="board_normal_list">
					<ul>
						<c:forEach var="vo" items="${voList}">
							<li><a href="/museum/news_view?seq=${vo.seq}">
									<div class="title_line">${vo.title}</div>
									<div class="info_line">
										<span>번호 : ${vo.seq}</span> <span>작성자 : ${vo.author}</span> <span>작성일
											: ${vo.rdate}</span> <span>조회수 : ${vo.hit}</span>
									</div>
							</a> <c:if test="${vo.file != 0}">
									<button class="btn_show_attach_file">
										<i class="fa fa-paperclip fa-flip-horizontal"
											aria-hidden="true"></i>
									</button>
								</c:if></li>
						</c:forEach>
						<c:if test="${voList == null}">
							<li>게시글이 없습니다.</li>
						</c:if>
					</ul>
				</div>
				<c:if test="${member.user.equals('admin')}">
					<div class="list_write">
						<a class="btn txtc" href="/museum/news_write">글쓰기</a>
					</div>
				</c:if>
				<div class="board_paging">
					<ul class="prev_btns">
						<li class="btn_first"><a href="#">1</a></li>
						<li class="btn_prev"><a href="#">${mapper.groupPre}</a></li>
					</ul>
					<ul class="num_btns">
						<c:forEach var="i" begin="${mapper.groupStart}"
							end="${mapper.groupEnd}">
							<li class="${i == mapper.page ? 'on': ''}"><a href="#">${i}</a></li>
						</c:forEach>
					</ul>
					<ul class="next_btns">
						<li class="btn_next"><a href="#">${mapper.groupPost}</a></li>
						<li class="btn_last"><a href="#">${mapper.totalPage}</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</section>
</main>
<%@ include file="../tail.jsp"%>
