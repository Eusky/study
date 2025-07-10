package kht_baseball_game_answer;

public class Player extends Person {
  @Override
  String action(String value) {
      if (value == null || value.length() != 4) {
          throw new RuntimeException("4개의 숫자를 입력하세요");
      }

      for (char c : value.toCharArray()) {
          if (!Character.isDigit(c)) {
              throw new RuntimeException("숫자만 입력하세요");
          }
      }

      return value;
  }

}
