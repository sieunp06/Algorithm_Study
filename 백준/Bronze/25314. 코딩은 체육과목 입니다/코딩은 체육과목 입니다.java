import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		long N = input.nextLong();
		if (N % 4 == 0) {
			for(int i = 1; i<= N/4; i++) {
				System.out.print("long ");
			}
		}
		System.out.println("int");
	}

}
