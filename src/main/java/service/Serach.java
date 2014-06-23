package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import dao.FilmDao;

/**
 * Servlet implementation class Serach
 */
public class Serach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Serach() {
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
		// response.setContentType("text/html;charest=utf-8");
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		String searchtext = "";
		searchtext = new String(request.getParameter("searchText").getBytes(
				"ISO-8859-1"), "utf-8");
		// String sql="select * from film where name like "+searchtext;
		if (searchtext.compareTo("") != 0) {
			String sql = "select * from film where name or description like '%"
					+ searchtext + "%'";
			FilmDao filmDao = new FilmDao();
			List<Film> films = new ArrayList<Film>();
			films = filmDao.getFilmByCondition(sql);
			for (int i = 0; i < films.size(); i++) {
				out.println(films.get(i).getName());
			}
		} else {
			out.println("search is empty");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
