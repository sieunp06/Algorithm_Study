import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.ObjLongConsumer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];

        for (int i = 1; i <= N; i++)
            nums[i] = i;

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(bf.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int z = i; z <= j; z++)
                q.offer(nums[z]);

            for (int z = 0; z < k - i; z++)
                q.offer(q.poll());

            for (int z = i; z <= j; z++)
                nums[z] = q.poll();
        }

        for (int m = 1; m <= N; m++)
            sb.append(nums[m]).append(' ');

        System.out.println(sb);
    }
}