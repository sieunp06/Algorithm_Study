import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
  
public class Main {
  private static int solution(int N, int M, int[] numbers) {
		Arrays.sort(numbers);
		
		int low = 0;
		int high = N - 1;
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			if (M == numbers[mid])
				return mid + 1;
			else if (M < numbers[mid])
				high = mid - 1;
			else 
				low = mid + 1;
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		int[] numbers = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st2.nextToken());
		
		System.out.println(solution(N, M, numbers));
	}
}