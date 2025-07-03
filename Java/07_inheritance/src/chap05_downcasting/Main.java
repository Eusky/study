package chap05_downcasting;

/*
 * down-casting
 * 
 * 1. up-casting 되어 있는 객체(인스턴스)의 타입을 다시 서브클래스의 타입으로 변환하는 것을 의미합니다.
 * 2. up-casting 되어있으면 super 클래스의 멤버만 호출할 수 있기 때문에, 경우에 따라 서브클래스 타입으로 변환이 필요할 수 있습니다.
 * 3. 안전한 변환을 위해서 객체의 실제 타입 여부를 점검하는 instanceof 연산자를 활용할 수 있습니다.
 */

public class Main {
  
  public static void main(String[] args) {
    
    // 직접 다운캐스팅
    Dog chihuahua = new Chihuahua();
    chihuahua.bark(); //---------- 슈퍼클래스에 bark() 메소드가 있으므로 그냥 호출하면 됩니다.
    ((Chihuahua) chihuahua).getAngry(); // 슈퍼클래스에 없는 getAngry()는 다시 서브클래스 타입으로 바꾼 뒤 호출합니다.
   
    
    // 타입 확인 후 다운캐스팅
    Dog husky = new Husky();
    husky.bark();
    if(husky instanceof Husky) {
      // husky 인스턴스가 실제로는 Husky 타입이라면 husky.pullSnowSled() 형식으로 입력할 수 있습니다. 자동으로 다운캐스팅 됩니다. 
      // instanceof 연산자를 사용했기 때문입니다.
      ((Husky) husky).pullSnowSled();
    }
    
  }
}
