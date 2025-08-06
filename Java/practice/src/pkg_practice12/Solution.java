package pkg_practice12;

import java.util.Arrays;
class Solution {
    public int[] solution(String myString) {
        String[] answer = {};
        answer = myString.split("x");
        if(myString.endsWith("x")) {
            String[] arr = new String[answer.length + 1];
            for(int i=0; i<answer.length; i++) {
              arr[i] = answer[i];
            }
            arr[arr.length - 1] = "";
            
            System.out.println(Arrays.toString(arr));
            answer = arr;
        } 
        
        
        return Arrays.stream(answer).mapToInt(n -> n.length()).toArray();
    }
}