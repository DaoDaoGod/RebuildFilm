package service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexHandle implements IHandler {

	public void name(HttpServletRequest req, HttpServletResponse resp) {

		try {
			//context.getRequestDispatcher("index.html").forward(req, resp);
			req.getRequestDispatcher("index.html").forward(req, resp);
			//resp.sendRedirect("index.html");
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
		
	}

	ServletContext context;
	public void setContext(ServletContext context) {		
		this.context = context;
	}
	public void handle(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			//context.getRequestDispatcher("index.html").forward(req, resp);
			req.getRequestDispatcher("index.html").forward(req, resp);
		
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
	}

}
