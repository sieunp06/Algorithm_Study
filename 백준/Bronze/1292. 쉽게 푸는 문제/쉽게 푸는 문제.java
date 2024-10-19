import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int index = 1;

        while (list.size() < B) {
            for (int i = 0; i < index; i++) {
                list.add(index);
            }
            index++;
        }

        int total = 0;
        for (int i = A - 1; i < B; i++) {
            total += list.get(i);
        }
        System.out.println(total);
    }
}
