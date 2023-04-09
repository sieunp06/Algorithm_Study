import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 0);
        
        String input = stdIn.nextLine().toLowerCase();
        
        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 97;
            alphabet[index] += 1;
        }
        
        int max = alphabet[0];
        int max_ind = 0;
        boolean check = false;
        
        for (int i = 1; i < alphabet.length; i++) {
            if (alphabet[i] > max ) {
                max = alphabet[i];
                max_ind = i;
                check = false;
            } else if (alphabet[i] == max) {
            	check = true;
            }
        }
        
        if (check)
            System.out.println("?");
        else 
            System.out.println((char)(65 + max_ind));
    }
}