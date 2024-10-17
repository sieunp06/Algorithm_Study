import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int A = sc.nextInt();
            int B = sc.nextInt();
            
            int count = 0;
            for (int i = A; i <= B; i++) {
            	double square = Math.sqrt(i);
                if (i != Math.pow(Math.round(square), 2)) {
                    continue;
                }
         		if (isPal(i) && isPal((int)square)) {
                	count++;
                }
            }
            sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
        System.out.print(sb);
	}
                    
    private static boolean isPal(int num) {
        String text = String.valueOf(num);
        int start = 0; int end = text.length() - 1;
        while (start < end) {
        	if (text.charAt(start) != text.charAt(end)) {
            	return false;
            }
            start++; end--;
        }
        return true;
    }
}