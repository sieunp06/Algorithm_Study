import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        // 2 3 5 7 -> 한 자리 소수

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    public static void DFS(int num, int jarisu) {
        if (jarisu == N) {
            // 탐색 종료
            if (isPrime(num))
                System.out.println(num);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {   // 짝수
                continue;
            }
            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, jarisu + 1);
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}