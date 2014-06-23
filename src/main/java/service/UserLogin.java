package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDao;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String name="";
		String password="";
		name=request.getParameter("loginname");
		
		password=request.getParameter("loginpassword");
		//password="\""+password+"\"";
		if(name.compareTo("")!=0&&password.compareTo("")!=0)
		{
		name="\""+name+"\"";
		UserDao userdao=new UserDao();
		User newuser=userdao.getUserByEmail(name);
		if(newuser.getPassword().compareTo(password)==0)
		{
			out.println("Login Success");
		}
		else
		{
			out.println("Login Failed");
		}
		}
		else
		{
			out.println("User info error");
		}
	}

}
