import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
        int[] prices = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
            int target = sc.nextInt();
            
            for (int price: prices) {
            	sb.append(target / price).append(" ");
                target %= price;
            }
            sb.append("\n");
		}
        
        System.out.println(sb);
	}
}