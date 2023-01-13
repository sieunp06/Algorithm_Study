import java.util.*;
  
public class Main {
  static ArrayList<Integer> solution(int N, int[] nums) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) 
				answer.add(nums[i]);
			else if (nums[i] > nums[i - 1]) {
				answer.add(nums[i]);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
	    Scanner StdIn = new Scanner(System.in);
	    
	    int N = StdIn.nextInt();
	    int[] nums = new int[N];
	    for (int i = 0; i < N; i++) {
	    	nums[i] = StdIn.nextInt();
	    }

	    for (int x: solution(N, nums)) {
	    	System.out.print(x + " ");
	    }
	}
}