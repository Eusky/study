package pkg_practice3;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    
    Judge judge = new Judge();
    Player player = new Player();
    Scanner sc = new Scanner(System.in);
    
    // 1000 ~ 9999 까지 4자리 난수 생성
    judge.setValue(String.valueOf((int)(Math.random()*(9999 + 1000 + 1) + 1000)));
    
    System.out.println(judge.getValue());
    
    while(true) {
      System.out.println("4자리 숫자를 입력해 주세요.");
      String userInput = sc.next();
      String answer = judge.action(player.action(userInput));
      System.out.println(answer);
      
      if(answer.equals("성공")) {
        break;
      }
    }
    sc.close();
  }
}
