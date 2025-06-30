package chap06_constructor;

public class Brand {
  
  String name; //--------- 브랜드 이름
  String nation; //------- 브랜드 국적
  
  // 생성자
  Brand(String name, String nation) {
    this.name = name;
    this.nation = nation;
  }

  // 메소드
  void printInfo() {
    System.out.println(name + " " + nation);
  }
}
