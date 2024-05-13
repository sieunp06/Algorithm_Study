import java.util.Scanner;
import java.time.*;
import java.time.temporal.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int firstMonth = sc.nextInt();
            int firstDay = sc.nextInt();
            LocalDate first = LocalDate.of(2023, firstMonth, firstDay);
            
            int secondMonth = sc.nextInt();
            int secondDay = sc.nextInt();
            LocalDate second = LocalDate.of(2023, secondMonth, secondDay);
            
            System.out.print("#" + test_case + " ");
            System.out.println(first.until(second, ChronoUnit.DAYS) + 1);
		}
	}
}