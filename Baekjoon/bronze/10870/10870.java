import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int solution(int N) {
        if (N <= 1) return N;
        else {
            return solution(N - 1) + solution(N - 2);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        
        System.out.println(solution(N));
    }
}