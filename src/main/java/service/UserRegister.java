package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = "";
		String password = "";
		name = request.getParameter("username");
		password = request.getParameter("password");
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
	}

}
