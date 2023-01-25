import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
  
public class Main {
  private static int count(int[] numbers, int capacity) {
		int cnt = 1;
		int sum = 0;
		
		for (int x : numbers) {
			if (sum + x > capacity) {
				cnt++;
				sum = x;
			} else {
				sum += x;
			}
		}
		return cnt;
	}
	private static int solution(int N, int M, int[] numbers) {
		int answer = 0;
		
		int lt = Arrays.stream(numbers).max().getAsInt();
		int rt = Arrays.stream(numbers).sum();
		
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			
			if (count(numbers, mid) <= M) {
				answer = mid;
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
		}
		
		return answer;
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