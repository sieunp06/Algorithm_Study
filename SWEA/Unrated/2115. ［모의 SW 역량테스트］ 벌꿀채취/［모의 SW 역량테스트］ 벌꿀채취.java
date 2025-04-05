import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, C;
    static int[][] map;
    static int maxTotalProfit;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Block {
        int x, y;
        int profit;

        Block(int x, int y, int profit) {
            this.x = x;
            this.y = y;
            this.profit = profit;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        System.out.print(sb);
    }

    static void init() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve(tc);
        }
    }

    static void solve(int tc) {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                int profit = getMaxProfit(i, j, 0, 0, 0);
                blocks.add(new Block(i, j, profit));
            }
        }

        maxTotalProfit = 0;
        for (int i = 0; i < blocks.size(); i++) {
            for (int j = i + 1; j < blocks.size(); j++) {
                if (!isOverlap(blocks.get(i), blocks.get(j))) {
                    int total = blocks.get(i).profit + blocks.get(j).profit;
                    maxTotalProfit = Math.max(maxTotalProfit, total);
                }
            }
        }

        sb.append("#").append(tc).append(" ").append(maxTotalProfit).append('\n');
    }

    static int getMaxProfit(int x, int y, int idx, int sum, int profit) {
        if (sum > C) return 0;
        if (idx == M) return profit;

        int honey = map[x][y + idx];
        int pick = getMaxProfit(x, y, idx + 1, sum + honey, profit + honey * honey);
        int skip = getMaxProfit(x, y, idx + 1, sum, profit);

        return Math.max(pick, skip);
    }

    static boolean isOverlap(Block a, Block b) {
        if (a.x != b.x) return false;
        return !(a.y + M <= b.y || b.y + M <= a.y);
    }
}
