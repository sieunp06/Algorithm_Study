import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        Long num1 = stdIn.nextLong();
        Long num2 = stdIn.nextLong();
        Long num3 = stdIn.nextLong();

        System.out.println(num1 + num2 + num3);
    }
}