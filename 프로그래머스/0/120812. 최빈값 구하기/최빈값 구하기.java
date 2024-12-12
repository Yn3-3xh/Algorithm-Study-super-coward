/*
1. Map으로 key는 숫자, value는 개수
2. 입력 받을 때 Map에 추가
3-1. 입력을 받으면서 value를 비교해서 최댓값인 index의 key 구하기
3-2. value 최댓값이 같은 경우는 -1을 대입
*/

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
        int result = 0;
        int max = 0;
        Map<Integer, Integer> numCountingMap = new HashMap<>();
        for (int num: array) {
            int count = numCountingMap.getOrDefault(num, 0) + 1;
            if (max < count) {
                result = num;
                max = count;
            } else if (max == count) {
                result = -1;
            }
            
            numCountingMap.put(num, count);
        }
        
        return result;
    }
}
