import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] candies;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        candies = new char[N][N];

        for (int i = 0; i < N; i++) {
            String col = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                candies[i][j] = col.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (candies[i][j - 1] != candies[i][j]) {
                    int[] target1 = {i, j - 1};
                    int[] target2 = {i, j};
                    swap(target1, target2);
                    check();
                    swap(target2, target1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (candies[j - 1][i] != candies[j][i]) {
                    int[] target1 = {j - 1, i};
                    int[] target2 = {j, i};
                    swap(target1, target2);
                    check();
                    swap(target2, target1);
                }
            }
        }

        System.out.println(max);
    }

    private static void swap(int[] target1, int[] target2) {
        char tmp = candies[target1[0]][target1[1]];
        candies[target1[0]][target1[1]] = candies[target2[0]][target2[1]];
        candies[target2[0]][target2[1]] = tmp;
    }

    private static void check() {
        for (int i = 0; i < candies.length; i++) {
            int len = 1;
            for (int j = 1; j < candies.length; j++) {
                if (candies[i][j - 1] != candies[i][j]) {
                    len = 1;
                    continue;
                }
                len++;
                max = Math.max(len, max);
            }
        }

        for (int i = 0; i < candies.length; i++) {
            int len = 1;
            for (int j = 1; j < candies.length; j++) {
                if (candies[j - 1][i] != candies[j][i]) {
                    len = 1;
                    continue;
                }
                len++;
                max = Math.max(len, max);
            }
        }
    }
}