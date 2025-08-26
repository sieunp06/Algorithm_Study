import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    private static class TrieNode {
        TrieNode[] child = new TrieNode[10]; 
        boolean isEnd;
        boolean hasChild() {
            for (TrieNode c : child) if (c != null) return true;
            return false;
        }
    }

    private static class Trie {
        TrieNode root = new TrieNode();

        boolean insertAndConflict(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int idx = c - '0';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new TrieNode();
                }
                cur = cur.child[idx];
                if (cur.isEnd) return true;    
            }
            if (cur.hasChild()) return true;  
            cur.isEnd = true;
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            Trie trie = new Trie();
            boolean conflict = false;

            for (int i = 0; i < n; i++) {
                String s = bufferedReader.readLine().trim();
                if (!conflict && trie.insertAndConflict(s)) {
                    conflict = true; 
                }
            }
            stringBuilder.append(conflict ? "NO" : "YES").append('\n');
        }
        System.out.print(stringBuilder);
    }
}
