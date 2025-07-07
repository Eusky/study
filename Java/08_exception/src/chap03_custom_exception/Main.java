package chap03_custom_exception;

public class Main {
  
  public static void customException() throws MyException {
    // MyException 발생 후 예외 위임
    throw new MyException("예외가 발생했습니다.");
  }

  // JVM에게 예외 위임하기(권장하지 않음)
  //  public static void main(String[] args) throws MyException { // customException() 메소드를 호출한 곳으로 MyException 예외 던지기
  //    customException();
  //  }
  
  public static void main(String[] args) {
    try {
      customException();
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }
  }
}
