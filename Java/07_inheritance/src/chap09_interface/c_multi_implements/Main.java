package chap09_interface.c_multi_implements;

public class Main {

  public static void main(String[] args) {
    
    // Camera 타입: Camera 인터페이스의 메소드만 보입니다. Phone 인터페이스의 기능은 캐스팅해서 호출해야 합니다.
    Camera galaxy = new SmartPhone();
    galaxy.picture();
    ((Phone)galaxy).call();
    
    // Phone 타입: Phone 인터페이스의 메소드만 보입니다. Camera 인터페이스의 기능은 캐스팅해서 호출해야 합니다.
    Phone iphone = new SmartPhone();
    ((Camera)iphone).picture();
    iphone.call();
    
    // SmartPhone 타입: SmartPhone 클래스의 메소드가 모두 보입니다.
    SmartPhone smartPhone = new SmartPhone();
    smartPhone.call();
    smartPhone.picture();

  }

}
