
$(function(){
	
	$.common={
			serverFullPath:function(){
				let host = window.location.host;
				let contextPath = document.location.pathname;
				let index = contextPath.substr(1).indexOf("/");
				contextPath = contextPath.substr(0, index + 1);
				let path = "http://" + host + contextPath;
				return path;
			},
			
			serverPath:function(){
				let host = window.location.host;
				let contextPath = document.location.pathname;
				let index = contextPath.substr(1).indexOf("/");
				contextPath = contextPath.substr(0, index + 1);
				let path = host + contextPath;
				return path;
			},
			
	}

});

function getRequestPath(target){
	return $.common.serverFullPath() + "/" + target;
}

function sleep(numberMillis) {
	var now = new Date();
	var exitTime = now.getTime() + numberMillis;
	while (true) {
		now = new Date();
		if (now.getTime() > exitTime){
			return;
		}
	}
}

function reloadPage(){
	window.location.reload();
}