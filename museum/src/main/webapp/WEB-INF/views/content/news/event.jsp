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
				<form name="searchForm" action="/museum/event">
					<div class="search">
						<input type="hidden" name="page" value="1"> <select
							class="searchField" name="searchField">
							<option value="NAME">명칭</option>
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
				<div class="board_photo_list">
					<ul>
						<c:forEach var="vo" items="${voList}">
							<li><a href="/museum/event_view?seq=${vo.seq}">
									<div class="pic" style="background-image:url(${vo.img_src});"></div>
									<div class="info">
										<div class="title">${vo.title}</div>
										<div class="date">${vo.rdate}</div>
									</div>
							</a></li>
						</c:forEach>
						<c:if test="${voList == null}">
							<li>게시글이 없습니다.</li>
						</c:if>
					</ul>
				</div>
				<c:if test="${member.user.equals('admin')}">
					<div class="list_write">
						<a class="btn txtc" href="/museum/event_write">글쓰기</a>
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
