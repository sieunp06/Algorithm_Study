import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int person = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int down = Integer.parseInt(st.nextToken());
            int up = Integer.parseInt(st.nextToken());

            person += up;
            person -= down;

            if (max < person) {
                max = person;
            }
        }
        System.out.println(max);
    }
}