package chap09_interface.e_marker_interface;

public class Sashimi implements Food , Favorite {
  @Override
  public void howToEat() {
    System.out.println("회는 초장, 간장, 와사비 등과 함께 먹습니다.");
  }

}
