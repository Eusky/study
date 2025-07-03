package chap01_is_a;

//  1. 상속
//  1) 기존 클래스(부모클래스, 슈퍼클래스)의 필드와 메서드를 새로운 클래스(자식클래스, 서브클래스)가 물려받아 재사용할 수 있게 해주는 객체지향 프로그래밍의 핵심 개념입니다.
//  2) 상속을 통해 코드의 재사용성을 높이고, 클래스 간 계층 구조를 명확히 할 수 있습니다.
//  3) 자바에서는 두 개 이상의 부모를 가지는 다중 상속은 불가능합니다.
//  4) 상속 문법
//    class 자식클래스 extends 부모클래스 { }
//  
//  2. 상속 관계 살펴보기
//  1) "A는 B이다" 관계를 가진 클래스들을 상속 관계로 만들 수 있습니다. (is-a 관계)
//  2) "A는 B를 가지고 있다" 관계를 가진 클래스들도 상속 관계로 만들 수 있으나, 일반적으로 권장하지는 않습니다. (has-a 관계)
//  3) 상속 관계 예시
//    * 학생은 사람이다.      Student is a Person.
//    * 워커는 사람이다.      Worker is a Person.
//    * 개발자는 워커이다.    Developer is a Worker.
//    * 디자이너는 워커이다.  Designer is a Worker.
//  
//  [계층 구조]
//                    +--------------+
//                    | Person       |
//                    +--------------+
//                    | eat()        |
//                    | sleep()      |
//                    +--------------+
//                      ↑          ↑
//           +--------------+  +--------------+
//           | Worker       |  | Student      |
//           +--------------+  +--------------+
//           | startWork()  |  | study()      |
//           | finishWork() |  +--------------+
//           +--------------+
//              ↑        ↑
//  +--------------+  +--------------+
//  | Developer    |  | Designer     |
//  +--------------+  +--------------+
//  | develop()    |  | design()     |
//  +--------------+  +--------------+
//  
//  
//  [확장 구조]
//  
//  +-------------------------------------------+
//  | Developer - develop()                     |
//  |  +-------------------------------------+  |
//  |  | Worker - startWork(), finishWork() |  |
//  |  |  +-------------------------------+  |  |
//  |  |  | Person - eat(), sleep()       |  |  |
//  |  |  +-------------------------------+  |  |
//  |  +-------------------------------------+  |
//  +-------------------------------------------+


public class Main {

  public static void main(String[] agrs) {
    
    //------------ Student ------------//
    Student student = new Student();
    student.eat();
    student.sleep();
    student.study();
    //------------ Worker ------------//
    Worker worker = new Worker();
    worker.eat();
    worker.sleep();
    worker.startWork();
    worker.finishWork();
    //------------ Developer ------------//
    Developer developer = new Developer();
    developer.eat();
    developer.sleep();
    developer.startWork();
    developer.finishWork();
    developer.develop();
    //------------ Designer ------------//
    Designer designer = new Designer();
    designer.eat();
    designer.sleep();
    designer.startWork();
    designer.finishWork();
    designer.design();
  }

}
