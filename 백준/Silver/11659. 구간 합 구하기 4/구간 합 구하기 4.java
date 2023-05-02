import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        nums[0] = 0;
        for (int i = 1; i <= N; i ++) nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(nums[B] - nums[A - 1]).append('\n');
        }

        System.out.println(sb);
    }
}