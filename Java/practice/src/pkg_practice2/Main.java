package pkg_practice2;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    
          String[] words =  {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot"};
          int n = 3;
          int m = 0;
          boolean isAllGood = true;

          
          int[] answer = new int[2];


          for(int i=0; i<words.length-1; i++) {
              if(words[i].charAt(words[i].length() - 1) != words[i+1].charAt(0)) {
                m = i+1;
                isAllGood = false;
                break;
              }
              
              for(int j=i+1; j<words.length;j++) {
                  if(words[i].equals(words[j]) ) {
                    m = j;
                    isAllGood = false;
                    break;
                  }
               }
            }
          
           if(isAllGood) {
             answer[1] = 0;
             answer[0] = 0;
           }
           else {
             answer[1] = (int)Math.ceil((double)(m+1)/n);
             answer[0] = (m+1)%n == 0 ? n : (m+1)%n;
           }
         
          System.out.println(Arrays.toString(answer));

  }

}
