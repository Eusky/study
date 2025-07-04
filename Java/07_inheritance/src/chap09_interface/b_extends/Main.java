package chap09_interface.b_extends;

public class Main {

  public static void main(String[] args) {
    
    Computable computer = new Computer();
    
    computer.powerOn();
    computer.powerOff();
    
    int a = 10, b = 4;
    computer.add(a, b);
    computer.sub(a, b);
    computer.mul(a, b);
    computer.div(a, b);
    computer.mod(a, b);
    

  }

}
