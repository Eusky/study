package org.shark.ioc.chap02_java;

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
