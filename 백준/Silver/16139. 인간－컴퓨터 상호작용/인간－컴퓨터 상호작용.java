import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        String input = bufferedReader.readLine();
        int q = Integer.parseInt(bufferedReader.readLine());
        int[][] prefix = new int[26][input.length() + 1];

        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                prefix[j][i + 1] = prefix[j][i];
            }
            prefix[c][i + 1]++;
        }

        for (int i = 0; i < q; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char a = stringTokenizer.nextToken().charAt(0);
            int l = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());

            int idx = a - 'a';
            stringBuilder.append(prefix[idx][r + 1] - prefix[idx][l]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
