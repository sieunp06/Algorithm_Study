import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Set;
import java.util.HashSet;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
		for (int test_case = 1; test_case <= T; test_case++) {
			String N = sc.next();
			Set<Character> set = new HashSet<>();
            
            for (char num : N.toCharArray()) {
            	set.add(num);
            }
            System.out.println("#" + test_case + " " + set.size());
		}
	}
}