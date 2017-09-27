<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>BeetlesDic.com</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/cover.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/carousel.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/bootstrapLoginModal.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/bootstrapLoginModalWindow.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- <script src="${pageContext.request.contextPath}/resources/assets/ie-emulation-modes-warning.js"></script> -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>	
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->    
	 <script type="text/javascript">
	// Get the modal
	var modal = document.getElementById('loginModal');
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	</script>
</head>

<body>

<!-- Button to open the modal login form 
<button onclick="document.getElementById('loginModal').style.display='block'">Login</button>-->

<!-- The Modal -->
<div id="loginModal" class="modal">
 <!--  <span onclick="document.getElementById('loginModal').style.display='none'" 
class="close" title="Close Modal">&times;</span>
 -->
  <!-- Modal Content -->
  <form class="modal-content animate" action="/login.do">
    <div class="imgcontainer">
      <img src="../img/DSC00853.JPG" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label><b>UserName</b></label>
      <input type="text" placeholder="Enter Username" name="userName" required>

      <label><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>

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


	<div class="cover-container" >

		<div class="masthead clearfix" style="position: absolute; z-index: 11; left: 0; right: 0; margin: auto;">
			<div class="inner">
				<h3 class="masthead-brand">
					<a href="../main/mainCover.jsp">Beetles.dic</a>
				</h3>
				<nav>
					<ul class="nav masthead-nav">
						<li><a data-toggle="modal" id="loginButton" onclick="document.getElementById('loginModal').style.display='block'">Login</a></li>
						<li><a href="#">community</a></li>
						<li><a href="#">Dictionary</a></li>
					</ul>
				</nav>
			</div>
		</div>  


	</div>


	<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="5000" data-pause="false" style="z-index: 1;">

		<div class="carousel-inner" role="listbox">


			<div class="item active">
				<img class="first-slide" src="../img/DSC00853.JPG" alt="First slide">
				

			</div>
			<div class="item">
				<img class="second-slide" src="../img/DSC00535.JPG"	alt="Second slide">
				
			</div>
			<div class="item">
				<img class="third-slide" src="../img/DSC01896.JPG" alt="Third slide">
				

			</div>
		</div>

	</div>
  
	<div class="inner-cover" style="position: absolute; top: 0; bottom: 0; left: 0; right: 0; height: 10%; width: 100%; margin-top:30%; z-index: 11;">
		<div style="position: relative;">
			<h1 class="cover-heading">This is Beetles Dictionary Pages.</h1>
			<p class="lead">This is the beetles Dictionary site.<br> Although it
				is a little information at present, it will be a free beetles
				Dictionary site with cooperation of users.</p>
			<!-- <p class="lead">
				<a href="#" class="btn btn-lg btn-default">Learn more</a>
			</p> -->
		</div>
	</div>



	<div class="cover-container" style="position: relative; width:100%; margin:auto; z-index:11;">
		<div class="mastfoot" style="position:absolute; left: 0; right: 0; margin:auto; bottom:0; z-index:11;" >
			<div class="inner">
				<p>
					Developer by <a href="">HJ Kim</a> , Partner by<a href="http://www.stagBeetles.com"> 충우</a>
				</p>
			</div>
		</div>
	</div>  

	<!-- /.carousel -->



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../resources/assets/ie10-viewport-bug-workaround.js"></script>
	<script src="../resources/js/holder.js"></script>
</body>
</html>
