import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= num; i++) {
        	String number = String.valueOf(i);
            int len = number.length() - number.replaceAll("[3|6|9]", "").length();
            
            if (len == 0) {
            	sb.append(i).append(" ");
                continue;
            }
            for (int j = 0; j < len; j++) {
            	sb.append("-");
            }
            sb.append(" ");
        }
        
        System.out.println(sb);
	}
}