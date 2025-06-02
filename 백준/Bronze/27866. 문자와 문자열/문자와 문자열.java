import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String input = bufferedReader.readLine();
        int idx = Integer.parseInt(bufferedReader.readLine());

        System.out.println(input.charAt(idx - 1));
    }
}
