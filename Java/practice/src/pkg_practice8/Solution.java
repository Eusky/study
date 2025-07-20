package pkg_practice8;

class Solution {
  public int solution(int[] numbers, int k) {
      int answer = 0;
      int index = 0;
      
      for(int i = 0; i < k - 1; i++) {
         
              if(index == numbers.length - 2) {
                  index = 0;
              }
              else if(index == numbers.length - 1) {
                  index = 1;
              }
              else {
                  index = index + 2;
              }
          
      }
      answer = numbers[index];
      return answer;
  }
}