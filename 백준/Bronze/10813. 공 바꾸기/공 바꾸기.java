import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        for (int i = 0; i < N; i++)
            nums[i] = i + 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int tmp = nums[k - 1];
            nums[k - 1] = nums[l - 1];
            nums[l - 1] = tmp;
        }

        for (int i = 0; i < N; i++)
            sb.append(nums[i]).append(" ");

        System.out.println(sb);
    }
}