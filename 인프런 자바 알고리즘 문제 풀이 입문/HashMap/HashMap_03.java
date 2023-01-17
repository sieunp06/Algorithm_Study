import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
  
public class Main {
  private static ArrayList<Integer> solution(int N, int K, int[] price) {
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < K - 1; i++) {			
			map.put(price[i], map.getOrDefault(price[i], 0) + 1);
		}
		
		int lt = 0;
		
		for (int rt = K - 1; rt < N; rt++) {
			map.put(price[rt], map.getOrDefault(price[rt], 0) + 1);
			answer.add(map.size());
			map.put(price[lt], map.get(price[lt]) - 1);
			
			if (map.get(price[lt]) == 0) 
				map.remove(price[lt]);
			lt++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int K = stdIn.nextInt();
        
        int[] price = new int[N];
        
        for (int i = 0; i < N; i++) {
        	price[i] = stdIn.nextInt();
        }
        
        for (int x :solution(N, K, price)) {
        	System.out.print(x + " ");
        }
    }
}