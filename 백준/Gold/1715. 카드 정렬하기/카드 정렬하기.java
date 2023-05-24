import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++)
            q.add(Integer.parseInt(bf.readLine()));

        int data1 = 0;
        int data2 = 0;
        int total = 0;

        while (q.size() != 1) {
            data1 = q.remove();
            data2 = q.remove();
            
            total += data1 + data2;

            q.add(data1 + data2);
        }
        System.out.println(total);
    }
}