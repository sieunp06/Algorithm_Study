import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) 
            map.put(bf.readLine(), 0);
        
        int answer = 0;
        
        for (int i = 0; i < M; i++) {
            if (map.containsKey(bf.readLine())) answer++;
        }
        
        System.out.println(answer);
    }
}