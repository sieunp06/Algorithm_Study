import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        String input = stdIn.nextLine();
        int time = 0;
        
        for (int i = 0; i < input.length(); i++) {
            char alpha = input.charAt(i);
            int ind = alpha - 65;
            if (ind / 3 > 4) {
            	if ((int)alpha >= 80 && (int)alpha <= 83)
            		time += 8;
            	if ((int)alpha >= 84 && (int)alpha <= 86)
            		time += 9;
            	if ((int)alpha >= 87)
            		time += 10;
            } else {
            	time += ind / 3 + 3;
            }
        }
        
        System.out.println(time);
    }
}