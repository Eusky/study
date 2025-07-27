package pkg_practice11;

class Solution {
  public int solution(int a, int b, int c, int d) {
      int answer = 0;
      if(a == b && b == c && c == d) {
          answer = 1111 * a;
      }
      else if((a == b && b == c) || (a == b && b == d) || (a == c && c == d) || (b == c && c == d)) {
          if((a == b && b == c)) {
              answer = (int)(Math.pow((10 * a + d), 2));
          }
          else if((a == b && b == d)) {
              answer = (int)(Math.pow((10 * a + c), 2));
          }
          else if((a == c && c == d)) {
              answer = (int)(Math.pow((10 * a + b), 2));
          }
          else {
              answer = (int)(Math.pow((10 * b + a), 2));
          }
      }
      else if((a == b && c == d) || (a == c && b == d) || (a == d && b == c)) {
          if((a == b && c == d)) {
              answer = (a + c) * (a - c < 0 ? c - a : a - c);
          }
          else {
              answer = (a + b) * (a - b < 0 ? b - a : a - b);
          }
      }
      else if((a == b && c != d) || (a == c && b != d) || (a == d && b != c) || (b == c && a != d) || (b == d && a != c) ||
          (c == d && a != b))  {
          if((a == b && c != d)) {
              answer = c * d;
          }
          else if((a == c && b != d)) {
              answer = b * d;
          }
          else if((a == d && b != c)) {
              answer = b * c;
          }
          else if(b == c && a != d) {
            answer = a * d;
          }
          else if(b == d && a != c) {
            answer = a * c;
          }
          else {
            answer = a * b;
          }
      }
      else {
          if(a < b && a < c && a < d) {
              answer = a;
          }
          else if(b < a && b < c && b < d) {
              answer = b;
          }
          else if(c < a && c < b && c < d) {
              answer = c;
          }
          else {
              answer = d;
          }
      }
              
      return answer;
  }
}