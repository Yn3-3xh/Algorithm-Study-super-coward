/*
- N! 출력: 1~N까지 곱하기
- f(N) = N * f(N-1)와 같은 조건으로 f(N)! = N * f(N-1)!
- 따라서 f(N)을 재귀함수로 한다. (단, 0보다 클 때까지 : 0보다 작거나 같으면 곱하기 1)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(factorial(N));
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
    
    private static int factorial(int num) {
        if (num <= 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}