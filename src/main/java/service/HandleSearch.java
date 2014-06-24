package service;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDao;
import model.Film;

public class HandleSearch implements IHandler {
	public List<Film> search(String text) {
		List<Film> films = new ArrayList<Film>();
		FilmDao filmdao = new FilmDao();
		String sql = "select * from film where name or description like '%"
				+ text + "%'";
		films = filmdao.getFilmByCondition(sql);
		return films;
	}

	public void setContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context = context;
	}

	private ServletContext context;

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.setCharacterEncoding("gbk");
			PrintWriter out = response.getWriter();
			String queryString = request.getQueryString();
			String searchtext = queryString.split("=")[1];
			System.out.println(searchtext);
			searchtext = URLDecoder.decode(searchtext, "utf-8");
			// System.out.println(name)
			if (searchtext.compareTo("") != 0) {
				/*
				 * String sql = "select * from film where name like \"%" +
				 * searchtext + "%\"";
				 */
				String sql = "select * from film where name like '%"
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
