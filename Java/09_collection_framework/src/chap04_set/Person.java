package chap04_set;

import java.util.Objects;

public class Person {
  
  private String name;
  private int age;
  
  public Person(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  //--------- HashSet 객체에 Person 객체를 저장할 때 오버라이드된 HashCode()와 equals()를 이요하여 
  //          기존에 저장된 Person 객체와 새로 저장하려는 Person 객체의 중복 여부를 판단합니다.
  
  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    return age == other.age && Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return "이름: " + name + ", 나이: " + age;
  }

}
