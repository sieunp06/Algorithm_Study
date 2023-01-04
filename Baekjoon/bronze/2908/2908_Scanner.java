import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int num1 = stdIn.nextInt();
        int num2 = stdIn.nextInt();
        
        char[] num1_char = Integer.toString(num1).toCharArray();
        char[] num2_char = Integer.toString(num2).toCharArray();
        
        String num1_string = "";
        String num2_string = "";
        
        for (int i = num1_char.length - 1; i >= 0; i--) {
            num1_string += num1_char[i];
            num2_string += num2_char[i];
        }
        
        num1 = Integer.parseInt(num1_string);
        num2 = Integer.parseInt(num2_string);
        
        if (num1 > num2)
            System.out.println(num1);
        else 
            System.out.println(num2);
    }
}