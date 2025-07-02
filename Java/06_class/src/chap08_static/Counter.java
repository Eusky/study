package chap08_static;

public class Counter {
  
  /*
   * 자바 프로그램의 실행 순서
   * 
   * 메모리 영역별 역할
   * 1. Stack  : 메소드 호출마다 생성되는 메모리 영역. 지역변수, 매개변수 저장.
   * 2. Heap   : new 명령으로 생성한 객체(인스턴스 변수), 배열 등 저장
   * 3. Method : 클래스 정보, 메소드 정보 등 메타데이터, Static 변수 등 저장
   * 
   * 자바 프로그램의 실행 순서
   * 
   * 1. 클래스 로딩(Loading)
   *  소스코드 컴파일 시 .class 파일(바이트코드)이 생성됩니다.
   *  클래스 로더(Class Loader)가 실행에 필요한 클래스를 JVM의 Method 영역에 동적으로 로드합니다.
   *  
   * 2. 링킹(Linking)
   *  로드된 클래스에 대해 검증, 준비, 해결 단계를 통해 점검합니다.
   *  
   * 3. 초기화(Initialization)
   *  Static 변수에 명시된 값으로 초기화하고, Static 블록을 실행합니다.
   * 
   * 4. main() 메소드 실행
   *  main 메소드와 그 안에서 호출되는 다른 모든 메소드는 JVM의 Stack 영역에 각각의 스택 프레임을 생성합니다.
   * 
   * 5. 인스턴스 생성
   *  new 명령으로 인스턴스를 생성하면 해당 인스턴스를 Heap 영역에 할당합니다.
   *  
   * 6. 메소드 호출
   *  메소드 호출 정보가 Stack 프레임에 쌓이고, 메소드 실행이 끝나면 해당 프레임이 없어집니다.
   *  
   * 7. 프로그램 종료
   *  main 메소드가 종료되면 JVM이 사용하던 메모리를 해제하고, Heap에 남아 있는 영역은 Garbage Collector에 의해서 정리됩니다.
   */

  /*
   * static
   * 
   * 1. 클래스 멤버(필드, 메소드)를 정의할 때 사용하는 키워드입니다.
   * 2. static으로 선언된 멤버(필드, 메소드)는 객체(인스턴스)에 소속되지 않습니다.
   *  클래스 자체에 소속됩니다. 그래서 클래스 멤버라고 합니다.
   * 3. static 특징
   *  1) 클래스가 메모리에 로드될 때 한 번만 할당되고 프로그램이 종료될 때까지 유지됩니다.
   *  2) 모든 객체(인스턴스)가 static 변수를 공유합니다. 여러 객체가 같은 static 변수를 접근하게 됩니다.
   * 4. static 멤버 접근 방법
   *  1) 클래스.멤버 (클래스.필드 or 클래스.메소드)
   *  2) 객체.멤버 (추천하지 않음!)
   *  3) 객체(인스턴스) 생성이 없어도 접근할 수 있습니다. 
   * 5. static 메소드는 static 멤버(필드, 메소드)만 사용할 수 있습니다.
   */
  
  //------ 인스턴스 멤버(인스턴스에 소속되고, 인스턴스로 접근합니다.
  private String name;
  
  //----- 클래스 멤버(클래스에 소속되고, 클래스로 접근합니다.)
  static int count = 0;
  
  public Counter() {
    count++;
  }
  //------ static 메소드(static 멤버(=클래스 멤버)만 사용할 수 있습니다.)
  public static void viewCount() {
    System.out.println("현재 Count: " + count);
  // System.out.println("현재 Count 이름: " + name); <-- 오류 
  }
  //----- 인스턴스 메소드
  public void printInfo() {
    System.out.println("현재 Count: " + count);
    System.out.println("현재 Count 이름: " + name); 
  }
  
}
