package pkg_practice8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int index = 0;
        // 배열->리스트 변환
        List<Integer>list = Arrays.stream(array).boxed().collect(Collectors.toList());
        // 중복 제거
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        List<Integer> distinctListCount = new ArrayList<>();
        for(Integer i : distinctList) {
            int count = 0;
            for(Integer j : list) {
                if(i == j)
                    count++;
            }
            distinctListCount.add(count);
        }
        if(isDuplicate(distinctListCount)) {
          answer = -1;
          return answer;
        }
        else {
          Collections.sort(distinctListCount);
          index = distinctListCount.get(distinctListCount.size() - 1);
          answer = distinctList.get(index);
          return answer;
        }
    }
    
    private boolean isDuplicate (List<Integer> list) {
      for(Integer item : list) {
        int count = 0;
        for(Integer item_ : list) {
          if(item == item_)
            count++;
        }
        if(count>1)
          return true;
      }
      return false;
    }
}