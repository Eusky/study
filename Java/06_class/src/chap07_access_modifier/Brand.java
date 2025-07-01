package chap07_access_modifier;

/*
 * 필드에 간접적으로 접근하는 방법
 * 
 * 1. Getter 
 *  1) 필드 값을 반환하는 메소드입니다.
 *  2) Getter의 이름은 "get + 필드" 또는 "is + 필드" 규칙을 따릅니다.
 * 2. Setter
 *  1) 인자를 받아서 필드에 저장하는 메소드입니다.
 *  2) Getter의 이름은 "set + 필드" 규칙을 따릅니다.
 */

public class Brand {
  // 필드
  private String name; //--------- 브랜드 이름
  private String nation; //------- 브랜드 국적
  
  // 생성자
  public Brand() {
    this("Benz", "Germany");
  }
  
  public Brand(String name, String nation) {
    this.name = name;
    this.nation = nation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  // 메소드
  public void printInfo() {
    System.out.println(name + " " + nation);
  }
  
}
