import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M;
    static String[] strings, tests;

    static Trie trie = new Trie();

    public static void main(String[] args) throws IOException {
        init();
        for (String s : strings) {
            trie.insert(s);
        }

        int count = 0;
        for (String s : tests) {
            if (trie.startsWith(s)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        strings = new String[N];
        tests = new String[M];

        for (int i = 0; i < N; i++) {
            strings[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < M; i++) {
            tests[i] = bufferedReader.readLine();
        }
    }
}

class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return false;
        }
        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}