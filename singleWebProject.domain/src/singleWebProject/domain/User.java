package singleWebProject.domain;


public class User {
	//
	private String userId; //회원 아이디
	private String userPassword; //회원 비밀번호
	private String userName; //회원 이름
	private String userEmail; //회원 이메일
	private String userAddress; //회원 주소
	private String userPhoneNumber; //회원 전화번호
	private String userGender; //회원 성별
	
	public User(){
		
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	
	public String toStirng() {
		// TODO Auto-generated method stub
		return "User [userId=" + userId + ", userPassword" + userPassword + ", userName" + userName + ", userEmail" 
				+ userEmail + ", userAddress" + userAddress + ", userPhoneNuber" + userPhoneNumber + ", userGender" + userGender + "]"; 
	}
	
}
