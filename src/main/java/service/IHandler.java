package service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IHandler {

	public void setContext(ServletContext context);
	public void handle(HttpServletRequest req, HttpServletResponse resp);
}
