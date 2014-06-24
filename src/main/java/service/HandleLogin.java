package service;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDao;

public class HandleLogin implements IHandler{

	private ServletContext context;
	public void setContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context=context;
	}

	public void handle(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try
		{
		 String queryString=req.getQueryString();
		 resp.setCharacterEncoding("utf-8");
		 PrintWriter out=resp.getWriter();
		 String name=queryString.split("&")[0];
		 String password=queryString.split("&")[1];
		 name=name.substring(10,name.length());
		 password=password.substring(14,password.length());
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
