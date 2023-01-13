import java.util.*;
  
public class Main {
  static int solution(int N, int[] nums) {	
		ArrayList<Integer> line = new ArrayList<>();
		int answer;
		int max = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				max = nums[0];
				line.add(nums[0]);
			} else if (max < nums[i]) {
				max = nums[i];
				line.add(nums[i]);
			}
		}
		
		answer = line.size();
		
		return answer;
	}
	
	public static void main(String[] args){
	    Scanner StdIn = new Scanner(System.in);
	    
	    int N = StdIn.nextInt();
	    int[] nums = new int[N];
	    for (int i = 0; i < N; i++) {
	    	nums[i] = StdIn.nextInt();
	    }
	    
	    System.out.print(solution(N, nums));
	}
}