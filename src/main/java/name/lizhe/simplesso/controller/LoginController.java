package name.lizhe.simplesso.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.lizhe.simplesso.tool.AuthenticationTool;
import name.lizhe.simplesso.tool.MemcacheTool;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String targetServerUrl = "http://localhost:8080/sso/anotherServer";
		
		if(username!=null && password!=null){
			String uuid = AuthenticationTool.getUUID();
			MemcacheTool.set(uuid, username, new Date(1000*60));
			String url = AuthenticationTool.getAuthenURL(targetServerUrl,uuid);
			response.getWriter().append("successed: ").append(url);
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
