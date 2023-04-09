import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        String input = stdIn.next();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        
        for (int i = 0; i < input.length(); i++) {
            char alpha = input.charAt(i);
            if (alphabet[alpha - 97] == -1) {
            	alphabet[alpha - 97] = i;
            }
        }
        
        for (int i = 0; i < alphabet.length; i++) {
        	if (i == alphabet.length - 1)
        		System.out.print(alphabet[i]);
        	else 
        		System.out.print(alphabet[i] + " ");
        }
    }
}