import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] nums = new int[8];
        for (int i = 0; i < 8; i++) {
            nums[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int ascIdx = 1;
        int desIdx = 8;

        for (int i = 0; i < 8; i++) {
            if (ascIdx == nums[i]) {
                ascIdx++;
            }
            if (desIdx == nums[i]) {
                desIdx--;
            }
        }

        if (ascIdx == 9) {
            System.out.println("ascending");
        } else if (desIdx == 0) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
