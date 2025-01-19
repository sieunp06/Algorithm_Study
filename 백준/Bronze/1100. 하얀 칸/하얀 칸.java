import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int SIZE_OF_CHESS_BOARD = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for (int i = 0; i < SIZE_OF_CHESS_BOARD; i++) {
            char[] input = bufferedReader.readLine().toCharArray();
            int start = 0;
            if (i % 2 != 0) {
                start = 1;
            }
            for (int j = start; j < SIZE_OF_CHESS_BOARD; j += 2) {
                if (input[j] == 'F') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
