import java.util.*;
  
public class Main {
  static ArrayList<String> Solution(int n, String[] words) {
		ArrayList<String> answer = new ArrayList<>();
		
		for (String x: words) {
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		// 자연수 N - N개의 단어
		int N = stdIn.nextInt();
		String[] words = new String[N];
		
		for (int i = 0; i < N; i++) {
			words[i] = stdIn.next();
		}
		
		for (String x : Solution(N, words)) {
			System.out.println(x);
		}
		
	}
}