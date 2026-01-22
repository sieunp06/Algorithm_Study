import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long[] count = new long[M];
        long answer = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long prefix = 0;
        for(int i = 0; i < N; i++){
            prefix = (prefix + Long.parseLong(stringTokenizer.nextToken())) % M;
            count[(int)prefix]++;
        }

        answer += count[0];

        for(int i = 0; i < M; i++){
            long c = count[i];
            answer += c * (c - 1) / 2;
        }

        System.out.println(answer);
    }
}
