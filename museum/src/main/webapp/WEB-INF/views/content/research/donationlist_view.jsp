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
			<li><a href="">연구</a></li>
			<li><a href="">자료기증</a></li>
			<li><a href="">기증내역</a></li>
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
			<div id="sub_page_title">기증내역</div>
			<div id="contents">
				<div class="material_detail">
					<div class="title">
						${vo.title}
					</div>
					<div class="content">
						<div class="box0 box">
							<div class="image" style="background-image:url(${vo.img_src});">

							</div>
						</div>
						<div class="box1 box">
							<ul>
								<li>
									<div>자료번호</div>
									<div>${vo.data_num}</div>
								</li>
								<li>
									<div>명칭</div>
									<div>${vo.title}</div>
								</li>
								<li>
									<div>재질분류</div>
									<div>${vo.cls_material}</div>
								</li>
								<li>
									<div>주제분류</div>
									<div>${vo.cls_subject}</div>
								</li>
								<li>
									<div>시기분류</div>
									<div>${vo.cls_age}</div>
								</li>
								<li>
									<div>지역분류</div>
									<div>${vo.cls_location}</div>
								</li>
								<li>
									<div>소장위치</div>
									<div>${vo.location}</div>
								</li>
								<li>
									<div>크기</div>
									<div>${vo.size}</div>
								</li>
								<li>
									<div>특징</div>
									<div>${vo.traits}</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="list_view">
					<a class="btn txtc" href="/museum/donationlist">목록</a>
					<c:if test="${member.user.equals('admin')}">
						<a class="btn txtc" id="update" href="/museum/donationlist_update?seq=${vo.seq}" style="background:firebrick">수정</a>					
						<a class="btn txtc" id="delete" href="/museum/donationlist_delete?seq=${vo.seq}" style="background:firebrick">삭제</a>					
					</c:if>
				</div>
			</div>
		</div>
	</div>
</section>
</main>
<%@ include file="../tail.jsp"%>
