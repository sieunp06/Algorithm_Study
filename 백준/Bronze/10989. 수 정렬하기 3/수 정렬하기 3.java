import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(bf.readLine());
        
        Arrays.sort(numbers);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(numbers[i] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
