import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int hour = stdIn.nextInt();
        int min = stdIn.nextInt();
        int duration = stdIn.nextInt();
        int time = 0;
        
        time = hour * 60 + min + duration;
        
        hour = time / 60;
        min = time % 60;
        
        if (hour >= 24) 
            hour -= 24;
        
        System.out.println(hour + " " + min);
    }
}