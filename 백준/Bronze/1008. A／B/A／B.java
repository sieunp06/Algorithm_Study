import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        double total = Double.parseDouble(st.nextToken());

        total /= Double.parseDouble(st.nextToken());
        
        System.out.println(total);
    }
}