package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {
  
  // 생성자 호출 못하게 private 처리
  private DBUtils() {
    
  }

  // DB접속
  public static Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "goodee", "goodee");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }
  
  // 접속해제 및 자원 반납
  public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
    try {
      if(rs != null) rs.close();
      if(ps != null) ps.close();
      if(con != null) con.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
