import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {			
	private static int[] solution(int S, int N, int[] numbers) {
		int[] cache = new int[S];
		
		for (int x : numbers) {
			int pos = -1;	// 인덱스 번호
			for (int i = 0; i < S; i++) {
				if (x == cache[i])
					pos = i;
			}
			if (pos == -1) {
				for (int j = S - 1; j >= 1; j--) {
					cache[j] = cache[j - 1];
				}
				cache[0] = x;
			} else {
				for (int j = pos; j >= 1; j--) {
					cache[j] = cache[j - 1];
				}
				cache[0] = x;
			}
		}
		
		return cache;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		
		int S = Integer.parseInt(st1.nextToken());
		int N = Integer.parseInt(st1.nextToken());
		
		int[] numbers = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st2.nextToken());
		
		int[] answer = solution(S, N, numbers);
		
		for (int i = 0 ; i < S; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
