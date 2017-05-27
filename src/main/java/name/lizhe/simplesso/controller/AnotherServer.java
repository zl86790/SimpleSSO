package name.lizhe.simplesso.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.lizhe.simplesso.tool.MemcacheTool;

/**
 * Servlet implementation class AnotherServer
 */
public class AnotherServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnotherServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token = request.getParameter("token");
		String username = MemcacheTool.get(token);
		MemcacheTool.del(token);
		if(username!=null){
			response.getWriter().append("i got usernmae is :"+username);
		}else{
			response.getWriter().append("Served at: ").append(request.getContextPath());
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
