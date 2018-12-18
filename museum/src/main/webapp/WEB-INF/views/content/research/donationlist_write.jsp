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
				<form action="donationlist_write" method="post" enctype="multipart/form-data">
					<div class="material_detail">
						<div class="title">글쓰기</div>
						<div class="content">
							<div class="box1 box_middle">
								<ul>
									<li>
										<div>자료번호</div>
										<div>
											<input type="text" name="data_num" required/>
										</div>
									</li>
									<li>
										<div>명칭</div>
										<div>
											<input type="text" name="title" required/>
										</div>
									</li>
									<li>
										<div>재질분류</div>
										<div>
											<input type="text" name="cls_material" />
										</div>
									</li>
									<li>
										<div>주제분류</div>
										<div>
											<input type="text" name="cls_subject" />
										</div>
									</li>
									<li>
										<div>시기분류</div>
										<div>
											<input type="text" name="cls_age" />
										</div>
									</li>
									<li>
										<div>지역분류</div>
										<div>
											<input type="text" name="cls_location" />
										</div>
									</li>
									<li>
										<div>소장위치</div>
										<div>
											<input type="text" name="location" />
										</div>
									</li>
									<li>
										<div>크기</div>
										<div>
											<input type="text" name="size" />
										</div>
									</li>
									<li>
										<div>특징</div>
										<div>
											<input type="text" name="traits" />
										</div>
									</li>
									<li>
										<div>기증일</div>
										<div>
											<input type="date" name="dona_date" />
										</div>
									</li>
									<li>
										<div>이미지 파일</div>
										<div>
											<input type="file" name="fname" />
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="list_write">
						<a class="btn txtc" href="/museum/donationlist">목록</a> <input
							class="btn txtc" type="submit" value="글쓰기" />
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
</main>
<%@ include file="../tail.jsp"%>
