import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        BigInteger n = stdIn.nextBigInteger();
        BigInteger m = stdIn.nextBigInteger();
        
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}