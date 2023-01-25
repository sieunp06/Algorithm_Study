import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
  
public class Main {
  private static ArrayList<Integer> solution(int N, int[] height) {		
		ArrayList<Integer> answer = new ArrayList<>();
		int[] height_sort = new int[N];
		
		for (int i = 0; i < N; i++) 
			height_sort[i] = height[i];
					
		Arrays.sort(height_sort);
		
		for (int i = 0; i < N; i++) {
			if (height[i] != height_sort[i]) {
				answer.add(i + 1);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] height = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++)
			height[i] = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> answer = solution(N, height);
	
		for (int i = 0; i < answer.size(); i++)
			System.out.print(answer.get(i) + " ");
	}
}