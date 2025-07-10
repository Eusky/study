package pkg_practice3;

public class Judge extends Person {
  
  public String action(String number) {
    String[] numbers = number.split("");
    String value = this.getValue();
    String[] values = value.split("");
    int strike = 0;
    int ball = 0;
    boolean isBall = false;
    for(int i=0; i<numbers.length; i++) {
      if(numbers[i].equals(values[i])) {
        strike++;
      }
      else {
        for(int j=i+1; j<numbers.length; j++) {
          if(numbers[i].equals(values[j])) {
            isBall = true;
          }
        }
        if(isBall) {
          ball++;
        }
      }
    }
    if(strike == 4) {
      return "성공";
    }
    return "ball: " + ball + ", strike: " + strike;
  }

}
