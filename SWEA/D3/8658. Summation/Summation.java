import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
			for (int i = 0; i < 10; i++) {
            	int num = sum(sc.nextInt());
                if (min > num) {
                	min = num;
                }
                if (max < num) {
                	max = num;
                }
            }
            sb.append("#").append(test_case).append(" ").append(max).append(" ").append(min).append("\n");
		}
        System.out.print(sb);
	}
    
    private static int sum(int num) {
    	String text = String.valueOf(num);
        int total = 0;
        for (char n : text.toCharArray()) {
        	total += n - '0';
        }
        return total;
    }
}