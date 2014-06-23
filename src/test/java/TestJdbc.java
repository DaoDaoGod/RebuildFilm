import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import model.User;
import dao.FilmDao;
import dao.UserDao;


public class TestJdbc {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
	
    UserDao userdao=new UserDao();
    User newuser=userdao.getUserByEmail("\"290024136@163.com\"");
    System.out.println(newuser.getEmail());
    System.out.println(newuser.getPassword());
    System.out.println(newuser.getUserId());
    
    
    
  
}
}
