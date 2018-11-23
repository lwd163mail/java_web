package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Servlet implementation class LoadServletTest1
 */
@WebServlet("/LoadServletTest1")
public class LoadServletTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadServletTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		response.setContentType("text/html;charset=UTF-8;");
		/*
		PrintWriter writer=response.getWriter();
		HashMap<String,String> map=new HashMap<String,String>();
		//response.setContentType("application/json;charset=UTF-8;");

		map.put("result","OK");
		Gson gson=new Gson();
		writer.write(gson.toJson(map));
		*/
		request.setAttribute("qq_req", "22");
		
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	}

}
