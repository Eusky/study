package chap09_interface.e_marker_interface;

public class Main {

  public static void main(String[] args) {
    
    Person person = new Person();
    Hamburger hamburger = new Hamburger();
    Sashimi sashimi = new Sashimi();
    BloodCakeSoup bloodCakeSoup = new BloodCakeSoup();
    
    person.eat(hamburger);
    person.eat(sashimi);
    person.eat(bloodCakeSoup); // 컴파일 오류를 내고 싶다. (실행을 막고 싶다)
    
    person.favoriteEat(hamburger);
    person.favoriteEat(sashimi);
//    person.favoriteEat(bloodCakeSoup);

  }

}
