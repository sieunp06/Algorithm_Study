import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        
        for (char alpha : a.toCharArray()) {
            String text = "";
            if (alpha <= 90 && alpha >= 65) {
                text += (char)(alpha + 32);
            } else {
                text += (char)(alpha - 32);
            }
            answer += text;
        }
        
        System.out.println(answer);
    }
}