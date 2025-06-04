import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(bufferedReader.readLine());

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());

            if (num == 0) {
                st.pop();
                continue;
            }
            st.add(num);
        }

        long total = 0;
        while (!st.isEmpty()) {
            total += st.pop();
        }

        System.out.println(total);
    }
}
