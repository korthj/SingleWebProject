<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="cancelCommunityAlertModal" class="modal">
	<div id="cancelCanvas" style="width:25%; height:25%; margin:0 auto;">
	<div style="width:100%; height:100%; margin:0 auto;"> 
		<canvas id="myCanvas" style="width: 100%; height:100%;"></canvas>
		<script>
			//  
			$(document).ready(function(){ 
				var canvas = $('#myCanvas')[0];
 				var ctx = canvas.getContext("2d");

				//text
				ctx.font = "25px Verdana";  
				var gradient = ctx.createLinearGradient(0, 0, canvas.width, 0);
				gradient.addColorStop("0", "magenta");
				gradient.addColorStop("0.5", "blue");
				gradient.addColorStop("1.0", "red");
				 
				ctx.fillStyle = gradient;				
				ctx.fillText("로그인 후 이용 가능합니다.", 10,100); 
				 

			});
		</script>	
	</div>	
	</div>
	
		<button type="button" class="signupbtn" onclick="$('#cancelCommunityAlertModal').hide()">확인</button>
	
	
</div>

<script>
	$('#mycanvas').click(function(){
		$('#cancelCommunityAlertModal').hide();
	});
</script>
<script>		
	$('#cancelCommunityAlertModal').click(function(){
		//
		$('#cancelCommunityAlertModal').hide();				
	});
</script>