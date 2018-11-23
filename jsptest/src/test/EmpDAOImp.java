package test;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class EmpDAOImp implements EmpDAO {
	
	public EmpInfo queryByID(int pEmpID) throws Exception{
		DBConnection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		EmpInfo emp=null;
		String strSQL="SELECT * FROM SAJET.SYS_EMP WHERE EMP_ID=?";
		
		try {
			con=new DBConnection();
			st=con.getConnection().prepareStatement(strSQL);
			st.setInt(1, pEmpID);
			rs=st.executeQuery();
			
			while(rs.next()) {
				emp=new EmpInfo();
				emp.setEmpID(rs.getInt("EMP_ID"));
				emp.setEmpNo(rs.getString("EMP_NO"));
				emp.setEmpName(rs.getString("EMP_NAME"));
			}
			if(st!=null) {
				st.close();
			}
		}catch(Exception e) {
			System.out.println("计沮琩高钵盽strSQL:"+strSQL+e.getMessage());
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return emp;
	}
	
	public List<EmpInfo> queryAll(long pRowCount) throws Exception{
		
		DBConnection con=null;
		PreparedStatement st=null;
		//Statement st=null;
		ResultSet rs=null;
		
		List<EmpInfo> lstEmp=new ArrayList<EmpInfo>();
		String strSQL="SELECT * FROM SAJET.SYS_EMP WHERE ROWNUM<?";
		
		try {
			con=new DBConnection();
			st=con.getConnection().prepareStatement(strSQL);
			st.setLong(1, pRowCount);
			//System.out.println(st.toString()); 
			//st=con.getConnection().createStatement();
			rs=st.executeQuery();
			
			while(rs.next()) {
				EmpInfo emp=new EmpInfo();
				emp.setEmpID(rs.getInt("EMP_ID"));
				emp.setEmpNo(rs.getString("EMP_NO"));
				emp.setEmpName(rs.getString("EMP_NAME"));
				lstEmp.add(emp);
			}
			if(st!=null) {
				st.close();
			}
		}catch(Exception e) {
			System.out.println("计沮琩高钵盽strSQL:"+strSQL);
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return lstEmp;
	}
}
