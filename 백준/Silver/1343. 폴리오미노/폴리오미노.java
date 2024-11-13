import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine()
                .replaceAll("XXXX", "AAAA")
                .replaceAll("XX", "BB");
        if (text.contains("X")) {
            System.out.println(-1);
            return;
        }
        System.out.println(text);
    }
}