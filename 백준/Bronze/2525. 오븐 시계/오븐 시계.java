import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cook = Integer.parseInt(bf.readLine());

        M += cook;

        while (M >= 60) {
            H++;
            M -= 60;

            if (H >= 24) 
                H -= 24;
        }
        
        System.out.println(H + " " + M);
    }
}