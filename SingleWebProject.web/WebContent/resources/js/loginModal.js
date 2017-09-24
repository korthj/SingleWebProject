/**
 * 로그인 모달 스크립트
 */
if(typeof(Login) == "undefined") var Login = {};

(function($){
	Login.Modal = function(){
		this.initialize.apply(this,arguments);
	}
	
	Login.Modal.prototype = {
			initialize : function(hash){
				var obj = this;
				
				//멤버 변수 정의
				this.hash = this.getHashData(hash);
				this.width = 0; //콘텐츠 레이어 너비
				this.height = 0; // 콘텐츠 레이어 높이
				this.c_width = 0; // body 화면 너비
				this.c_height = 0;//body window height
				this.s_width = 0; // body all width
				this.s_height = 0; // body all height
				
				//콘텐츠 레이어 사이즈 구하기(멤버 변수에 저장)
				this.getLayerSize();
				//body 사이즈 구하기 (멤버 변수에 저장)
				this.getBodySize();
				//추가 엘리먼트 생성
				this.addElement();
				//마우스 키보드 이벤트 정의
				this.addEvent();
			},
			
			//Hash 변수 정의
			getHashData : function(hash){
				if(typeof(hash.id) == "undefined") hash.id = "loginModalWindow";//개체 아이디 
				if(typeof(hash.is_slide) == "undefined") hash.is_slide = 0;//슬라이딩 여부
				
				return hash;
			},
			
			//추가 엘리먼트 생성 -JS에서 추가해서 주어야 할 HTML 작성한다.
			addElement : function(){
				//배경 레이어 HTML 받아오기
				var html = this.addOverlay();
				
				//배경레이어 HTML을 콘텐츠 레이어 앞에 추가
				$("#" + this.hash.id).before(html);
			},
			
			//마우스 키보드 이벤트 정의
			addEvent : function(){
				var obj = this;
				
				//닫기 버튼 클릭 이벤트 정의
				$("#" + this.hash.id + " .js_close").click(function() {
					obj.hide();
				});
			},
			
			/* 주요기능 */
			
			//모달창 보여주기
			show : function(){
				//가운데로 이동
				this.moveCenter();
				//배경레이어 적용
				this.applyOverlay();
				//콘텐츠 레이어 보여주기
				$("#" + this.hash.id).show();
				//배경 레이어 보여주기
				$("#" + this.hash.id + "_overlay").show();
			},
			
			//모달창 감추기
			hide : function(){
				$("#" + this.hash.id).hide();//콘텐츠 레이어 감추기
				$("#" + this.hash.id + "_overlay").hide();//배경 레이어 감추기
			},
			
			/* 부가기능*/
			
			//콘텐츠 레이어의 너비와 높이를 구해서 멤버변수에 정의
			getLayerSize : function(){
				this.width = $("#" + this.hash.id).outerWidth();
				this.height = $("#" + this.hash.id).outerHeight();
			},
			
			//body 사이즈 구해서 멤버 변수에 정의
			getBodySize : function(){
				this.c_width = document.documentElement.clientWidth;
				this.c_height = document.documentElement.clientHeight;
				this.s_width = document.documentElement.clientWidth;
				this.s_height = document.documentElement.clientHeight;
			},
			
			//배경 레이어 HTML 생성
			addOverlay : function(){
				var html = "";
				html += "<div id='"+this.hash.id+"_overlay' style='display:none;width:100%;position:absolute;top:0px;left:0px;opacity:0.5;background-color:#000000;z-Index:999'></div>";
				
				return html;
			}
	}
})(jQuery);
