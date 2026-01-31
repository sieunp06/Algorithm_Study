import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long B;
    static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        B = Long.parseLong(stringTokenizer.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(stringTokenizer.nextToken()) % 1000;
            }
        }

        int[][] result = pow(A, B);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stringBuilder.append(result[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }

    static int[][] pow(int[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }

        int[][] half = pow(matrix, exp / 2);
        int[][] result = multiply(half, half);

        if (exp % 2 == 1) {
            result = multiply(result, A);
        }

        return result;
    }

    static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] res = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += (long) m1[i][k] * m2[k][j];
                }
                res[i][j] = (int) (sum % 1000);
            }
        }
        return res;
    }
}
