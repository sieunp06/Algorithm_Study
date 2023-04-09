import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        for (int i = 0; i < N; i++) 
            nums[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(nums);
        
        System.out.println(nums[0] + " " + nums[N - 1]);
    }
}