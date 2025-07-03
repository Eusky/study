package chap04_upcasting;

/*
 * up-casting
 * 
 * 1. 서브클래스 타입의 객체(인스턴스)를 슈퍼클래스 타입으로 변환할 수 있습니다.
 * 2. 슈퍼클래스 타입으로 변환된 서브클래스 객체는 슈퍼클래스의 멤버에 접근할 수 있습니다.
 * 3. 자동으로 변환되므로 강제로 캐스팅할 필요가 없습니다.
 * 4. 하나의 타입(슈퍼클래스 타입)으로 여러 객체(서브클래스 타입의 객체)를 관리할 수 있습니다.
 */


public class Main {

  public static void main(String[] args) {
    
    Dog chihuahua = new Chihuahua();
    chihuahua.bark(); // 호출할 땐 Dog의 bark()를 호출하지만, 실행할 땐 Chihuahua의 bark()가 실행됩니다.
                      // 오버라이드된 메소드의 경우 명시적으로 작성된 타입(Dog)이 아닌 실제 저장된 객체의 타입(Chihuahua)으로 메소드 연결되면서(Binding) 실행됩니다.
                      // 명시적으로 작성된 타입과 실행하는 타입이 바뀌는 것을 "동적 바인딩(Dynamic Binding)"이라고 합니다.
    
    Dog husky = new Husky();
    husky.bark();
    
    //--------------- 서로 다른 타입의 객체들을 하나의 타입으로 관리하기 ---------------//
    Dog[] dogs = new Dog[20];
    
    for(int i=0; i<20; i++) {
      
      if (i%2 == 0) {
        dogs[i] = new Chihuahua();
      }
      else {
        dogs[i] = new Husky();
      }
    }
   
    for(Dog dog : dogs) {
      if(dog != null) {
        dog.bark();
      }
    }

  }

}
