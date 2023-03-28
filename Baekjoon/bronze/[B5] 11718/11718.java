import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "";
 
        while ((str = bf.readLine()) != null) {
            System.out.println(str);
        }
    }
}