import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        int max = 0;
        int position = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int checkPosition = 0;
            
            for (int i = 1; i <= 9; i++) {
                int inputNum = Integer.parseInt(br.readLine());
                
                if (max < inputNum) {
                    max = inputNum;
                    position = i;
                }
            }
        } catch (IOException e) {
            System.out.println("[ERROR]: " + e.getMessage());
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(max);
        sb.append("\n");
        sb.append(position);
        System.out.print(sb.toString());
    }
}