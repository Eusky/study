package chap11_Member_Address;

// 문제. 생성자를 호출하여 Member 객체를 만들고 printInfo() 메소드를 호출하여 객체의 정보를 확인하세요.

public class Main {

  public static void main(String[] args) {
    
    Member member = new Member(new Address("12345", "가산로 5길 33", "101호"), new Address("45667", "동대문로 6길 22", "108호"));
    member.printInfo();

  }

}
