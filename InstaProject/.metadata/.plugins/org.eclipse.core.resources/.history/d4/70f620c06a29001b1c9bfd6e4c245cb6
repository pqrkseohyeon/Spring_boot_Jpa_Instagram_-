function userUpdate(userId) {
	let data = $("#frm").serialize();
	console.log(1, data);

	fetch("/user", {
		method: "put",
		body: data,
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=utf-8"
		}
	}).then(function (res) {
		return res.text();
	}).then(function (res) {
		alert("회원수정 성공");
		location.href = "/user/" + userId;
	});
}


          	function follow(check,userId){
              	//alert('${toUser.id}');
				//true -> follow 하기
				//false -> unFollow 하기
				let url = "/follow/"+userId;
              	if(check){
					fetch(url,{
						method:"POST"
					}).then(function(res){
						return res.text();
					}).then(function(res){
						if(res==="ok"){
							let follow_check_el = document.querySelector("#follow_check");
							follow_check_el.innerHTML = "<button onClick='follow(false,"+userId+")' class='profile_edit_btn'>팔로잉</button>";
						}//if
					});//then
                  }else{
      				fetch(url,{
						method:"DELETE"
					}).then(function(res){
						return res.text();
					}).then(function(res){
						if(res==="ok"){
							let follow_check_el = document.querySelector("#follow_check");
							follow_check_el.innerHTML = "<button onClick='follow(true,"+userId+")' class='profile_follow_btn'>팔로우</button>";
						}//if
					});//then
                    }//else
              	}//function
