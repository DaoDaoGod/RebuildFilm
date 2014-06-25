package service;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDao;

public class HandleLogin {

	public String login(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String queryString = req.getQueryString();
		
			String name = queryString.split("&")[0];
			String password = queryString.split("&")[1];
			name = name.substring(10, name.length());
			password = password.substring(14, password.length());
			if (name.compareTo("") != 0 && password.compareTo("") != 0) {
				name = "\"" + name + "\"";
				UserDao userdao = new UserDao();
				User newuser = userdao.getUserByEmail(name);
				if (newuser.getPassword().compareTo(password) == 0) {
					
					req.setAttribute("my-data2","Login Success");
				} else {
					
					req.setAttribute("my-data2","Login Failed");
				}
			} else {
				req.setAttribute("my-data2","User Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/logininfo.jsp";
	}

}
