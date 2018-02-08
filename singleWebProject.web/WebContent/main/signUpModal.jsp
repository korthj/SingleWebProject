<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	//아이디와 비밀번호가 가입 불가시 가입버튼 비활성을 위한 변수 설정
	var idCheck = 0;
	var pwCheck = 0;
	
	//아이디 체크, 가입버튼 비활성화, 중복확인
	function checkId(){
		//
		var inputed = $("#signUpId").val();
		$.ajax({
			type:"POST",
			data : {
				userId : inputed
			}, 
			url : "${pageContext.request.contextPath}/user/signUpIdCheck.do",
			success : function(data){
				if(inputed =="" && data =="0"){
					//
					$("#signUpFormBtn").prop("disabled",true);
					$("#signUpFormBtn").css("background-color","#aaaaaa");
					$("#signUpId").css("background-color","#FFCECE");
					idCheck = 0;
				}else if(data == "0"){
					//
					$("#signUpId").css("background-color","#B0F6AC");
					idCheck = 1;
					if(idCheck == "1" && pwCheck =="1"){
						//
					$("#signUpFormBtn").prop("disabled",false);
					$("#signUpFormBtn").css("background-color","#4CAF50");
					checkPw();
					signUpCheck();
					}
				}else if(data == "1"){
					//
					$("#signUpFormBtn").prop("disabled",true);
					$("#signUpFormBtn").css("background-color","#aaaaaa");
					$("#signUpId").css("background-color","#FFCECE");
					idCheck = 0;
				}
			}
		});
	}
		//재입력 비밀번호 체크
		function checkPw(){
			//
			var inputed = $("#signUpPw").val();
			var reinputed = $("#signUpRePw").val();
			
			if(reinputed == "" && (inputed != reinputed || inputed == reinputed)){
				//
				$("#signUpFormBtn").prop("disabled", true);
				$("#signUpFormBtn").css("background-color", "#aaaaaa");
				$("#signUpRePw").css("background-color","#FFCECE");
			}else if(inputed == reinputed){
				//
				$("#signUpRePw").css("background-color","#B0F6AC");
				pwCheck = 1;
				if(idCheck == 1 && pwCheck == 1){
					//
					$("#signUpFormBtn").prop("disabled", false);
					$("#signUpFormBtn").css("background-color","#4CAF50");
					signUpCheck();
				}
			}else if(inputed != reinputed){
				//
				pwCheck = 0;
				$("#signUpFormBtn").prop("disabled",true);
				$("#signUpFormBtn").css("background-color","#aaaaaa");
				$("#signUpRePw").css("background-color","#FFCECE");
			}
		}
		
		function signUpCheck(){
			//
			var nickName = $("#signUpName").val();
			var email = $("#signUpEm").val();
			
			if(nickName == "" || email == ""){
				$("#signUpFormBtn").prop("disabled",true);
				$("#signUpFormBtn").css("background-color","#aaaaaa");
			}
		}
		
		//취소시 인풋박스 클리어
		
		function cancel(){
			$("#signUpId").val(null);
			$("#signUpPw").val("");
			$("#signUpRePw").val("");
			$("#signUpFormBtn").prop("disabled",true);
			$("#signUpFormBtn").css("background-color","#aaaaaa");
			$("#signUpRePw").css("background-color","transparent");
			document.getElementById('signUpModal').style.display='none';
		} 
		
</script>

<div id="signUpModal" class="modal">

	<form class="modal-content animate" id="signUpForm" name="signUpForm" method="post" action="${pageContext.request.contextPath}/user/signUp.do" onsubmit="return signUpSub()">
		<div class="container">
			<label><b>ID</b></label>
			<input type="text" id="signUpId" name="signUpId" placeholder="ID" oninput="checkId()">		
		
			<label><b>Name</b></label>
			<input type="text" id="signUpName" name="signUpName" placeholder="Name" oninput="checkId()">
	
			<label><b>Email</b></label>
			<input type="text" id="signUpEm" name="signUpEm" placeholder="Email" oninput="checkId()">
		
			<label><b>Address</b></label>
			<input type="text" id="signUpAdd" name="signUpAdd" placeholder="Address">
		
			<label><b>PhoneNumber</b></label>
			<input type="text" id="signUpPN" name="signUpPN" placeholder="PhoneNumber">
			
			<label><b>Password</b></label>
			<input type="password" id="signUpPw" name="signUpPw" placeholder="Password" oninput="checkPw()">
			
			<label><b>Repeat Password</b></label>
			<input type="password" id="signUpRePw" name="signUpRePw" placeholder="Repeat Password" oninput="checkPw()">
			
			<label><b>Gender</b></label> <br>
			<select id="signUpGe" name="signUpGe">
				<option value="m">male</option>
				<option value="f">female</option> 
			</select>
		</div>
	    <div class="container" style="background-color:#f1f1f1"> 
	     	<button type="submit" class="signupbtn" id="signUpFormBtn" disabled="disabled" style="background-color:#aaaaaa;">SignUp!</button>    
	      	<button type="button" id="cancelBtn" class="cancelbtn" onclick="cancel()">Cancel</button> 
   	    </div>
	</form>
</div>
