package pkg_practice3;

public class Judge extends Person {
  
  @Override
  public String action(String number) {
    
    try {
      String value = this.getValue();
      
      int strike = 0;
      int ball = 0;
      // 스트라이크 확인
      for(int i=0; i<4; i++) {
        if(value.charAt(i) == number.charAt(i)) {
          strike ++;
        }
      }
      // 볼 확인
      for(int i=0; i<4; i++) {
        if(value.contains(String.valueOf(number.charAt(i)))) {
          ball ++;
        }
      }
      // 볼 - 스트라이크를 볼로 지정
      ball -= strike;
      
      if(strike == 4) {
        return "성공";
      }
      else {
        return "ball: " + ball + ", strike: " + strike;
      }
      
    } catch (NullPointerException e) {
      return "입력된 값이 올바르지 않습니다.";
    }
    
  }

}
