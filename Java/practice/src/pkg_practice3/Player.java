package pkg_practice3;

public class Player extends Person {
  
  @Override
  public String action(String userInput) {
    // 4자리이고 숫자로만 이루어져 있는지 검사
    if(userInput.length() == 4 && userInput.matches("\\d+")) {
      return userInput;
    }
    else {
      return null;
    }
  }

}
