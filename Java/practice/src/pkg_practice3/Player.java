package pkg_practice3;

public class Player extends Person {
  
  boolean isOk = false;
  
  public String action(String userInput) {
    if(userInput.length() == 4) {
      isOk = true;
    }
    if(isOk) {
      return userInput;
    }
    return null;
  }

}
