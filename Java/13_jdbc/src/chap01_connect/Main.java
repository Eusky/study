package chap01_connect;

public class Main {

  public static void main(String[] args) {
    
    try {
      
      DBConnection.getConnection();
      System.out.println("DB 접속 성공");
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
