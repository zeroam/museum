$(function() {
	// news ajax
	var li = $(".multi-col .info li");
	$.ajax({
		url: "/museum/ajax/getNews",
		type: "get",
		dataType: "json",
		success: function(result) {
			$.each(result, function(idx, v) {
				li.eq(idx).find('a').attr('href', "/museum/news_view?seq="+v.seq);
				li.eq(idx).find('a').text(v.title);
				li.eq(idx).find('span').text(v.rdate);
			})
		}
	})
	
	var event = $(".multi-col .event");
	$.ajax({
		url: "/museum/ajax/getEvent",
		type: "get",
		dataType: "json",
		success: function(result) {
			event.find('a').attr('href', '/museum/event_view?seq='+result.seq);
			event.find('.back_img').attr('style', 'background-image:url('+result.img_src+');');
			event.find('.back_text').text(result.title);
			
		}
	})
});
