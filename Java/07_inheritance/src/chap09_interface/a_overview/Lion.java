package chap09_interface.a_overview;

public class Lion implements Animal {

  @Override
  public void move() {
    System.out.println("땅에서 움직입니다.");
  }

}
