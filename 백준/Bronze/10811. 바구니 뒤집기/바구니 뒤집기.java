import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Integer> num_St = new Stack<>();

        st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];

        for (int first = 1; first <= N; first++)
            nums[first] = first;

        for (int reverse = 0; reverse < M; reverse++) {
            st = new StringTokenizer(bf.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            for (int k = j; k >= i; k--)
                num_St.push(nums[k]);

            for (int k = j; k >= i; k--) 
                nums[k] = num_St.pop();
        }

        for (int i = 1; i < nums.length; i++)
            sb.append(nums[i]).append(" ");

        System.out.println(sb);
    }
}