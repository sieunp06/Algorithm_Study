import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int N = stdIn.nextInt();
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            String input = stdIn.next();
            
            boolean[] checkAlpha = new boolean[26];
            boolean isGroupWord = true;
            
            checkAlpha[input.charAt(0) - 'a'] = true;
            for (int j = 1; j < input.length(); j++) {
                char alpha = input.charAt(j);
                
                if (input.charAt(j) != input.charAt(j - 1)) {
                    if (checkAlpha[input.charAt(j) - 'a']) {
                        isGroupWord = false;
                        break;
                    } else {
                        checkAlpha[input.charAt(j) - 'a'] = true;
                    }
                }
            }
            
            if (isGroupWord)
            	count++;
        }
        
        System.out.println(count);
    }
}