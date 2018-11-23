package test;

public class DAOFactory {
	public static EmpDAO getEmpDAOInstance() {
		return new EmpDAOImp();
	}
}
