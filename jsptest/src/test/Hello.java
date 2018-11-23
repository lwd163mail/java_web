package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.HashMap;
//import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;
//import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.setContentType("text/html; charset=UTF-8;");
		response.setContentType("application/json;charset=UTF-8;");
		//response.getWriter().write("jsp servlet 1 ²Ä¤@¨B");
		
		try {
			long intRowCount;
			EmpDAO empDAO=DAOFactory.getEmpDAOInstance();
			String v1=request.getParameter("row_count");
			HashMap<String,Object> map=new HashMap<String,Object>();
			
			if(v1==null) {
				intRowCount=6;
			}
			else {
				intRowCount=Long.parseLong(v1);
			}
			
			List<EmpInfo> lstEmp=empDAO.queryAll(intRowCount);
			map.put("result","OK");
			map.put("emp_info", lstEmp);
			
			PrintWriter writer=response.getWriter();
			Gson gson=new Gson();
			writer.write(gson.toJson(map));
			writer.flush();
		}catch(Exception e) {
			response.getWriter().write("Error"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
