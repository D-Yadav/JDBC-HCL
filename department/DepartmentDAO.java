package com.hcl.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
     Connection connection;
     PreparedStatement pst;
     
     
     
     public String deleteDepartment(int deptno){
		connection=DaoConnection.getConnection();
 		Department department=searchDepartment(deptno);
 		String result="";
 		if(department!=null){
 			String cmd="Delete from department where deptno=?";
 			try {
				pst=connection.prepareStatement(cmd);
				pst.setInt(1, deptno);
 				pst.executeUpdate();
 				result="Record Deleted....";
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
			}			
		}else{
 			result="record not found....";
 		}
 		return result;
 	}

     
     
 	public Department searchDepartment(int deptno){
		connection =DaoConnection.getConnection();
		String cmd=" select * from Department where Deptno=? ";
		Department department=null;
		try {
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, deptno);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				department=new Department();
				department.setDname(rs.getString("Dname"));
				department.setLoc(rs.getString("Loc"));
				department.setCity(rs.getString("City"));
				department.setHead(rs.getString("Head"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return department;
	}




     public List<Department> showDepartment(){
    		connection=DaoConnection.getConnection();
    		String cmd="select * from Department";
    		Department department=null;
    		List<Department> departmentList=new ArrayList<>();
   		try {
   			pst=connection.prepareStatement(cmd);
    			ResultSet rs=pst.executeQuery();
    			while(rs.next()){
    				department=new Department();
    				department.setDeptno(rs.getInt("Deptno"));
    				department.setDname(rs.getString("Dname"));
    				department.setLoc(rs.getString("Loc"));
   				department.setCity(rs.getString("City"));
    				department.setHead(rs.getString("Head"));
    				departmentList.add(department);
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
   		}
  		return departmentList;
    		
    }
    	
     
     
     public String addDepartment(Department department){
    	 connection= DaoConnection.getConnection();
    	 String cmd="insert into Department(Deptno,Dname,Loc,city,Head)"
    			 +"values(?,?,?,?,?)";
    	 String result="";
    	 try{
    		 pst=connection.prepareStatement(cmd);
    		 pst.setInt(1, department.getDeptno());
    		 pst.setString(2, department.getDname());
    		 pst.setString(3, department.getLoc());
    		 pst.setString(4, department.getCity());
    		 pst.setString(5, department.getHead());
    		 pst.executeUpdate();
    		 result="Department record added";
    		 
    	 }catch(SQLException e){
    		 e.printStackTrace();
    		 result=e.getMessage();
    		 
    	 }
    	 return result;
    	 
     }
     public int generateDepartmentno(){
    	 connection=DaoConnection.getConnection();
    	 String cmd="select case when max(Deptno) is null then 1"+"else max(Deptno)+1 end Deptno from Department";
    	 int Deptno=0;
    	 try{
    		 pst=connection.prepareStatement(cmd);
    		 ResultSet rs=pst.executeQuery();
    		 rs.next();
    		 Deptno=rs.getInt("Deptno");	 
    	 }catch(SQLException e){
    		 e.printStackTrace();
    	 }
    	 return Deptno;
     }
     
	
	
	

}












