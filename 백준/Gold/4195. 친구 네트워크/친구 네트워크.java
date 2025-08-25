import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int T, F;
    private static Map<String, Integer> friends;
    private static int[] parents;
    private static int[] size;      
    private static int nextId;

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            init();
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws NumberFormatException, IOException {
        F = Integer.parseInt(bufferedReader.readLine());

        int N = 2 * F + 5;
        friends = new HashMap<>(N * 2);
        parents = new int[N];
        size = new int[N];
        nextId = 0;

        for (int i = 0; i < F; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            String name1 = stringTokenizer.nextToken();
            String name2 = stringTokenizer.nextToken();

            int a = getId(name1);
            int b = getId(name2);
            stringBuilder.append(union(a, b)).append('\n');
        }
    }

    private static int getId(String name) {
        Integer id = friends.get(name);
        if (id != null) return id;

        int cur = nextId++;
        friends.put(name, cur);
        parents[cur] = cur; 
        size[cur] = 1;     
        return cur;
    }

    private static int union(int num1, int num2) {
        int ra = find(num1);
        int rb = find(num2);

        if (ra == rb) return size[ra];

        if (size[ra] < size[rb]) {
            int tmp = ra; ra = rb; rb = tmp;
        }
        parents[rb] = ra;
        size[ra] += size[rb];
        return size[ra]; 
    }

    private static int find(int num) {
        if (parents[num] == num) return num;
        parents[num] = find(parents[num]);
        return parents[num];
    }
}
