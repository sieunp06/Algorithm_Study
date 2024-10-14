import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
            String text = sc.next();
            String answer = "";
            
            for (char alpha : text.toCharArray()) {
            	if (alpha == 'a' || alpha == 'e' || alpha == 'i' || alpha == 'o' || alpha == 'u') {
                	continue;
                }
                answer += alpha;
            }
            sb.append(answer).append("\n");
		}
        System.out.print(sb);
	}
}