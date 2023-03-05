import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < N; i++)
        	numbers.add(Integer.parseInt(bf.readLine()));
        
        Collections.sort(numbers);
        
        for (int x : numbers)
            sb.append(x).append('\n');
        System.out.println(sb);
    }
}