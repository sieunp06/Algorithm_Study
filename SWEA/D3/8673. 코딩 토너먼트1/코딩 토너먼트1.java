import java.util.Scanner;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
            int K = (int) Math.pow(2, sc.nextInt());
			List<Integer> list = new ArrayList<>();
            for (int i = 0; i < K; i++) {
            	list.add(sc.nextInt());
            }
            
            int answer = 0;
            while (list.size() > 1) {
            	for (int i = 0; i < list.size(); i++) {
                    answer += Math.abs(list.get(i) - list.get(i + 1));
                	if (list.get(i) > list.get(i + 1)) {
                    	list.remove(i + 1);
                    } else {
                    	list.remove(i);
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
}