import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        
        int num1 = sc.nextInt();
        String num2 = sc.next();
        
        for (char numChar : num2.toCharArray()) {
            answer += numChar - '0';
        }
        
        System.out.println(answer);
    }
}