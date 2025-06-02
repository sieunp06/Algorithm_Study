import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());

        int count = 1;
        int max = 1;

        while (n > max) {
            max += 6 * count;
            count++;
        }

        System.out.println(count);
    }
}
