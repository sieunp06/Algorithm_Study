import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {			
	private static String solution(int N, int[] numbers) {		
		Arrays.sort(numbers);
		
		for (int i = 0; i < N - 1; i++) {
			if (numbers[i] == numbers[i + 1]) return "D";
		}
		return "U";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(solution(N, numbers));
	}
}
