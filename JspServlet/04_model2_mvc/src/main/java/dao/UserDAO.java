package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.dto.BoardDTO;
import model.dto.UserDTO;

/*
 * DAO (Data Access Object)
 * 
 * 1. 데이터베이스와의 연결, 데이터 조회/삽입/수정/삭제(CRUD) 등 데이터 접근 작업을 수행하는 객체입니다.
 * 2. 비즈니스 로직과 데이터베이스 로직을 분리하여 코드 구조화, 쉬운 유지보수, 코드 재사용성 등을 얻을 수 있습니다. 
 * 3. 인터페이스를 통해 DAO 객체를 생성하면 구현체를 자유롭게 변경할 수 있습니다. 
 */

// Singleton Pattern으로 객체 생성하기 (애플리케이션 전체에서 객체를 하나만 제공)
// 1. private 생성자 
// 2. BoardDAO 객체 생성
// 3. 생성한 BoardDAO 객체를 반환하는 메소드 제공 


public class UserDAO {
  
  // 모든 메소드가 공통으로 사용할 필드
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  private String sql;

  private static UserDAO dao = new UserDAO();
  
  private UserDAO() {
    
  }
  
  public static UserDAO getInstance() {
    return dao;
  }
  
  // 연결 

  public Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "goodee", "goodee");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }

  // 자원 해제

  public void close() {
    try {
      if(rs != null) rs.close();
      if(ps != null) ps.close();
      if(con != null) con.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  // 조회(목록)
  public List<UserDTO> getUsers() {
    List<UserDTO> users = new ArrayList<>();
    
    try {
      con = getConnection();
      sql = "SELECT uid FROM tbl_user";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      // DB에서 가져온 결과  ResultSet를 BoardDTO로 변환
      while(rs.next()) {
        int uid = rs.getInt(1);
        
        UserDTO user = new UserDTO();
        user.setUid(uid);
        users.add(user);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
    return users;
    }
  }
  
