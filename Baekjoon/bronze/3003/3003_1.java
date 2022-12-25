import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int[] chess = {1, 1, 2, 2, 2, 8};
        
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        
        for (int i = 0; i < chess.length; i++) {
            chess[i] -= Integer.parseInt(st.nextToken());
            if (i == chess.length - 1)
                System.out.print(chess[i]);
            else
                System.out.print(chess[i] + " ");
        }
    }
}