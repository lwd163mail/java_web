package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;
import java.util.HashMap;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoadServlet
 */
@WebServlet("/LoadServlet")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/json;charset=UTF-8;");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8;");
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("qq", "313885925");
		
		Gson gson=new Gson();
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<head><title>Load</title></head>");
		writer.println("<body>");

		writer.println("<form name=\"submitForm\" action=\"NewFile.jsp\" method=\"post\">");
		writer.println("<input type=\"hidden\" name=\"qq\" value=\"313885925\">");
		writer.println("</form>");
		writer.println("<script>window.document.submitForm.submit();</script>");
		writer.println("</body>");
		writer.println("</html>");
		writer.flush();
		writer.close();
	}

}
