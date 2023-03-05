import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int num = stdIn.nextInt();
        
        int min = 1;
        int max = 1;
        int val = 1;
       
        for(int i = 1; max <= 2000000000; i++) {
    	    if(min <= num && num <= max) {
			    System.out.println(val);
			    break;
			}
    	    min = max + 1; 
    	    max = max + i * 6;
    	    val++;
         }
    }
}