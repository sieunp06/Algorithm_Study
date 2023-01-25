import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
  
public class Main {
  private static int count(int[] numbers, int dist) {
		int cnt = 1;
		int ep = numbers[0];
		
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] - ep >= dist) {
				cnt++;
				ep = numbers[i];
			}
		}
		return cnt;
	}
	private static int solution(int N, int C, int[] numbers) {
		int answer = 0;
		Arrays.sort(numbers);
		
		int lt = 1;
		int rt = numbers[N - 1];
		
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (count(numbers, mid) >= C) {
				answer = mid;
				lt = mid + 1;
			} else 
				rt = mid - 1;
		}
		return answer;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int C = Integer.parseInt(st1.nextToken());
		
		int[] numbers = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++) 
			numbers[i] = Integer.parseInt(st2.nextToken());
		
		System.out.println(solution(N, C, numbers));
	}
}