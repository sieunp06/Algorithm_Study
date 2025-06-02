import java.io.*;
import java.util.*;

public class Main {
    static int[] nums = new int[3];

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            nums[0] = Integer.parseInt(stringTokenizer.nextToken());
            nums[1] = Integer.parseInt(stringTokenizer.nextToken());
            nums[2] = Integer.parseInt(stringTokenizer.nextToken());

            if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
                break;
            }

            Arrays.sort(nums);

            if (Math.pow(nums[0], 2) + Math.pow(nums[1], 2) == Math.pow(nums[2], 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
