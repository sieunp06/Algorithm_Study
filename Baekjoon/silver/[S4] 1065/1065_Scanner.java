import java.util.Scanner;

public class Main {
	private static boolean d(int number) {
        if (0 < number && number < 100) 
            return true;
        else {
            String num_toString = Integer.toString(number);
            char[] num_toCharArray = num_toString.toCharArray();
            
            int sub = num_toCharArray[1] - num_toCharArray[0];
            
            for (int i = 1; i < num_toCharArray.length; i++) {
            	if (num_toCharArray[i - 1] + sub != num_toCharArray[i]) {
                	return false;
            	}
            }
            if (sub == 0) {
            	for (int i = 1; i < num_toCharArray.length; i++) {
            		if (num_toCharArray[i - 1] == num_toCharArray[i])
            			return true;
            	}
            }
        }    
        return true;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int count = 0;
        int N = stdIn.nextInt();
        
        for (int i = 1; i <= N; i++) {
            if (d(i))
                count++;
        }
        
        System.out.println(count);
    }
}
