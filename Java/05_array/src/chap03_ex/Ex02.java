package chap03_ex;

public class Ex02 {

  public static void main(String[] args) {
    
    // 다음 정수형 배열에 저장된 모든 요소 중 최대값과 최소값을 출력하세요.
    
    int[] numbers = {42, 17, 93, 120, 117, 59, 4, 24, 180, 28, 39};
    
    int maxNum = numbers[0];
    int minNum = numbers[0];
    
    for(int i = 0; i < numbers.length; i++) {
      if(numbers[i] > maxNum) {
        maxNum = numbers[i];
      }
      if(numbers[i] < minNum) {
        minNum = numbers[i];
      }
      
    }
    System.out.println(maxNum);
    System.out.println(minNum);
    
  }
  
}
