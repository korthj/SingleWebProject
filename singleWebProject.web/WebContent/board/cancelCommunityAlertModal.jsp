<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="cancelCommunityAlertModal" class="modal">
	<div class="imgcontainer">
		<img src="../img/DSC00853.JPG" alt="Avatar" class="avatar">
	</div>
	<div>
		<button type="button" class="signupbtn" onclick="$('#cancelCommunityAlertModal').hide()">확인</button>
	</div>
</div>

<script>
	var cancelCommunityModal = $('#cancelCommunityAlertModal')[0];
	
	$(document).click(function(){
		//
	alert("alerttest");
		if(event.target == cancelCommunityModal){
			$('#cancelCommunityAlertModal').hide();
		}
	});
</script>