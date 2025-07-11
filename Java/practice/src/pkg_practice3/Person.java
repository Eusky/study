package pkg_practice3;

public abstract class Person {
  
  private String value;
  
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public abstract String action(String str);

}
