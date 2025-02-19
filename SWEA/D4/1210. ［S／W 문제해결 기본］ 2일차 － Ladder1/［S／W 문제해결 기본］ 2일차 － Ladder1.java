import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final int LADDER_SIZE = 100;

    private static int T = 10;   // 테스트케이스 개수
    private static int now_T;

    private static int[][] boards;
    private static int goal = 0;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        while (T-- > 0) {
            init();
            goal = findGoalLocation();
            stringBuilder.append("#").append(now_T).append(" ").append(findGoaledStartPoint()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        now_T = Integer.parseInt(bufferedReader.readLine());
        boards = new int[LADDER_SIZE][LADDER_SIZE];
        for (int i = 0; i < LADDER_SIZE; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < LADDER_SIZE; j++) {
                boards[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static int findGoalLocation() {
        int x = -1;
        for (int i = 0; i < LADDER_SIZE; i++) {
            if (boards[LADDER_SIZE - 1][i] == 2) {
                x = i;
                break;
            }
        }
        return x;
    }

    private static int findGoaledStartPoint() {
        int startPoint = -1;
        for (int i = LADDER_SIZE - 1; i >= 0; i--) {
            if (goal > 0 && boards[i][goal - 1] == 1) { // 왼쪽 길이 있을 때
                int target = goal - 1;
                while (target >= 0) {
                    if (boards[i][target] == 0) {
                        target++;
                        break;
                    }
                    target--;
                }
                goal = target;
            } else if (goal < LADDER_SIZE - 1 && boards[i][goal + 1] == 1) {   // 오른쪽 길이 있을 때
                int target = goal + 1;
                while (target < LADDER_SIZE) {
                    if (boards[i][target] == 0) {
                        target--;
                        break;
                    }
                    target++;
                }
                goal = target;
            }
        }
        startPoint = goal;
        return startPoint;
    }
}
