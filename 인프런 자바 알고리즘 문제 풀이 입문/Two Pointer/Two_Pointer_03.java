import java.util.Scanner;
  
public class Main {
  private static int solution(int N, int k, int[] price) {
		int total = 0;
		int p1 = 0;
		int p2 = p1 + k - 1;
		
		for (int i = p1; i <= p2; i++) {
			total += price[i];
		}
		
		p1++; p2++;
		
		int max = total;
		
		while (p2 < N) {
			total -= price[p1 - 1];
			total += price[p2];
			
			p1++; p2++;
			
			if (max < total) 
				max = total;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int k = stdIn.nextInt();
        
        int[] price = new int[N];
        
        for (int i = 0; i < N; i++) {
        	price[i] = stdIn.nextInt();
        }
        
        System.out.println(solution(N, k, price));
    }
}