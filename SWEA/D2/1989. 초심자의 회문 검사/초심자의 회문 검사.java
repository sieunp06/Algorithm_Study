import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            String text = sc.next();
            
            String left = text.substring(0, text.length() / 2 + 1);
            String right = text.substring(text.length()  - text.length() / 2 - 1, text.length());
            StringBuffer rightReverse = new StringBuffer(right);
            
            System.out.print("#" + test_case + " "); 
            if (left.equals(rightReverse.reverse().toString())) {
 				System.out.println(1);
            } else {
                System.out.println(0);
            }
		}
	}
}