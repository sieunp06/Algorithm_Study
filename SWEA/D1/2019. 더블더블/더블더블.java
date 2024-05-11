import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int preNum = 1;
        System.out.print(preNum + " ");
        for (int i = 0; i < num; i++) {
            preNum *= 2;
        	System.out.print(preNum + " ");
        }
	}
}