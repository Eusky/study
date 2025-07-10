package pkg_practice3;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    
    Judge judge = new Judge();
    Player player = new Player();
    
    
    judge.setValue(String.valueOf((int)(Math.random()*10000)));
    
    System.out.println(judge.getValue());
    
    while(true) {
      System.out.println("4자리 숫자를 입력해 주세요.");
      Scanner sc = new Scanner(System.in);
      String userInput = sc.next();
      
      String answer = judge.action(player.action(userInput));
      System.out.println(answer);
      
      if(answer.equals("성공")) {
        break;
      }
      
      
    }
      
      
 

  }

}
