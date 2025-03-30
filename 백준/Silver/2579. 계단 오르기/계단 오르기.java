import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int numOfStair;
    static int[] stairs;
    static int[] scores;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException{
        init();
        System.out.println(goUp(numOfStair));
    }

    static void init() throws IOException {
        numOfStair = Integer.parseInt(bufferedReader.readLine());

        stairs = new int[Math.max(4, numOfStair + 1)];
        scores = new int[Math.max(4, numOfStair + 1)];

        for (int i = 1; i <= numOfStair; i++) {
            stairs[i] = Integer.parseInt(bufferedReader.readLine());
        }

        if (numOfStair >= 1) {
            scores[1] = stairs[1];
        }
        if (numOfStair >= 2) {
            scores[2] = stairs[1] + stairs[2];
        }
        if (numOfStair >= 3) {
            scores[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
        }
    }

    static int goUp(int stair) {
        if (stair <= 0) return 0;
        if (scores[stair] != 0) return scores[stair];

        scores[stair] = Math.max(
                goUp(stair - 2) + stairs[stair],
                goUp(stair - 3) + stairs[stair - 1] + stairs[stair]
        );
        return scores[stair];
    }
}
