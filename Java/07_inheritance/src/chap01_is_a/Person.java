package chap01_is_a;

/*
 * A는 B이다. (is-a 관계) 
 * 학생은 사람이다. Student is a Person.
 * 근로자는 사람이다. Worker is a Person
 * 개발자는 근로자이다. Developer is a Worker.
 * 디자이너는 근로자이다. Designer is a Worker.
 * 
 */


public class Person {
  
  
  // 메소드
  public void eat() {
    System.out.println("먹는다.");
  }
  public void sleep() {
    System.out.println("잔다.");
  }

}
