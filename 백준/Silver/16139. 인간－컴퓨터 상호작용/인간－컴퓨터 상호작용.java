import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        String input = bufferedReader.readLine();
        int q = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < q; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char a = stringTokenizer.nextToken().charAt(0);
            int l = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());

            int[] alphabet = new int[input.length() + 1];
            for (int j = 1; j <= input.length(); j++) {
                if (input.charAt(j - 1) == a) {
                    alphabet[j] = alphabet[j - 1] + 1;
                } else {
                    alphabet[j] = alphabet[j - 1];
                }
            }
            stringBuilder.append(alphabet[r + 1] - alphabet[l]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
