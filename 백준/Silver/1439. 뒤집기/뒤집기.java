/*
- 0과 1로만 이루어진 문자열S
- 연속된 하나 이상의 숫자를 뒤집을 수 있다.
1. 연속된 0 그룹 수와 연속된 1의 그룹 수 구하기
2. 두 그룹 수 중 적은 수 출력하기
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            StringTokenizer group0 = new StringTokenizer(input, "0");
            StringTokenizer group1 = new StringTokenizer(input, "1");
            
            int result = Math.min(group0.countTokens(), group1.countTokens());
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}