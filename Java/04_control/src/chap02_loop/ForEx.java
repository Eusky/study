package chap02_loop;

public class ForEx {
  public static void main(String[] args) {
    // 1 ~ 100 누적하기
    int total = 0;
    
    for (int x = 1; x <= 100; x++) {
      total += x;
    }
    
    System.out.println(total);
    
    // 1 ~ 100 홀수의 평균(합계 / 개수)
    int oddTotal = 0;
    int oddCount = 0;
    double oddAverage;
    
    for (int n = 1; n <= 100; n++) {
      if(n % 2 == 1) {
        oddTotal += n;
        oddCount ++;
      }
    }
    oddAverage = (double)oddTotal / oddCount; // oddTotal을 double로 캐스팅하면, oddCount는 double로 프로모션 됩니다.
   System.out.println("합계" + oddTotal + "갯수" + oddCount + "평균" + oddAverage);
    
    
    
  }

}
