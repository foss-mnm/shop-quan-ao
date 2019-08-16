function checkRegister(){
	
	if(!document.getElementById("name").value.match(/^[a-z0-9_-]{6,30}$/)){
		window.alert("Tên đăng nhập không hợp lệ!");
		return false;
	}
	
	if(!document.getElementById("pass").value.match(/^[a-z0-9_-]{6,30}$/)){
		window.alert("Mật khẩu không hợp lệ!");
		return false;
	}
	
	if(document.getElementById("re_pass").value!=document.getElementById("pass").value){
		window.alert("Vui lòng nhập lại mật khẩu");
		return false;
	}
	
	return true;
}

//var previous_style, poll = window.setInterval(function()
//{
//	var current_style = document.getElementById('error').style.display;
//	if (previous_style != current_style) {
//		alert('Tên đăng nhập đã tồn tại');
//		window.clearInterval(poll);
//	} else {
//		previous_style = current_style;
//	}
//}, 100);
