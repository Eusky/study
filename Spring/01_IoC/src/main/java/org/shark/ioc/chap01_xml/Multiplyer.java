package org.shark.ioc.chap01_xml;

public class Multiplyer {
  
  int total = 1;
  
  public int multiply(int... args) {
    if(args == null) {
      return 0;
    }
    for(int num : args) {
      total *= num;
    }
    return total;
  }
}
