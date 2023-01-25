import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Main {
  private static void swap(int[] numbers, int min, int i) {
		int tmp = numbers[min];
		numbers[min] = numbers[i];
		numbers[i] = tmp;
	}
	
	private static int[] solution(int N, int[] numbers) {
		for (int i = 0; i < N - 1; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (numbers[min] > numbers[j]) 
					min = j;
			}
			swap(numbers, min, i);
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