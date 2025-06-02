import java.io.*;
import java.util.*;

public class Main {
    static String[] inputs = new String[3];

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(calAsInt());
        System.out.println(calAsString());
    }

    static void init() throws IOException {
        for (int i = 0; i < 3; i++) {
            inputs[i] = bufferedReader.readLine();
        }
    }

    static int calAsInt() {
        return Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]) - Integer.parseInt(inputs[2]);
    }

    static int calAsString() {
        return Integer.parseInt(inputs[0] + inputs[1]) - Integer.parseInt(inputs[2]);
    }
}
