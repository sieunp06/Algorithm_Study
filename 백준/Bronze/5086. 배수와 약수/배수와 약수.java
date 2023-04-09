import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(bf.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (num1 != 0 && num2 != 0) {
                if (num2 % num1 == 0)
                    sb.append("factor").append('\n');
                else if (num1 % num2 == 0)
                    sb.append("multiple").append('\n');
                else
                    sb.append("neither").append('\n');
            } else break;
        }

        System.out.print(sb);
    }
}