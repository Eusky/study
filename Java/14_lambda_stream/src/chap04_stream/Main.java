package chap04_stream;
/*
 * java.util.stream.Stream
 * 
 * 1. JDK8부터 도입된 기능으로, Collection Framework, 배열, 파일 등 다양한 데이터를 효율적으로 처리하기 위한 API를 제공하는 인터페이스입니다.
 * 2. 반복문에 의존하지 않고 데이터 가공 및 집계 처리 등을 함수형 스타일로 처리할 수 있습니다. 
 * 3. 주요 특징
 *    1) 함수형 프로그래밍 지원: forEach, map, filter 등 함수형 연산을 지원합니다.
 *    2) 메소드 체이닝 지원: 여러 연산을 연속해서 사용할 수 있습니다. 
 *    3) 원본 데이터 유지: 기존 JCF나 배열의 변형 없이 새로운 결과를 반환합니다.
 * 4. Stream 처리 단계
 *    1) Stream 생성 
 *      (1) JCF, 배열, 파일, 값 범위 등 다양한 데이터를 이용해 Stream 객체를 생성할 수 있습니다.
 *      (2) list.stream(), Arrays.stream(array), Stream.of(값, ...), Files.line(path) 등
 *    2) 중간 연산
 *        (1) 연산 결과로 Stream을 반환하여 메소드 체이닝이 가능하도록 처리합니다.
 *        (2) filter(), map(), peek() 등 
 *    3) 최종 연산 
 *        (1) 반환이 없는 구조를 가지고 있어 마지막에 호출할 수 있습니다. 
 *        (2) forEach(), collect(), count() 등 
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  
  public static void listStream() throws Exception {
    // List 생성
    List<Fruit> fruits = new ArrayList<>();
    fruits.add(new Fruit("Cherry", 50.0));
    fruits.add(new Fruit("Apple", 100.0));
    fruits.add(new Fruit("Banana", 200.0));
    fruits.add(new Fruit("Mellon", 400.0));
    fruits.add(new Fruit("Durian", 250.0));
    
    // 문제1. weight가 200 이상인 Fruit의 이름 출력하기
    fruits.stream()
    .filter(fruit -> fruit.getWeight() >= 200)
    .map(fruit -> fruit.getName())
    .forEach(System.out::print);
    
    // 문제2. 모든 fruit의 이름을 대문자로 변환 후 List로 모으기
    List<String> names = fruits.stream()
    .map(fruit -> fruit.getName().toUpperCase())
    .collect(Collectors.toList());
    
    System.out.println(names);
    
    // 문제3. 모든 fruit의 이름을 쉼표(,)로 구분하여 연결한 문자열 만들기
    String names2 = fruits.stream()
    .map(fruit -> fruit.getName())
    .collect(Collectors.joining(", "));
    
    System.out.println(names2);
  }
  
  public static void map() throws Exception {
    // Stream 생성
    Stream<String> s = Stream.of("spring", "summer", "fall", "winter");
    
    // Stream<R> map(Function<T,R> mapper); : Function의 반환 결과를 새로운 String으로 만든 뒤 반환 
    Stream<String> s2 = s.map(season -> season.toUpperCase());
    
    // forEach()
    s2.forEach(System.out::println);
    
    // 지금까지 과정을 물흐르듯(stream) 한 번에 처리해 봅시다.
    Stream.of("spring", "summer", "fall", "winter")  // 1. Stream 생성
      .map(String::toUpperCase)                      // 2. 중간 연산
      .forEach(System.out::println);                 // 3. 최종 연산
  }
  
  public static void filter() throws Exception {
    // Stream 생성
    IntStream s = IntStream.of(-1, 1, -2, 2, -3, 3, -4, 4, -5, 5);
    
    // Stream<T> filter(Predicate<T> predicate);
    IntStream s2 = s.filter(number -> number > 0);
    
    // forEach()
    s2.forEach(positive -> System.out.print(positive));
    
    // 지금까지 과정을 한 번에 처리해봅시다. 
    IntStream.of(-1, 1, -2, 2, -3, 3, -4, 4, -5, 5)          // 1. Stream 생성
      .filter(number -> number > 0)                          // 2. 중간(필터)
      .forEach(System.out::println);   // 3. 최종
  }
  
  public static void forEach() throws Exception {

    // Stream 생성
    Stream<String> s = Stream.of("spring", "summer", "fall", "winter");
    
    // void forEach(Consumer<T> c);
    s.forEach(season -> System.out.println(season)); // 람다 표현식
    
    // Stream 사용은 일회성이므로 다시 사용하려면 다시 생성해야 합니다.
    s = Stream.of("spring", "summer", "fall", "winter"); 
    s.forEach(System.out::println); // 메소드 참조
    
  }
  
  public static void collect() throws Exception {
    // Stream 생성
   IntStream s = IntStream.range(1, 11); // 1 이상 11 미만(1 ~ 10)
   
   // filter()
   IntStream s2 = s.filter(number -> number % 2 == 1); // 홀수만 모아서
   
   // R collect(Collector<T, A, R> collector); 
   // Collectors.toList() : public static <T> Collector<T, ?, List<T>> toList()
   List<Integer> oddNums = s2.boxed().collect(Collectors.toList());
   System.out.println(oddNums);
   
   // 지금까지 과정 한 번에 처리하기
   List<Integer> evenNums = IntStream.range(1, 11)        // 1. IntStream 생성
                           .filter(num -> num % 2 == 0)   // 2. 중간 (필터)
                           .boxed()                       // 3. IntStream -> Stream 변환
                           .collect(Collectors.toList()); // 4. 최종: List 변환 
   System.out.println(evenNums);
  }
  
  public static void peek() throws Exception {
    // Stream 생성
    Stream<String> s = Stream.of("c", "c#", "c++", "Java", "Python", "Ruby");
    
    // Stream<T> peek(Consumer<T> action);
    // forEach()와 달리 Stream을 반환하므로 중간 연산으로 사용하며, 중간 과정의 로그 추적에 주로 활용됩니다.
    
    // filter(), map(), forEach() 함께 사용
    List<String> langs = Stream.of("C", "C#", "C++", "Java", "Python", "Ruby")
                          .filter(lang -> lang.length() > 3)
                          .peek(lang -> System.out.println("Filtered: " + lang)) // 필터링 결과 확인
                          .map(lang -> lang.toLowerCase())
                          .peek(lang -> System.out.println("Maped: " + lang)) // 변환 결과 확인  
                          .collect(Collectors.toList());
    System.out.println(langs);
    
  }
  
  public static void fileStream() throws Exception {
    File javaHome = new File("C:/Program Files/Java/jdk-17");
    File[] files = javaHome.listFiles();
    
    // 문제1. 모든 파일과 디렉터리의 이름을 출력하기
    Arrays.stream(files)
    .map(file -> file.getName())
    .forEach(System.out::println);
    
    // 문제2. 모든 디렉터리의 이름을 출력하기
    Arrays.stream(files) 
    .filter(file -> file.isDirectory())
    .map(file -> file.getName())
    .forEach(System.out::println);
    
    // 문제3. 모든 파일의 크기의 합계를 출력하기 
    long sum = Arrays.stream(files)
    .filter(file -> file.isFile())
    .mapToLong(file -> file.length()) // Stream은 sum()지원이 안되므로 LongStream으로 바꾼 뒤 sum()호출
    .sum();
    
    System.out.println(sum);
  }
  
  public static void main(String[] args) {
    try {
//      forEach();
//      listStream();
//      map();
//      filter();
//      collect();
//      peek();
      fileStream();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
