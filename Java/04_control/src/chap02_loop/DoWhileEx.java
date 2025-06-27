package chap02_loop;

public class DoWhileEx {

  public static void main(String[] args) {
    // 1 ~ 100 누적하기
    
    int total = 0;
    int x = 1;
    
    // do while문은 처음 한 번은 반드시 실행해야 하는 경우에 사용합니다.
    do {
      total += x;
      x++;
    } 
    while (x < 100);
    
    System.out.println(total);


  }

}
