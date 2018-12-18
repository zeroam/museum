/*
document.addEventListener('DOMContentLoaded', () => {
  var gnbWrap = document.querySelector('#gnbWrap')
  var gnb = document.querySelector('#gnb')
  var sub_inside = document.querySelector('.sub_inside')
  gnb.addEventListener('mouseover', evt => {
    sub_inside.classList.remove('on');
  });
  gnbWrap.addEventListener('mouseleave', evt => {
    sub_inside.classList.add('on');
  });
});
 */
// gnb mouseover
$(function() {
	var gnb = $('#gnb');
	var gnbWrap = $('#gnbWrap');
	var menu = $('.sub_inside');
	gnb.mouseover(function() {
		menu.stop().slideDown(400);
	});
	gnbWrap.mouseleave(function() {
		menu.stop().slideUp(400);
	});

	// 버튼 클릭시 해당 경로로 이동
	$('#sel_btn').click(function(e) {
		var url = $('#sel_box option:selected').val()
		location.href = url;
	});

	// 버튼 클릭시 일정 팝업 창
	$('#btnOpenLayer').click(function(e) {
		$('.plan_layer').toggleClass('on');
	});

	var cate_list = $("#lnb_cate > li")
	$("#lnb_cate > li > a").click(function(e) {
		$(this).parent().toggleClass('active');
		return true;
	});

	/* 오늘 날짜 구하기 */
	var t = new Date();
	var y = t.getFullYear();
	var m = t.getMonth();
	var d = t.getDate();
	var day = t.getDay();
	var day_t;
	switch (day) {
	case 0:
		day_t = "일"
		break;
	case 1:
		day_t = "월"
		break;
	case 2:
		day_t = "화"
		break;
	case 3:
		day_t = "수"
		break;
	case 4:
		day_t = "목"
		break;
	case 5:
		day_t = "금"
		break;
	case 6:
		day_t = "토"
		break;
	default:
		day_t = "";

	}

	$(".year").text(y);
	$(".month").text(m + 1);
	$(".day").text(d);
	$(".day_t").text(day_t);

	// 삭제여부 확인
	$("#delete").click(function(e) {
		if (confirm('정말로 삭제하시겠습니까?')) {
			return true;
		} else {
			return false;
		}
	});
	
	//글쓰기 클릭시 form 전송
	$("#write").click(function(){
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		$("#frm").submit();
	});
	
	
	// 페이지 이동
	// 페이지 번호 클릭
	$('.board_paging li a').click(function(e) {
		e.preventDefault();
		page_move(this.text);
	});
	
	function page_move(page) {
		var f = searchForm;
		f.page.value = page;
		f.method = "get"
			f.submit();
	}
	
});
