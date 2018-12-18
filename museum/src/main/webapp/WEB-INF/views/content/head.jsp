<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>국토발전전시관</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">
<link rel="stylesheet" href="/museum/css/style.css">
<link rel="stylesheet" href="/museum/css/sub_style.css">
<link rel="stylesheet" href="/museum/css/board.css">
<link rel="stylesheet" href="/museum/css/member.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script src="/museum/js/common.js"></script>
<script src="/museum/js/ajax.js"></script>
<script src="/museum/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script>
    
    function goPage(content, cate, index = 0) {
    	var f = document.paging;
    	f.content.value = content;
    	f.cate.value = cate;
    	f.index.value = index;
    	f.action = "./content"
    	f.method = "get"
    	f.submit();
    };
  </script>
</head>
<!-- body -->
<body>
	<!-- 페이지 전송 폼 -->
	<form name="paging">
		<input type="hidden" name="content" /> <input type="hidden"
			name="index" /> <input type="hidden" name="cate" />
	</form>
	<!-- header -->
	<header>
		<!-- 대메뉴 -->
		<div id="gnbWrap">
			<div class="inside">
				<!-- 로고 -->
				<a href="/museum/" class="logo" title="메인페이지로 이동"></a>
				<ul id="gnb">
					<li><a href="javascript:goPage('look', 'observation', 1);">관람</a></li>
					<li><a href="javascript:goPage('exhibition', 'seum', 1);">전시</a></li>
					<li><a href="javascript:goPage('education', 'application');">교육</a></li>
					<li><a
						href="javascript:goPage('research', 'donationinfo', 1);">연구</a></li>
					<li><a href="/museum/news">소식</a></li>
					<li><a href="javascript:goPage('participation', 'question');">참여</a></li>
					<li><a href="javascript:goPage('introduce', 'purpose', 1);">전시관
							소개</a></li>
				</ul>
				<c:if test="${member == null}">
					<a id="login" href="/museum/login">
						<div>
							<img src="/museum/img/ic_login.png" alt="로그인">
						</div> <span>로그인</span>
					</a>
				</c:if>
				<c:if test="${member != null}">
					<div id="greeting">${member.user}님반갑습니다</div>
					<a id="logout" href="/museum/logout">
						<div>
							<img src="/museum/img/ic_login.png" alt="로그인">
						</div> <span>로그아웃</span>
					</a>
				</c:if>
				<div class="sub_inside on">
					<ol id="gnb_sub">
						<li>
							<ul>
								<li><a href="javascript:goPage('look', 'observation', 1);">이용안내(x)</a></li>
								<li><a href="javascript:goPage('look', 'floors', 2);">시설안내(x)</a></li>
								<li><a href="javascript:goPage('look', 'group', 3);">기타(x)</a></li>
							</ul>
						</li>
						<li>
							<ul>
								<li><a href="javascript:goPage('exhibition', 'seum', 1);">상설전시(x)</a></li>
								<li><a href="javascript:goPage('exhibition', 'plan');">기획전시(x)</a></li>
								<li><a href="">사이버투어(x)</a></li>
							</ul>
						</li>
						<li>
							<ul>
								<li><a
									href="javascript:goPage('education', 'application');">교육
										신청(x)</a></li>
								<li><a href="javascript:goPage('education', 'data');">교육
										자료(x)</a></li>
							</ul>
						</li>
						<li>
							<ul>
								<li><a
									href="javascript:goPage('research', 'donationinfo', 1);">자료
										기증(o)</a></li>
								<li><a href="/museum/collectionlist">자료실(o)</a></li>
							</ul>
						</li>
						<li>
							<ul>
								<li><a href="/museum/news">새 소식(o)</a></li>
								<li><a href="/museum/event">문화행사(o)</a></li>
								<li><a href="javascript:goPage('news', 'plan');">연간일정(x)</a></li>
							</ul>
						</li>
						<li>
							<ul>
								<li><a
									href="javascript:goPage('participation', 'question');">이용문의(x)</a></li>
								<li><a href="javascript:goPage('participation', 'accept');">의견수렴(x)</a></li>
								<li><a
									href="javascript:goPage('participation', 'volunteer');">자원봉사(x)</a></li>
							</ul>
						</li>
						<li>
							<ul>
								<li><a href="javascript:goPage('introduce', 'purpose', 1);">기관
										안내(x)</a></li>
								<li><a href="javascript:goPage('introduce', 'direction');">찾아오시는길(x)</a></li>
								<li><a href="javascript:goPage('introduce', 'tourspot');">주변정보(x)</a></li>
							</ul>
						</li>
					</ol>
				</div>
			</div>
		</div>
	</header>