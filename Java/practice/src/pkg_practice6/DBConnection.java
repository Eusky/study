package pkg_practice6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
  // DB연결 메소드 만들기
  public Connection getDBConnection() throws IOException, ClassNotFoundException, SQLException {
    
    // jdbc.properties 파일을 읽어오기 위한 입력 스트림 생성
    File file = new File("jdbc.properties");
    FileInputStream in = new FileInputStream(file);
    
    // Properties 객체 생성 이후 properties 파일 읽어와서 로드하기
    Properties p = new Properties();
    p.load(in);
    
    // Driver 클래스 로드(com.mysql.cj.jdbc.Driver)
    Class.forName(p.getProperty("driver"));
    
    // DB 접속
    Connection con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
    
    return con;
  }

}
