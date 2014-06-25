package service;

import java.awt.peer.SystemTrayPeer;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Handle
 */
public class Handle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String path = request.getRequestURI().substring(request.getContextPath().length());
		String classname=path.split("/")[1];
		String methodname=path.split("/")[2];
		methodname=methodname.substring(0,methodname.length()-3);
	    classname="service."+classname;
		Object action = null;
		try {
			action = Class.forName(classname).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//String path2 = methodname;//path.substring(path.indexOf(path1)+ path1.length());
		Method m = null;
		try {
			m = action.getClass().getDeclaredMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp= null;
		try {
			jsp = (String) m.invoke(action, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
	}

}
