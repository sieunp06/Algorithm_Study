import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());   // 숫자의 개수
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> dq = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.getLast().value > now) { // dq가 비어있지 않거나, 마지막 수가 최솟값이 아닐 때
                dq.removeLast();
            }
            dq.addLast(new Node(i, now));

            if (dq.getFirst().index <= i - L) {
                dq.removeFirst();
            }
            sb.append(dq.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }
}

class Node {
    public int index;
    public int value;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}