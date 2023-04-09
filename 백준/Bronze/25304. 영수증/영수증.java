import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int total = Integer.parseInt(bf.readLine());
        int N = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            
            while (st.hasMoreTokens()) {
                int price = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());
                
                total -= price * number;
            }
        }
        
        if (total == 0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}