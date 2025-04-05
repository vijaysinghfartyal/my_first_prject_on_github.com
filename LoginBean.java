package beans;

import java.io.Serializable;

import Dao.EmployeDao;

public class LoginBean implements Serializable {
	private String username ;
	private String password ;
	public LoginBean() {
		 
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean loginVerify() {
	    return new EmployeDao().loginVerifyEmployee(this);	
	}

}