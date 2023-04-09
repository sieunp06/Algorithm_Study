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
        int X = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        st = new StringTokenizer(bf.readLine());
        
        for (int i = 0; i < N; i++) 
            nums[i] = Integer.parseInt(st.nextToken());
        
        for (int i : nums) {
            if (i < X) {
                sb.append(i).append(' ');
            }
        }
        
        System.out.println(sb);
    }
}