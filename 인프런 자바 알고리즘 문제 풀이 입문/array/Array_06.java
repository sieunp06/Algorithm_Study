import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  private static boolean isPrime(int num) {
		if (num == 1) return false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private static ArrayList<Integer> solution(int N, int[] numbers) {
		ArrayList<Integer> num = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String text = "";
			char[] num_char = Integer.toString(numbers[i]).toCharArray();
			for (int j = num_char.length - 1; j >= 0; j--) {
				text += num_char[j];
			}
			if (isPrime(Integer.parseInt(text)))
				num.add(Integer.parseInt(text));
		}
		
		return num;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        
        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++) {
        	numbers[i] = stdIn.nextInt();
        }
   
        for (int x : solution(N, numbers)) {
        	System.out.print(x + " ");
        }
    }
}