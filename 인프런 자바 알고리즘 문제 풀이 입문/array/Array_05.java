import java.util.Scanner;

public class Main {
	private static int solution(int num) {
		boolean[] number = new boolean[num + 1];
		int count = 0;

		for (int i = 2; i < number.length; i++) {
			if (number[i] == false) {
				count++;
				for (int j = i; j < number.length; j = j + i) {
					number[j] = true;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int num = stdIn.nextInt();
        
        System.out.println(solution(num));
    }
}