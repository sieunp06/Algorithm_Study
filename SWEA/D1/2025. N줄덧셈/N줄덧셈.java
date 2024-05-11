import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int answer = 0;
        
        for (int i = 1; i <= T; i++) {
        	answer += i;
        }
        
        System.out.println(answer);
	}
}