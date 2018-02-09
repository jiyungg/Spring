package com.iot.spring.vo;

public class UserInfoVO {
	
	private int uiNo;
	private String UiName;
	private String UiId;
	private String UiPwd;
	private String UiEmail;
	private char admin;
	
	public int getUiNo() {
		return uiNo;
	}
	public void setUiNo(int uiNo) {
		this.uiNo = uiNo;
	}
	public String getUiName() {
		return UiName;
	}
	public void setUiName(String uiName) {
		UiName = uiName;
	}
	public String getUiId() {
		return UiId;
	}
	public void setUiId(String uiId) {
		UiId = uiId;
	}
	public String getUiPwd() {
		return UiPwd;
	}
	public void setUiPwd(String uiPwd) {
		UiPwd = uiPwd;
	}
	public String getUiEmail() {
		return UiEmail;
	}
	public void setUiEmail(String uiEmail) {
		UiEmail = uiEmail;
	}
	public char getAdmin() {
		return admin;
	}
	public void setAdmin(char admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserInfo [uiNo=" + uiNo + ", UiName=" + UiName + ", UiId=" + UiId + ", UiPwd=" + UiPwd + ", UiEmail="
				+ UiEmail + ", admin=" + admin + "]";
	}
}
