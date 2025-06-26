package start;

/**
 * documentation-comment 
 * 저자, 작성일자, 버전, 설명 등 Java API 문서로 제공하기 위한 문서 주석입니다.
 * @author 저자 
 * @see 참고
 * @version 버전
 */
public class Start {

  /**
   * documentation-comment
   * 해당 메소드에 관한 설명을 Java API 문서로 제공하기 위한 문서 주석입니다.
   * @param args 매개변수 설명
   */
	public static void main(String[] args) {
		// single-line comment 
	  
	  /*
	   * multiple-line comment
	   * 여러 줄 주석
	   */
	  
	  // 화면 출력(Console View 출력)
	  System.out.println("Hello World"); // Hello World 출력
	  System.out.printf("%d%f%s%c", 3, 4.0, "Hello World", '!'); // %d: 정수, %f: 실수, %s: 문자열, %c 문자
	}

}

