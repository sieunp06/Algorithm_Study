import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += heights[i];
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (i != j) {
                    total -= heights[i];
                    total -= heights[j];
                    if (total == 100) {
                        heights[i] = 0;
                        heights[j] = 0;
                        break;
                    }
                    total += heights[i];
                    total += heights[j];
                }
            }
        }
        Arrays.sort(heights);
        for (int i = 2; i < heights.length; i++) {
            System.out.println(heights[i]);
        }
    }
}
