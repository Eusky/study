package chap01_one_dimension;

import java.util.Arrays;

public class OneDimensionEx {

  public static void main(String[] args) {
    // 배열 선언
    String[] blackPink; //----------- 스택 영역에 레퍼런스 타입 변수 blackPink가 생성됩니다.
    
    // 배열 생성
    blackPink = new String[4]; //---- 힙 영역에 String 저장이 가능한 연속된 4개 메모리 공간이 생성됩니다.
                               //----- 그 중 첫 번째 공간의 참조값을 참조 변수 blackPink에 저장합니다.
                               //----- 힙 영역에 생성된 4개의 메모리 공간은 늘이거나 줄일 수 없습니다.
    
    // 배열 요소 사용(배열명 뒤에 대괄호를 붙이고 인덱스를 작성)
    blackPink[0] = "리사";
    blackPink[1] = "제니";
    blackPink[2] = "로제";
    blackPink[3] = "지수";
    
    // 배열 출력하기
    System.out.println(Arrays.toString(blackPink));
    
    //-------------------- 배열 초기화 (배열 선언 + 배열 생성 + 배열 요소에 값 저장)----------------//
    
    // 배열 초기화 1 (배열 선언시에만 초기화가 가능합니다.)
    String[] frontEnd = {"HTML", "CSS", "JS", "React"};
    System.out.println(Arrays.toString(frontEnd));
    
    // 배열 초기화 2 (배열 선언과 초기화를 두 개의 코드로 분리할 수 있습니다.)
    String[] backEnd;
    backEnd = new String[] {"MySQL", "Java", "JSP/Servlet", "Spring"};  
    System.out.println(Arrays.toString(backEnd));
    
    //----- 배열 순회하기 (일반 for문, 향상된 for문) -------//
    
    String[] hobbies = new String[] {"travel", "game", "coding"};
    
    // 일반 for문
    for(int i=0; i<hobbies.length; i++) {
      System.out.print(hobbies[i] + ",");
    }
    System.out.println();
    
    // 향상 for문(Enhanced for) 
    for(String hobby : hobbies) {
      System.out.print(hobby + ",");
    }
    System.out.println();
  }

}
