import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        String input = stdIn.nextLine();
        int count = 0;
        
        String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        for (int i = 0; i < alphabet.length; i++) {
    		while (input.contains(alphabet[i])) {
    			count++;
    			input = input.replaceFirst(alphabet[i], " ");
    		}
        }
        
        for (int i = 0; i < input.length(); i++) {
        	char alpha = input.charAt(i);
        	if (alpha != ' ')
        		count++;
        }
        
        System.out.println(count);
    }
}