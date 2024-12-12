/*
1. Map으로 key는 숫자, value는 개수
2. 입력 받을 때 Map에 추가
3-1. 입력 다 받은 후 반복문으로 value를 비교해서 최댓값인 index의 key 구하기
3-2. value 최댓값이 같은 경우는 -1을 대입
*/

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> numCountingMap = new HashMap<>();
        for (int num: array) {
            numCountingMap.put(num, numCountingMap.getOrDefault(num, 0) + 1);
        }
        
        return getNumMaxCount(numCountingMap);
    }
    
    int getNumMaxCount(Map<Integer, Integer> numCountingMap) {
        int numMaxCount = 0;
        int maxCount = 0;
        
        for (Integer key: numCountingMap.keySet()) {
            int count = numCountingMap.get(key);
            if (maxCount < count) {
                numMaxCount = key;
                maxCount = count;
            } else if (maxCount == count) {
                numMaxCount = -1;
            }
        }

        return numMaxCount;
    }
}
