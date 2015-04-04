$(document).ajaxStart(function() {
	$(".wait").css("display", "block");
});

$(document).ready(
		function() {
			var listServer = $('.server-listed');
			function check_server(index) {
				if (!listServer[index]) {
					return false;
				}
				var data = $(listServer[index]).attr('data-id');
				$.ajax(
						{
							url : 'checkstatus/' + data + '/' + cc,
							type : 'GET',
							data : {},
							timeout : '30000',
							success : function(data, status) {
								data = $.trim(data);
								$(listServer[index]).find(".wait").css("display", "none");
								if (data == 'false') {
									$(listServer[index]).find(".i-server-icon").remove;
									$(listServer[index]).find(".i-server-icon-off").css({"display" : "block"});
								} else {
									$(listServer[index]).find(".i-server-icon-off").remove;
									$(listServer[index]).find(".i-server-icon").css({"display" : "block"
									});
									$(listServer[index]).find(".disabled").removeClass("disabled");
								}
							}
						}).always(function() {
					check_server(++index);
				});
			}

			if (listServer.length > 0) {
				check_server(0);
			}
			// Check status sidebar
			var listleft = $('.list-server-left');
		});