import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String target = new StringBuilder(Integer.toString(N, 2)).reverse().toString();

            for (int j = 0; j < target.length(); j++) {
                if (target.charAt(j) == '1') {
                    sb.append(j).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}