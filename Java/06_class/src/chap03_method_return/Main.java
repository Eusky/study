package chap03_method_return;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    
    Return ret = new Return();
    ret.methodA(-4);
    ret.methodA(4);
    System.out.println(ret.methodB(1, 2));

    int[] numbers = ret.methodC(3);
    System.out.println(Arrays.toString(numbers));
    
    String carInfo = ret.methodD();
    System.out.println("methodD's return: " + carInfo);
  }

}
