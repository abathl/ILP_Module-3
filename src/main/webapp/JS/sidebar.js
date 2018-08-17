$(document).ready(function() {
	$('#sidebarCollapse').on('click', function() {
		$('#sidebar').toggleClass('active');
		$(this).toggleClass('active');
		
		let active = $('#sidebar').hasClass("active");
		if ($(window).width() <= 768 && !active) {
			$('#content-container').css({"width": "100%"}); 
		}
		else if(active){
			$('#content-container').css({"width": "calc(100% - 80px"});
			$('#content-container').css({"left": "80px"});
		} else {
			$('#content-container').css({"width": "calc(100% - 250px"});
			$('#content-container').css({"left": "250px"});
		}
	});
});