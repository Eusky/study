package chap06_concatenate;

public class ConcatEx {

  public static void main(String[] args) {
 
    // 문자열 연결 연산: +
    
    int x = 10;
    
    System.out.println(x + "살");
    System.out.println(x + 1 + "살");
    
    // 숫자 타입(정수, 실수)의 데이터를 문자열 타입으로 변경할 때 유용합니다.
    int y = 10;
    String s = y + "";
    
    System.out.println(y + 1); // 11
    System.out.println(s + 1); // "101"
    

  }

}
