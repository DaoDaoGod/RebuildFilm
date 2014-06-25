package service;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class HandleRegister{
	
	public String register(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			String queryString = req.getQueryString();
			
			String name = queryString.split("&")[0];
			String password = queryString.split("&")[1];
			name = name.substring(9, name.length());
			password = password.substring(9, password.length());
			if (name.compareTo("") != 0 && password.compareTo("") != 0) {
				name = "\"" + name + "\"";
				password = "\"" + password + "\"";

				UserDao userdao = new UserDao();
				Boolean state = userdao.save(name, password);
				if (state) {
					req.setAttribute("my-data2","Successful");
				} else {
					req.setAttribute("my-data2","Failed");
				}
			} else {
				req.setAttribute("my-data2","User info error");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/logininfo.jsp";
  
	}

}
