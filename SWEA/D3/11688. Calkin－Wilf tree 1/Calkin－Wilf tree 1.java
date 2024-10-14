import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String text = sc.next();
            int a = 1; int b = 1;
            
            for (char way : text.toCharArray()) {
            	if (way == 'L') {
                	b = a+ b;
                } else {
                	a = a + b;
                }
            }
            System.out.println("#" + test_case + " " + a + " " + b);
		}
	}
}