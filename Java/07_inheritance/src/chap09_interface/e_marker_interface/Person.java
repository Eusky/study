package chap09_interface.e_marker_interface;

public class Person {
  
  public void eat(Food food) {
    food.howToEat();
  }
  
  public void favoriteEat(Favorite favorite) {
    ((Food)favorite).howToEat();
  }

}
