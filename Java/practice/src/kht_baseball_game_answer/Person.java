package kht_baseball_game_answer;

abstract class Person {
  private String value;


  public String getValue() {
      return value;
  }

  public void setValue(String value) {
      this.value = value;
  }

  abstract String action(String value);



}
