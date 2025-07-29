package org.shark.ioc.chap02_java;

public class Adder {
  
  public int add(int... args) {
    if(args == null) {
      return 0;
    }
    int total = 0;
    for(int num : args) {
      total += num;
    }
    return total;
  }

}
