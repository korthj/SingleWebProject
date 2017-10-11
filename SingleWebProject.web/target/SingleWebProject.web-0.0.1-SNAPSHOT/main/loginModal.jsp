<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Button to open the modal login form 
<button onclick="document.getElementById('loginModal').style.display='block'">Login</button>-->

<!-- The Modal -->
<div id="loginModal" class="modal">
 <!--  <span onclick="document.getElementById('loginModal').style.display='none'" 
class="close" title="Close Modal">&times;</span>
 -->
  <!-- Modal Content -->
  <form class="modal-content animate" action="${pageContext.request.contextPath}/user/login.do" method="post">
    <div class="imgcontainer">
      <img src="../img/DSC00853.JPG" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label><b>UserName</b></label>
      <input id="userName" name="userName" type="text" placeholder="Enter Username" name="userName" required>
 
      <label><b>Password</b></label>
      <input id="userPassword" name="password" type="password" placeholder="Enter Password" name="password" required>
			<c:if test="${message eq 'error'}">
				<div style="text-align:center;">
					<span style="color:red;">아이디 또는 패스워드가 일치하지 않습니다.</span>
				</div>
			</c:if>
      <button type="submit">Login</button>
      <input type="checkbox" checked="checked"> Remember me
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" class="signupbtn">SignUp</button>    
      <button type="button" onclick="document.getElementById('loginModal').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</div>
	 <script>
	// Get the modal
	var modal = document.getElementById('loginModal');
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	</script>
