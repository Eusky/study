package chap04_set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Set<T> 인터페이스
 * 
 * 1. JCF에서 중복을 허용하지 않는 데이터 집합을 정의하는 인터페이스입니다.
 * 2. 수학의 집합과 유사하게, 동일한 요소를 2번 이상 저장할 수 없고, 요소들의 저장 순서도 없습니다. (인덱스가 없다)
 * 3. 주요 구현클래스
 *    1) HashSet: 해시 테이블 기반
 *    2) TreeSet: 이진 탐색 트리 기반, 순서 보장 가능, 정렬 상태 유지
 *    3) LinkedHashSet: 해시 테이블 + 연결 리스트 기반, 순서 보장 가능, 저장한 순서를 유지합니다.
 */

/*
 * 해시(Hash)
 * 
 * 1. 해시는 임의의 데이터를 고정된 크기의 값(해시값)으로 변환하는 방법 또는 그 결과값 자체를 의미합니다.
 * 2. 해시 함수를 통해서 입력값에 따라 서로 다른 결과값(해시값)이 나오도록 설계되어 있습니다.
 * 3. 데이터 검색, 무결성 검사, 암호화 등 다양한 분야에서 활용합니다.
 * 
 * 해시 테이블(Hash Table)
 * 
 * 1. 해시 함수를 이용해서 데이터를 저장하고 검색하는 자료구조(Data Structure) 입니다.
 * 2. 데이터를 키(Key)-값(Value) 형태로 저장하며, 키(Key)를 해시 함수에 넣어 얻은 해시값을 배열의 인덱스로 사용해 값을 저장합니다.
 * 3. 빠른 검색, 삽입, 수정이 가능합니다.
 * 
 * 해시와 해시 함수 이해하기
 * 
 * 예시) 뽀로로, 루피, 에디, 포, 크롱
 * 
 * - Key: 이름을 사용
 * - Value: 각 캐릭터의 자세한 설명을 객체로 저장 
 * 
 * - 해시 함수 (Key를 이용해서 어떤 값을 반환하는 함수)
 *   : 이름의 횟수를 해시값으로 사용하자.
 *   
 * - 뽀로로의 해시값은 34 -> 인덱스 34에 뽀로로 객체를 저장
 * - 루피의 해시값은 12   -> 인덱스 12에 루피 객체를 저장
 * - 에디의 해시값은 8    -> 인덱스 8에 에디 객체를 저장
 * - 포의 해시값은 6      -> 인덱스 6에 포 객체를 저장
 * - 크롱의 해시값은 12   -> 인덱스 12에 크롱 객체를 저장 (해시값 충돌: 체이닝 방식(연결 리스트)등으로 기존 루피 객체에 이어서 크롱 객체를 저장)
 */

public class Main {
  
  public static void hashSet() {
    Set<String> hobbies = new HashSet<String>();
    
    hobbies.add("여행");
    hobbies.add("게임");
    hobbies.add("등산");
    hobbies.add("게임");
    hobbies.add("볼링");
    
    System.out.println(hobbies); // 요소들의 저장 순서는 보장되지 않습니다.
    
    // List 인터페이스와 동일하게 Collection 인터페이스를 구현했으나 인덱스 관련 사용은 불가능합니다.
    for(String hobby : hobbies) {
      System.out.println(hobby);
    }
    
  }
  public static void unique() {
    Set<Person> people = new HashSet<Person>();
    people.add(new Person("James", 25));
    people.add(new Person("James", 25));
    people.add(new Person("James", 25));
    
    System.out.println(people);
  }
  public static void treeSet() {
    
    //-------- TreeSet: 정렬이 유지되는 Set
    
    // Set 인터페이스의 하위 인터페이스 SortedSet 인터페이스를 타입으로 사용 
    SortedSet<String> hobbies = new TreeSet<>(); // 기본 생성 방식은 오름차순 정렬을 지원
    
    
    
    hobbies.add("여행");
    hobbies.add("게임");
    hobbies.add("등산");
    hobbies.add("게임");
    hobbies.add("볼링");
    hobbies.add("낚시");
    hobbies.add("맛집탐방");
    hobbies.add("독서");
    
    System.out.println(hobbies);
    
    String first = hobbies.first();
    String last = hobbies.last();
    System.out.println(first + ", " + last);
    
    String from  = "게임";
    String to = "등산";
    System.out.println(hobbies.subSet(from, to));
    hobbies = new TreeSet<String>(Comparator.reverseOrder()); // 내림차순 정렬되는 hobbies 다시 생성
    
    hobbies.add("여행");
    hobbies.add("게임");
    hobbies.add("등산");
    hobbies.add("게임");
    hobbies.add("볼링");
    hobbies.add("낚시");
    hobbies.add("맛집탐방");
    hobbies.add("독서");
    System.out.println(hobbies);
  }
  
  public static void linkedHashSet() {
    Set<String> hobbies = new LinkedHashSet<String>();
    hobbies.add("여행");
    hobbies.add("게임");
    hobbies.add("등산");
    hobbies.add("게임");
    hobbies.add("볼링");
    hobbies.add("낚시");
    hobbies.add("맛집탐방");
    hobbies.add("독서");
    System.out.println(hobbies); // 요소들의 저장 순서를 보장합니다.
  }
  
  public static void main(String[] args) {
    // HashSet: 순서 없음
    // TreeSet: 오름차순(또는 내림차순) 정렬
    // LinkedHashSet: 저장한 순서를 보장 
    linkedHashSet();
    
    double random = Math.random();
  }

}
