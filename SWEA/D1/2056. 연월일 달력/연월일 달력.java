import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            System.out.print("#" + test_case + " ");
            String date = sc.next();
            if (!validateLength(date)) {
            	System.out.println(-1);
                continue;
            }
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6, 8);
            
            if (!validateDate(month, day)) {
            	System.out.println(-1);
                continue;
            }
            System.out.println(year + "/" + month + "/" + day);
		}
	}
    
    private static boolean validateLength(String date) {
    	if (date.length() != 8) {
        	return false;
        }
        return true;
    }
    
    private static boolean validateDate(String month, String day) {
    	if (!validateMonth(Integer.parseInt(month))) {
        	return false;
        }
        if (!validateDay(Integer.parseInt(month), Integer.parseInt(day))) {
        	return false;
        }
        return true;
    }
    
    private static boolean validateMonth(int month) {
    	if (month < 1 || month > 12) {
        	return false;
        }
        return true;
    }
            
    private static boolean validateDay(int month, int day) {
        if (day < 1) {
        	return false;
        }
    	if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
        	if (day > 31) {
            	return false;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
        	if (day > 30) {
            	return false;
            }
        }
        if (month == 2) {
        	if (day > 28) {
            	return false;
            }
        }
        return true;
    }
}