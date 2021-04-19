package demo.project.model;

import demo.project.businesslogic.LoginValidation;

public class LoginBean {
	private String userid;
	private String password;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int loginValidate() {
		int value;
		
		LoginValidation l = new LoginValidation();
		value = l.validateUser(userid, password);
		
		if(value == 1) {
			return 1;
			
		}
		return 0;
		
	}
	
}
