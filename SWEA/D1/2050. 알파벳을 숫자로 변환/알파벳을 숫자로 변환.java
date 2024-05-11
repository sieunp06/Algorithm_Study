import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
		String T=sc.next();
        for (char alpha : T.toCharArray()) {
        	if ('a' <= alpha && alpha <= 'z') {
            	answer.append(alpha - 'a' + 1);
            }
            if ('A' <= alpha && alpha <= 'Z') {
            	answer.append(alpha - 'A' + 1);
            }
            answer.append(" ");
        }
        System.out.println(answer);
	}
}