package pkg_practice12;

class Solution {
  public String solution(String my_string, int m, int c) {
      String answer = "";
      String[] arr = slice(my_string, m);
      for(int i=0; i<arr.length; i++) {
           answer += arr[i].charAt(c-1);
      }
      return answer;
  }
  
  public String[] slice(String str, int m) {
      String[] arr = new String[1000];
      int index = 0;
      int n = 0;
      for(int i=0; i<str.length()/m; i++) {
          arr[index++] = str.substring(n, n+m);
          n = n+m;
      }
      
      String[] newArr = new String[index];
      for(int i=0; i<index; i++) {
          newArr[i] = arr[i];
      }
      return newArr;
  }
}