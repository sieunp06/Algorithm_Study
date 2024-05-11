import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
        int total = 0;
		for (char alpha: String.valueOf(T).toCharArray()) {
        	total +=  (int)(alpha - '0');	
        }
        
        System.out.println(total);
	}
}