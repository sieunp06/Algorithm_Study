import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < T; i++) {
            String text = bf.readLine();
            char[] text_charArray = text.toCharArray();
            
            sb.append(text_charArray[0]).append(text_charArray[text.length() - 1]).append('\n');
        }
        
        System.out.println(sb);
    }
}