/*
INPUT: 알파벳 소문자로만 이루어진 단어S
OUTPUT: a-z를 -1로 나열한 뒤, 단어S에 해당되는 알파벳이 처음 등장하는 순서를 대입

1. a-z까지의 알파벳 26개의 배열로, 값은 -1로 생성
2. 단어S로 반복문 진행
3. 단어S의 알파벳을 a-z배열에서 해당 index의 값이 -1인지 확인
4. -1인지 확인할 때 a를 빼서 인덱스 구하기 (a의 아스키 코드는 97, A는 65)
5. -1이면 단어S에서의 알파벳 순서를 대입
6. -1이 아니면 continue
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String word = "";
        int[] aToZ = new int[26];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            word = br.readLine();
        } catch (IOException e) {
            System.out.println("[ERROR]: " + e.getMessage());
        }
        
        Arrays.fill(aToZ, -1);
        for (int i = 0; i < word.length(); i++) {
            int alphabetSeq = word.charAt(i) - 'a';
            if (aToZ[alphabetSeq] == -1) {
                aToZ[alphabetSeq] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int n: aToZ) {
            sb.append(n);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}