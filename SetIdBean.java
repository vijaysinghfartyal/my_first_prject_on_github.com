package beans;

import Dao.EmployeDao;

public class SetIdBean {
	
	private int userid;
	public SetIdBean() {
		 
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
    
	public RegisterBean getByIdUser() {
		return new EmployeDao().getByIdEmployee(this);
	}
//	public boolean register() {
//		return  new EmployeDao().registerEmploee(this);
//	}

}