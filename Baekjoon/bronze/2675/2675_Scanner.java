import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        
        for (int i = 0; i < N; i++) {
            String answer = "";
            int reply = stdIn.nextInt();
            String input = stdIn.next();
            for (int j = 0; j < input.length(); j++) {
                for (int k = 0; k < reply; k++)
                    answer += input.charAt(j);
            }
            System.out.println(answer);
        }
    }
}