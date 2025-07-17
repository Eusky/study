package pkg_practice7;

public class Main {

  public static void main(String[] args) {
   
    myArrayList arr = new myArrayList();
    
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);
    arr.add(6);
    arr.add(7);
    arr.add(8);
    arr.add(9);
    arr.add(10);
    System.out.println(arr.size());
    System.out.println(arr);
    System.out.println(arr.remove(9) + "가 삭제됐습니다.");
    System.out.println(arr);
    
//    System.out.println(arr.get(9));
    
    arr.add(1);
    System.out.println(arr);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    System.out.println(arr);
    arr.trimToSize();
    System.out.println(arr);
    
    
  }

}
