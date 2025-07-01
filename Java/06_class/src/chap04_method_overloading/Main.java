package chap04_method_overloading;

public class Main {

  public static void main(String[] args) {
    
    View view = new View();
    view.print(10);
    view.print(1.5);
    view.print(new String[] {"봄", "여름", "가을", "겨울"});
    view.print(new Car());
    

  }

}
