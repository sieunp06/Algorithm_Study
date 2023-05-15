import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());

            if (num > 0) {  // num이 자연수라면
                q.add(num);
            } else if (num == 0) {  // num이 0이라면
                if (q.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(q.poll());
            }
        }
    }
}