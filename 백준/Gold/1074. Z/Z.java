import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int r, c;
    private static int answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        find((int) Math.pow(2, N), 0, 0);
        System.out.println(answer);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        answer = 0;
    }

    private static void find(int size, int x, int y) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        if (r < x + half && c < y + half) {
            find(half, x, y);
        } else if (r < x + half && c >= y + half) {  
            answer += half * half;
            find(half, x, y + half);
        } else if (r >= x + half && c < y + half) { 
            answer += half * half * 2;
            find(half, x + half, y);
        } else {                                    
            answer += half * half * 3;
            find(half, x + half, y + half);
        }
    }
}