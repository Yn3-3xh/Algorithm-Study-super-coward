/*
- 1~N까지 N명의 사람이 원형
- 1~7까지면 3번째, 6번째, 2번째, ... 순으로 K만큼 더하다가 N을 넘기면 K-N을 해준다.
- 이때 K만큼 더한 수는 제거한다.
- 조회보단 삽입과 삭제가 빈번하니 LinkedList를 사용하자.
1. LinkedList 생성 후 입력값을 넣는다.
2. LinkedList에서 cycleIdx += K - 1 번째 수를 제거하고, result에 담는다.
3. num > N일 경우 cycleIdx %= cycle크기 번째 수를 제거하고, result에 담는다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int N = 0;
        int K = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        
        LinkedList<Integer> cycle = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            cycle.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        int cycleIdx = 0;
        while (!cycle.isEmpty()) {
            cycleIdx += K - 1 ;
            cycleIdx %= cycle.size();

            int num = cycle.remove(cycleIdx);
            sb.append(num);
            if (!cycle.isEmpty()) {
                sb.append(", ");
            }    
        }
        
        sb.append(">");
        System.out.print(sb.toString());
    }
}