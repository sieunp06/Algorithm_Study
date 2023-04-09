import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                arr.add(i);
            }
        }
        
        if (arr.size() <= K - 1)
            System.out.println(0);
        else System.out.println(arr.get(K - 1));
    }
}