import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int T;   // 테스트 케이스 개수
    private static int N;
    private static String M;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            boolean flag = true;
            if (M.length() < N) {
                flag = false;
            }

            if (flag) {
                for (int i = M.length() - N; i < M.length(); i++) {
                    if (M.charAt(i) == '0') {
                        flag = false;
                        break;
                    }
                }
            }

            stringBuilder.append("#").append(testCase).append(" ").append(flag ? "ON" : "OFF").append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.toBinaryString(Integer.parseInt(stringTokenizer.nextToken()));
    }
}
