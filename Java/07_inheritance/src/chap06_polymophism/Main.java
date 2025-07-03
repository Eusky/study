package chap06_polymophism;

public class Main {

  public static void main(String[] args) {
    
    Dog chihuahua =  new Chihuahua("영웅이");
    Dog husky = new Husky("호걸이");
    
  
    Person person = new Person();
    person.feedFood("사료", chihuahua);
    person.feedFood("간식", husky);

  }
}
