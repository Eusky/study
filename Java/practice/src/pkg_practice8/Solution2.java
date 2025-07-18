package pkg_practice8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution2 {
    public int solution(int[] array) {
    	
        int answer = 0;
        int value = 0;
        int index = 0;
        
        // 배열->리스트 변환
        List<Integer>list = Arrays.stream(array).boxed().collect(Collectors.toList());
        
        // 중복 제거
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        
        // 중복제거 후 리스크 크기가 1이면 
        if(distinctList.size() == 1) {
        	answer = distinctList.get(0);
        	return answer;
        }
        
        // 등장 횟수 저장 배열 		
        List<Integer> distinctListCount = new ArrayList<>();
        for(Integer i : distinctList) {
            int count = 0;
            for(Integer j : list) {
                if(i.equals(j))
                    count++;
            }
            distinctListCount.add(count);
        }
        // 등장 횟수 저장 배열 복사(정렬 전)
        List<Integer> copiedDistinctListCount = new ArrayList<>(distinctListCount);
        
        // 등장 횟수 저장 배열의 값이 중복될 경우
        if(isDuplicate(distinctListCount)) {
          answer = -1;
          return answer;
        }
        else {
          // 정렬된 등장횟수배열의 마지막 값(최댓값)
          value = distinctListCount.get(distinctListCount.size() - 1);
          
          // 가장 많이 등장한 값의 인덱스를 구하고 중복제거 배열에서 값 추출
          index = copiedDistinctListCount.indexOf(value);
          answer = distinctList.get(index);
          return answer;
        }
    }
    // 최빈값이 중복되는지 확인 
    private boolean isDuplicate (List<Integer> list) {
      Collections.sort(list);
      Integer el1 = list.get(list.size() - 1);
      Integer el2 = list.get(list.size() - 2);
      return el1 == el2;
    }
}