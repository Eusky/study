package chap01_exception.e_throw;

import javax.swing.JOptionPane;

/*
 * throw
 * 
 * 1. 자바에서 예외(Exception)를 직접 발생시킬 때 사용합니다.
 * 2. 개발자가 의도적으로 예외 상황을 감지하거나, 특정 조건에서 예외를 발생시키고 싶을 때 사용합니다.
 * 3. 기본 문법
 *    throw new 예외클래스("예외메시지")
 * 4. throw로 발생한 예외는 try-catch문으로 예외 처리를 하거나, throws를 이용해 예외 위임(전파, 회피)를 해야 합니다.
 *    (Checked Exception의 경우) 
 */

public class Main {

  public static void main(String[] args) {
    try {
      String input = JOptionPane.showInputDialog("점수(0 ~ 100)를 입력하세요.");
      int score = Integer.parseInt(input); // NumberFormatException(Unchecked)
      
      //-------- score의 범위가 0 ~ 100 인지 확인 후 아닌 경우 예외를 직접 발생시킵니다.
      if(score < 0 || score > 100) {
        throw new RuntimeException(score + "점은 잘못된 점수입니다."); //------------ Unchecked 발생 
      }
    } catch(RuntimeException e) {
      System.out.println(e.getMessage());
    }

  }

}
