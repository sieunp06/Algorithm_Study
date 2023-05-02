import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        int count = 0;
        int startIdx = 0;
        int endIdx = N - 1;

        while (startIdx < endIdx) {
            if (nums[startIdx] + nums[endIdx] < M) {
                startIdx++;
            } else if (nums[startIdx] + nums[endIdx] > M) {
                endIdx--;
            } else {
                count++;
                startIdx++;
                endIdx--;
            }
        }
        System.out.println(count);
    }
}