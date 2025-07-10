package kht_baseball_game_answer;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Person judge = new Judge();
    Person player = new Player();
    String value = "";
    String result = "";

    judge.setValue(String.format("%04d", (int) (Math.random() * 9000 + 1000)));

    while (true) {
        try {
            System.out.print("4자리 숫자 입력: ");
            value = player.action(sc.nextLine());
            result = judge.action(value);

            System.out.println(result);

            if (result.equals("성공")) {
                break;
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    sc.close();

  }

}
