package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.DeleteBean;
import beans.EditBean;
import beans.LoginBean;

import beans.RegisterBean;
import beans.SetIdBean;
import dbconn.DBConection;


public class EmployeDao {

	public boolean loginVerifyEmployee(LoginBean lb) {
		boolean flag = false;
		System.out.println("login Verify  Employee=======");
		try {
            Connection conn = DBConection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from login_emp where username=? and password=?");
            ps.setString(1,lb.getUsername());
            ps.setString(2,lb.getPassword());
            ResultSet rs = ps.executeQuery();
            System.out.println("rs is get ");
            if(rs.next()) {
            	flag = true;
            	return flag;
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;	
	}
	//========================Register Insert into DB===========================
		public boolean registerEmploee(RegisterBean rb) {
			boolean flag = false;
			
			System.out.println("register Employee=======");
			try {
	            Connection conn = DBConection.getConnection();
	            PreparedStatement ps = conn.prepareStatement("insert into emp_register values(?,?,?,?,?,?,?,?,?)");
	            ps.setInt(1, rb.getId());
	            ps.setString(2,rb.getName());
	            ps.setString(3,rb.getEmail());
	            ps.setString(4,rb.getAddress());
	            ps.setString(5,rb.getDesignation());
	            ps.setString(6,rb.getDoj());
	            ps.setString(7,rb.getGender());
	            ps.setLong(8, rb.getMobno());
	            ps.setFloat(9, rb.getSalary());
	             int insert = ps.executeUpdate();
	            System.out.println("insert success  "+insert);
	            if(insert != 0 ) {
	            	PreparedStatement ps1 = conn.prepareStatement("insert into login_emp values(?,?)");
	                ps1.setString(1,rb.getUsername());
	                ps1.setString(2,rb.getPassword());
	                int x = ps1.executeUpdate();
	                System.out.println("insert success user & pass  "+x);
	            	
	                if(x != 0) {
	                	flag = true;
	                	return flag;
	                }
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}

			return flag;
		}
		//=========================Get By Id of register Employee==========================
		public RegisterBean getByIdEmployee(SetIdBean setBean) {
			RegisterBean rb = null;
			try {
				Connection conn =   DBConection.getConnection();
				PreparedStatement ps = conn.prepareStatement("select * from emp_register where id=?");
				ps.setInt(1,setBean.getUserid());
				ResultSet rs = ps.executeQuery();
				System.out.println("The Record is found  ");
				if(rs.next()) {
					rb = new RegisterBean();
					rb.setId(rs.getInt(1));
					rb.setName(rs.getString(2));
					rb.setEmail(rs.getString(3));
					rb.setAddress(rs.getString(4));
					rb.setDesignation(rs.getString(5));
					rb.setDoj(rs.getString(6));
					rb.setGender(rs.getString(7));
					rb.setMobno(rs.getLong(8));
					rb.setSalary(rs.getFloat(9));
					System.out.println("recods seted Bean");
					return rb;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return rb;
		}
		//Update   employee profile  
		public boolean updateEmployee(EditBean rb) {
			boolean flag = false;
			try {
			Connection conn =   DBConection.getConnection();
				PreparedStatement ps = conn.prepareStatement("update emp_register set name=?,email=?,address=?,DESIGNATION=?,doj=?,gender=?,mobno=?,salary=? where id=?");
				 ps.setString(1,rb.getName());
	            ps.setString(2,rb.getEmail());
	            ps.setString(3,rb.getAddress());
	            ps.setString(4,rb.getDesignation());
	            ps.setString(5,rb.getDoj());
	            ps.setString(6,rb.getGender());
	            ps.setLong(7, rb.getMobno());
	            ps.setFloat(8, rb.getSalary());
	            ps.setInt(9, rb.getId());
	            int upt = ps.executeUpdate();
	            System.out.println("update success  "+upt);
	            if(upt !=0) {
	            	flag =true;
	            	return flag;
	            }
	            	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		
		//payment getwat==================================

		
		//Delete ==================================
		public boolean deleteEmployee(DeleteBean dbean) {
			boolean flag = false;
			System.out.println("Delete   Employee=======");
			try {
	            Connection conn = DBConection.getConnection();
	            PreparedStatement ps = conn.prepareStatement("delete from emp_register where id=?");
	            ps.setInt(1,dbean.getUserid());
	             
	           int del = ps.executeUpdate();
	            System.out.println("delete success   "+del);
	            if(del != 0) {
	            	flag = true;
	            	return flag;
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}

			return flag;	
		}
		
	}


	

	


