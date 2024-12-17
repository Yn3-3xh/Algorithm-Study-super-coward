/*
- 0과 1로만 이루어진 문자열S
- 연속된 하나 이상의 숫자를 뒤집을 수 있다.
1. 연속된 0 그룹 수와 연속된 1의 그룹 수 구하기
2. 1번에서 나온 그룹 수 중 0이 있으면 뒤집을 필요가 없음
3. 1번에서 나온 그룹 수 중 적은 그룹 위주로 뒤집기
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String S = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            S = br.readLine();
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        char zero = '0';
        char one = '1';
        int zeroGroupCnt = 0;
        int oneGroupCnt = 0;
        char temp = S.charAt(0);
        if (temp == zero) {
            zeroGroupCnt++;
        } else {
            oneGroupCnt++;
        }

        for (int i = 1; i < S.length(); i++) {
            char current = S.charAt(i);
            if (current != temp) {
                temp = current;
                if (current == zero) {
                    zeroGroupCnt++;
                } else {
                    oneGroupCnt++;
                }
            }
        }
        
        int result = 0;
        if (zeroGroupCnt != 0 && oneGroupCnt != 0) {
            result = Math.min(zeroGroupCnt, oneGroupCnt);
        }
        System.out.println(result);
    }
}