package pkg_practice8;

public class Main {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 3, 3, 4};
    Solution2 s = new Solution2();
    Integer answer = s.solution(array);
    System.out.println("중복 제거 배열에서 해당 인덱스의 값: " + answer);
  }

}
