import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Long num1 = Long.parseLong(st.nextToken());
        Long num2 = Long.parseLong(st.nextToken());
        Long num3 = Long.parseLong(st.nextToken());

        System.out.println(num1 + num2 + num3);
    }
}