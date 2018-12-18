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
				<!-- 게시판 시작 -->
				<div class="news_section">
					<div class="read_sec">
						<div class="read_title">
							<div class="title_line">${vo.title}</div>
							<div class="info_line">
								<span>작성자 : ${vo.author}</span> <span>작성일 : ${vo.rdate}</span> <span>조회수
									: ${vo.hit}</span>
							</div>
						</div>
						<div class="read_content">${vo.content}</div>
						<div class="read_file">
							<div class="label">첨부파일</div>
							<div class="form">
								<a href="/museum/download?cate=${vo.cate}&seq=${vo.seq}">${vo.origin_name}</a>
							</div>
						</div>
					</div>
					<div class="list_view">
						<a class="btn txtc" href="/museum/news">목록</a>
						<c:if test="${member.user.equals('admin')}">
							<a class="btn txtc" id="update"
								href="/museum/news_update?seq=${vo.seq}"
								style="background: firebrick">수정</a>
							<a class="btn txtc" id="delete"
								href="/museum/news_delete?seq=${vo.seq}&cate=${vo.cate}"
								style="background: firebrick">삭제</a>
						</c:if>
					</div>
					<div class="nav_list">
						<ul>
							<c:if test="${preVO == null }">
								<li><a>
										<div class=title_line>
											<div class="angle">
												<i class="fa fa-angle-up" aria-hidden="true"></i>
											</div>
											<div class="nav_next">이전글</div>
											<div class="title">이전글이 없습니다.</div>
										</div>
								</a></li>
							</c:if>
							<c:if test="${preVO != null}">
								<li><a href="/museum/news_view?seq=${preVO.seq}">
										<div class=title_line>
											<div class="angle">
												<i class="fa fa-angle-up" aria-hidden="true"></i>
											</div>
											<div class="nav_next">이전글</div>
											<div class="title">${preVO.title}</div>
										</div>
								</a></li>
							</c:if>
							<c:if test="${nextVO == null}">
								<li><a>
										<div class=title_line>
											<div class="angle">
												<i class="fa fa-angle-down" aria-hidden="true"></i>
											</div>
											<div class="nav_next">다음글</div>
											<div class="title">다음글이 없습니다.</div>
										</div>
								</a></li>
							</c:if>
							<c:if test="${nextVO != null}">
								<li><a href="/museum/news_view?seq=${nextVO.seq}">
										<div class=title_line>
											<div class="angle">
												<i class="fa fa-angle-down" aria-hidden="true"></i>
											</div>
											<div class="nav_next">다음글</div>
											<div class="title">${nextVO.title}</div>
										</div>
								</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<!-- 게시판 끝 -->
			</div>
		</div>
	</div>
</section>
</main>
<%@ include file="../tail.jsp"%>
