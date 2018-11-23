package test;

import java.util.List;

public interface EmpDAO {
	public EmpInfo queryByID(int pEmpID) throws Exception;
	public List queryAll(long pRowCount) throws Exception;
}
