import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String input = bf.readLine();
        
        ArrayList<Character> arr = new ArrayList<>();
        
        for (int i = 0; i < input.length(); i++) {
            arr.add(input.charAt(i));
        }
        Collections.sort(arr, Collections.reverseOrder());
        
        String answer = "";
        
        for (char x: arr) 
        	answer += x;
        
        System.out.println(answer);
    }
}