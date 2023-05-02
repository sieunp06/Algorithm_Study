import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long[] nums = new long[N];

        for (int i = 0; i < N; i++) nums[i] = Long.parseLong(st.nextToken());

        Arrays.sort(nums);

        int count = 0;

        for (int key = 0; key < N; key++) {
            long find =  nums[key];
            int startIdx = 0;
            int endIdx = N - 1;
            while (startIdx < endIdx) {
                if (nums[startIdx] + nums[endIdx] == find) {
                    if (startIdx != key && endIdx != key) {
                        count++;
                        break;
                    } else if (startIdx == key) {
                        startIdx++;
                    } else {
                        endIdx--;
                    }
                } else if (nums[startIdx] + nums[endIdx] < find) {
                    startIdx++;
                } else {
                    endIdx--;
                }
            }
        }
        System.out.println(count);
    }
}