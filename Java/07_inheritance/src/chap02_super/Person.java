package chap02_super;

public class Person {
  
  // 필드
  private String name;
  
  // 생성자
  public Person(String name) {
    super();
    this.name = name;
  }
  
  // 메소드
  public void printInfo() {
    System.out.println("이름: " + name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  

}
