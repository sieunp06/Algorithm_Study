import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        long o, n;
        Node(long o, long n) {
            this.o = o;
            this.n = n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            arr[i] = new Node(
                    Long.parseLong(st.nextToken()),
                    Long.parseLong(st.nextToken())
            );
        }

        Arrays.sort(arr, (a, b) -> {
            long da = a.n - a.o;
            long db = b.n - b.o;

            if (da >= 0 && db < 0) return -1;
            if (da < 0 && db >= 0) return 1;

            if (da < 0) {
                return Long.compare(b.n, a.n);
            }

            return Long.compare(a.o, b.o);
        });

        long a = 0, b = 0;

        for (Node v : arr) {
            long need = -a;
            long diff = -a + b - v.o;

            long add = Math.min(need, diff);
            long newA = -add;
            long newB = diff + v.n - add;

            a = newA;
            b = newB;
        }

        System.out.println(a);
    }
}
