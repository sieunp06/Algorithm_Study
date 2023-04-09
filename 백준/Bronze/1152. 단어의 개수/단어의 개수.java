import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        String input = stdIn.nextLine().trim();
        
        if (input.isEmpty())
        	System.out.println('0');
        else
        	System.out.println(input.split(" ").length );
    }
}