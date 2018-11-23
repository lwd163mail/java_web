package test;

public class EmpInfo {
	private int intEmpID;
	private String strEmpNo;
	private String strEmpName;
	
	public EmpInfo() {
		
	}
	
	public int getEmpID() {
		return this.intEmpID;
	}
	public String getEmpNo() {
		return this.strEmpNo;
	}
	public String getEmpName() {
		return this.strEmpName;
	}
	
	public void setEmpID(int pEmpID) {
		this.intEmpID=pEmpID;
	}
	public void setEmpNo(String pEmpNo) {
		this.strEmpNo=pEmpNo;
	}
	public void setEmpName(String pEmpName) {
		this.strEmpName=pEmpName;
	}
}
