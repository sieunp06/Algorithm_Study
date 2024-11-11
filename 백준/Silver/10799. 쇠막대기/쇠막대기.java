import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        
        int answer = 0;
        int status = 0;

        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char now = arr[i];
            if (now == '(') {
                status++;
            }
            if (now == ')') {
                if (status > 0) {
                    status--;
                }
                if (arr[i - 1] == '(') {
                    answer += status;
                } else {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}