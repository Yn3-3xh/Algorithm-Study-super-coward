/*
- 회문, 팰린드롬: 앞 뒤가 동일
- 유사회문: 한 문자를 삭제 -> 회문
- INPUT: 문자열의 개수 T, 문자열..
- OUTPUT: 회문(0)인지, 유사회문(1)인지, 일반 문자열(2)인지
1. (회문) 주어진 문자열 = reverse한 문자열 인지 >> 0 리턴
2. (유사회문) 1번이 아닐 경우, 주어진 문자열의 인덱스 left와 right 끝 문자가 같은지 중앙으로 반복하여 확인
3. (유사회문) 2번에서 다른 문자가 나왔으면, (left+1, right)과 (left, right-1) 부터 중앙으로 반복하여 확인
4. (유사회문) 3번에서 다른 문자가 안 나왔을 경우 >> 1 리턴
5. 3번에서 다른 문자가 또 나왔으면, 한 문자만 다른 것이 아니므로, 유사회문이 아님.
6. 회문과 유사회문 모두 아닐 경우 >> 2 리턴
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < T; i++) {
                String str = br.readLine();
                sb.append(solution(str)).append("\n");
            }
            System.out.print(sb.toString());
        } catch (IOException e) {
            System.out.print("[ERROR] " + e.getMessage());
        }
    }
    
    private static int solution(String str) {
        if (isPalindrome(str)) {
            return 0;
        } else if (isPseudoPalidrome(str, 0, str.length() - 1, 0)) {
            return 1;
        } else {
            return 2;
        }
    }

    private static boolean isPalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    private static boolean isPseudoPalidrome(String str, int left, int right, int removalCnt) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                removalCnt++;
                if (removalCnt > 1) {
                    return false;
                }
                return isPseudoPalidrome(str, left + 1, right, removalCnt) || isPseudoPalidrome(str, left, right - 1, removalCnt);
            }
            left++;
            right--;
        }
        
        return true;
    }
}