import java.io.*;
import java.util.*;
import java.util.stream.Collector;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            list.add(new Node(x, y));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        });

        for (Node node : list) {
            stringBuilder.append(node.x).append(" ").append(node.y).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
