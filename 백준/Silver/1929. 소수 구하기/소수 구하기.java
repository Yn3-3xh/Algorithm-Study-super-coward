/*
1. M이상 N이하의 자연수를 반복문을 돌린다.
2. 숫자1 이하는 소수가 아니다.
3. 숫자2 ~ 해당 자연수의 제곱근까지 반복문을 돌린다.
4. 3번에서의 수들이 제곤근한 수에 나눈 나머지가 0이면 약수가 존재한다는 의미이므로, 소수가 아니다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        int M = 0;
        int N = 0;
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
        } catch (IOException e) {
            System.out.println("[ERROR]: " + e.getMessage());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    
    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}