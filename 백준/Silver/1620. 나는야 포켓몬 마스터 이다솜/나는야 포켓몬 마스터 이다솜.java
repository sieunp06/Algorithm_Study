import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            String input = bf.readLine();
            map.put(input, i);
            arr.add(input);
        }
        
        String input;
        
        for (int i = 1; i <= M; i++) {
            input = bf.readLine();
            if (map.containsKey(input)) {	// 문자
                System.out.println(map.get(input));
            } else {	
            	System.out.println(arr.get(Integer.parseInt(input) - 1));
            }
        }
    }
}