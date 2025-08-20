import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder stringBuilder = new StringBuilder();
	static StringTokenizer stringTokenizer;
	
	private static int N, M;
	
	private static class TrieNode {
		TrieNode[] child = new TrieNode['z' - 'a' + 1];
		boolean isEnd;
	}
	
	private static class Trie {
		TrieNode root = new TrieNode();
		
		void insert(String word) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				int idx = c - 'a';
				if (cur.child[idx] == null) {
					cur.child[idx] = new TrieNode();
				}
				cur = cur.child[idx];
			}
			cur.isEnd = true;
		}
		
		boolean startsWith(String prefix) {
			TrieNode cur = root;
			for (char c : prefix.toCharArray()) {
				int idx = c - 'a';
				if (cur.child[idx] == null) {
					return false;
				}
				cur = cur.child[idx];
			}
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		
		Trie trie = new Trie();
		
		for (int i = 0; i < N; i++) {
			trie.insert(bufferedReader.readLine());
		}
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (trie.startsWith(bufferedReader.readLine())) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
