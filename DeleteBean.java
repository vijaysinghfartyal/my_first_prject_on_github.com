package beans;

import Dao.EmployeDao;

public class DeleteBean {
	
	private int userid;
	public DeleteBean() {
		 
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
    
	public boolean delete() {
		return new EmployeDao().deleteEmployee(this);
	}

}