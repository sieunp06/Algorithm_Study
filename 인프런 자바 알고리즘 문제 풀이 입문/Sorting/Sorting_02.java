import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {		
	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	
	private static int[] solution(int N, int[] numbers) {
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				if (numbers[j] > numbers[j + 1]) 
					swap(numbers, j, j + 1);
			}
		}
		
		return numbers;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		int[] answer = solution(N, numbers);
		
		for (int i = 0; i < N; i++)
			System.out.print(answer[i] + " ");
	}
}
