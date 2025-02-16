import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int T;
    private static int W;
    private static int max;

    private static int[][] blocks;
    private static int[] verticalBlocks;

    private static final int MAX_HEIGHT = 100;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        initT();
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            getMax();
            stringBuilder.append("#").append(testCase).append(" ").append(max == Integer.MIN_VALUE ? 0 : max).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void getMax() {
        max = Integer.MIN_VALUE;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < MAX_HEIGHT; j++) {
                if (blocks[i][j] == 0) {
                    break;
                }
                max = Math.max(max, W - i - verticalBlocks[j]);
                verticalBlocks[j]--;
            }
        }
    }

    private static void initT() throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());
    }

    private static void init() throws IOException {
        W = Integer.parseInt(bufferedReader.readLine());
        blocks = new int[W][MAX_HEIGHT];
        verticalBlocks = new int[MAX_HEIGHT];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < height; j++) {
                blocks[i][j] = 1;
                verticalBlocks[j]++;
            }
        }
    }
}
