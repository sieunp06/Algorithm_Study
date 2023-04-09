import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        String input = stdIn.nextLine();
        char input_toChar = input.charAt(0);
        int answer = input_toChar;
        System.out.println(answer);
    }
}