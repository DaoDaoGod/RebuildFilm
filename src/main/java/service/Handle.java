package service;

import java.awt.peer.SystemTrayPeer;
import java.io.IOException;
import java.io.PrintWriter;
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

/*	Map<String, Class<? extends IHandler>> handlers = new HashMap<String, Class<? extends IHandler>>(
			64);

	public Handle() {
		handlers.put("/", IndexHandle.class);
		handlers.put("/index.html", IndexHandle.class);
		handlers.put("/HandleSearch.do", HandleSearch.class);
		handlers.put("/Register.do", HandleRegister.class);
		handlers.put("/Login.do", HandleLogin.class);

	}*/

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String path = request.getRequestURI().substring(
				request.getContextPath().length());
		System.out.println("Handle.doGet()");
		System.out.println(path);
		String path1=path;
	    path1=(path1.split("/")[1]);
	    path1="service."+path1.substring(0,path1.length()-3);
		System.out.println(path1);
		//Class<?> klass = handlers.get(path);
		Class<?> klass = null;
		try {
			klass = Class.forName(path1);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (klass != null) {
			try {
				IHandler handler = (IHandler) klass.newInstance();
				handler.setContext(getServletContext());
				handler.handle(request, response);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} else {
			// 404
			System.out.println("Handle.service()");
			System.out.println("404");
		}

	}

}
