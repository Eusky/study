package kht_baseball_game_answer;

public class Judge extends Person {
  @Override
  String action(String value) {
      int strikes = 0;
      int balls = 0;

      for (int i = 0; i < 4; i++) {
          char c = value.charAt(i);
          if (getValue().charAt(i) == c) {
              strikes++;
          } else if (getValue().contains(String.valueOf(c))) {
              balls++;
          }
      }

      if (strikes == 4) {
          return "성공";
      }

      return strikes + "스트라이크 " + balls + "볼";
  }

}
