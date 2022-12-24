import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int year = stdIn.nextInt();
        int sub = 2541 - 1998;
        
        System.out.println(year - sub);
    }
}