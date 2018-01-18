<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Button to open the modal login form 
<button onclick="document.getElementById('loginModal').style.display='block'">Login</button>-->

<script type="text/javascript">
$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var userInputId = getCookie("userInputId");
    $("#userId").val(userInputId); 
     
    if($("#userId").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            var userInputId = $("#userId").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userInputId");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("#userId").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("#userId").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }
    });
});

function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
</script>

<div id="loginModal" class="modal">

  <form class="modal-content animate" id="loginForm" name="loginForm" method="post" action="${pageContext.request.contextPath}/user/login.do" onsubmit="return login()">
    <div class="imgcontainer">
      <img src="../img/DSC00853.JPG" alt="Avatar" class="avatar">
    </div>

    <div class="container">  
      <input type="hidden" id="RSAModulus" value="${RSAModulus}"/><!--  -->
      <input type="hidden" id="RSAExponent" value="${RSAExponent}"/><!--  -->
      <label><b>ID</b></label>
      <input id="userId" name="userId" type="text" placeholder="Enter Id" required>
 
      <label><b>Password</b></label>
      <input id="userPassword" name="userPassword" type="password" placeholder="Enter Password" required>
			<c:if test="${message eq 'error'}">
				<div style="text-align:center;" >
					<span style="color:red;">아이디 또는 패스워드가 일치하지 않습니다.</span>
				</div>
			</c:if> 

	  <input type="hidden" id="USER_ID" name="USER_ID"><!--  -->
      <input type="hidden" id="USER_PW" name="USER_PW"><!--  -->     
      <input type="checkbox" checked="checked" name="idSaveCheck" id="idSaveCheck"> Remember me
      <button type="submit" value="Login">Login</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" class="signupbtn" id="signUpBtn" onclick="document.getElementById('signUpModal').style.display='block'">SignUp</button>    
      <button type="button" onclick="document.getElementById('loginModal').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</div>
<script>
	
	var modal = $("#loginModal")[0];	  
	var signUp = $('#signUpBtn')[0];	
	var signUpForm = $('#signUpModal')[0];	  
	
	$(document).click(function(){
		 //
		if(event.target == modal) {
			$("#loginModal").hide();
	    }
	    if(event.target == signUp){
	    	$("#loginModal").hide();
	    }
	    if(event.target == signUpForm) {
	    	$("#signUpModal").hide();
	    }		
	}); 
</script>
	
