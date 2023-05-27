import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> q2 = new PriorityQueue<>();

        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++)
            q.add(Integer.parseInt(bf.readLine()));

        int total = 0;

        while (q.size() >= 2) {
            int num1 = q.poll();
            int num2 = q.poll();

            if (num1 <= 1 || num2 <= 1) {
                q.add(num1);
                q.add(num2);
                break;
            }

            total += (num1 * num2);
        }
        
        while (!q.isEmpty())
            if (q.peek() > 0)
                total += q.poll();
            else q2.add(q.poll());

        while (!q2.isEmpty()) {
            if (q2.size() >= 2) {
                int m_num1 = q2.poll();
                int m_num2 = q2.poll();

                total += m_num1 * m_num2;
            } else {
                total += q2.poll();
            }
        }

        System.out.println(total);
    }
}