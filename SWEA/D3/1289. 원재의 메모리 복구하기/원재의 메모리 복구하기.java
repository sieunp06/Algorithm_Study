import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] text = sc.next().toCharArray();
            int[] target = new int[text.length];
            int[] init = new int[text.length];
            
            for (int i = 0; i < text.length; i++) {
            	target[i] = text[i] - '0';
            }
            
            int count = 0;
            for (int i = 0; i < target.length; i++) {
            	if (target[i] != init[i]) {
                    count++;
                	for (int j = i; j < target.length; j++) {
                    	init[j] = target[i];
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
        System.out.print(sb);
	}
}