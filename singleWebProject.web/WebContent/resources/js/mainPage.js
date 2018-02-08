
	//다중 폼 중 선택하여 보내기 위하여 생성한 빈 함수
	 function signUpSub(){  
    
    	return true;
    }; 
  
    //   
    function login(){
        var id = $("#userId");
        var pw = $("#userPassword");
  
        // rsa 암호화
        var rsa = new RSAKey();
        rsa.setPublic($("#RSAModulus").val(),$("#RSAExponent").val());
		
        $("#USER_ID").val(rsa.encrypt(id.val()));
        $("#USER_PW").val(rsa.encrypt(pw.val()));
	
        id.val("");
        pw.val("");
  
        return true;
    };

	//
	$(document).ready(function(){
		//
		var loginFalse = '${message}';
		if(loginFalse == "error"){
			  modal.style.display = "block"; 
		}
		    
	});

function communityMain(){
	//커뮤니티 메인 이동 전 유효성 검사
	var users = "${sessionScope.user.userName}"; 
		 
	if(users != ""){
		//$('#communityMainModal').show();
		return myFunction();
	}else if(users == ""){
		$('#cancelCommunityAlertModal').show();
	}
};
 
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
};


