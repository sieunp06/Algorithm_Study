import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());  // 학생 수
        int K = Integer.parseInt(stringTokenizer.nextToken());  // 한 방 최대 인원 수

        int[][] person = new int[6][2];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int S = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());

            person[Y - 1][S]++;
        }

        int answer = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= 1; j++) {
                answer += person[i][j] / K;
                if (person[i][j] % K != 0) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
