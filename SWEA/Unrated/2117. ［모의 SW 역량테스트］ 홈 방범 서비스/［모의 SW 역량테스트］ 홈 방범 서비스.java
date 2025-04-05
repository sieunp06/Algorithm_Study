import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[][] map;
    static int maxHouse;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            solve();
            System.out.println("#" + tc + " " + maxHouse);
        }
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        maxHouse = 0;
    }

    static void solve() {
        int maxK = N + 1;  // K는 최대 N+1 까지 가능

        for (int k = 1; k <= maxK; k++) {
            int cost = k * k + (k - 1) * (k - 1);

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    int houseCount = countHouses(x, y, k);

                    if (houseCount * M >= cost) {
                        maxHouse = Math.max(maxHouse, houseCount);
                    }
                }
            }
        }
    }

    static int countHouses(int x, int y, int k) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Math.abs(i - x) + Math.abs(j - y) < k && map[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
