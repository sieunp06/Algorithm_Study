import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int count = 0;
        while (true) {
            if (N < 0) {
                System.out.println(-1);
                return;
            }
            if (N % 5 == 0) {
                count += N / 5;
                break;
            }
            N -= 2;
            count++;
        }

        System.out.println(count);
    }
}