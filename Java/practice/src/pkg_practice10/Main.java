package pkg_practice10;

public class Main {

  public static void main(String[] args) {
    MyLinkedList<String> list = new MyLinkedList<>();
    list.add("abc");
    list.add("123");
    list.add("456");
    list.add("qwe");
    System.out.println(list);
    System.out.println(list.remove(1));
    System.out.println(list);
    
  }

}
