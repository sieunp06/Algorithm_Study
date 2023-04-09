import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(bf.readLine());

        if (90 <= score) 
          System.out.println("A");
        else if (80 <= score)
          System.out.println("B");
        else if (70 <= score)
          System.out.println("C");
        else if (60 <= score)
          System.out.println("D");
        else 
          System.out.println("F");
    }
}