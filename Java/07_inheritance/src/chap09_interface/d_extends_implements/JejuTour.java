package chap09_interface.d_extends_implements;

// 클래스를 먼저 상속하고, 인터페이스를 나중에 구현합니다.

public class JejuTour extends Domestic implements Trip {

  @Override
  public void sightSeeing() {
    System.out.println("한라산");
  }

  @Override
  public void foodTrip() {
    System.out.println("감귤초콜릿");
  }
  
  

}
