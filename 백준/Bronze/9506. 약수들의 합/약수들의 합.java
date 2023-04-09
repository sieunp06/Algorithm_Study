import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> isPerfect (int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        int total = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                arr.add(i);
            }
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int num = Integer.parseInt(bf.readLine());

            if (num == -1)
                break;

            int total = 0;
            ArrayList<Integer> isPerfect_arr = isPerfect(num);
            for (int i = 0; i < isPerfect_arr.size(); i++) {
                total += isPerfect_arr.get(i);
            }

            if (total == num) {
                StringBuilder sb = new StringBuilder();
                sb.append(num).append(" = ");
                for (int i = 0; i < isPerfect_arr.size() - 1; i++)
                    sb.append(isPerfect_arr.get(i)).append(" + ");
                sb.append(isPerfect_arr.get(isPerfect_arr.size() - 1));
                System.out.println(sb);
            } else {
                System.out.println(num + " is NOT perfect.");
            }
        }
    }
}