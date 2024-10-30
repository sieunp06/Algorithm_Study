import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] nums = new int[N + 3];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[1] = 0; nums[2] = 1; nums[3] = 1;

        for (int i = 2; i <= N; i++) {
            if (i % 3 == 0) {
                nums[i] = Math.min(nums[i], nums[i / 3] + 1);
            }
            if (i  % 2 == 0) {
                nums[i] = Math.min(nums[i], nums[i / 2] + 1);
            }
            nums[i] = Math.min(nums[i], nums[i - 1] + 1);
        }
        
        System.out.println(nums[N]);
    }
}