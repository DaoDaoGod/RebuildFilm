package service;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class HandleRegister implements IHandler {

	private ServletContext context;
	public void setContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context=context;
		
	}

	public void handle(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	try {
		 String queryString=req.getQueryString();
		 resp.setCharacterEncoding("utf-8");
		 PrintWriter out=resp.getWriter();
		 String name=queryString.split("&")[0];
		 String password=queryString.split("&")[1];
		 name=name.substring(9,name.length());
		 password=password.substring(9,password.length());
		 if (name.compareTo("") != 0 && password.compareTo("") != 0) {
				name = "\"" + name + "\"";
				password = "\"" + password + "\"";

				UserDao userdao = new UserDao();
				Boolean state = userdao.save(name, password);
				if (state) {
					out.println("Successful");
				} else {
					out.println("Failed");
				}
			} else {
				out.print("User info error");
			}
		 
		 
		 
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	 
	}

}
