import java.util.Scanner;
  
public class Main {
    private static boolean isMax(int num, int[] around) {
        boolean answer = true;
        
        for (int x : around) {
            if (num <= x)
                return false;
        }
        
        return answer;
    }
    
    private static int solution(int N, int[][] number) {
        int answer = 0;
        
        for (int i = 1; i < N + 1; i++) {
        for (int j = 1; j < N + 1; j++) {
            int[] around = {number[i - 1][j], number[i + 1][j], 
                    number[i][j - 1], number[i][j + 1]};
            if (isMax(number[i][j], around))
                answer++;
        }
    }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        
        int[][] number = new int[N + 2][N + 2];
        
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                number[i][j] = stdIn.nextInt();
            }
        }
        
        System.out.println(solution(N, number));
    }
}