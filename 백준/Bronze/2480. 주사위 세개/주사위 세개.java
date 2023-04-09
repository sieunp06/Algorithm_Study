import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());

        if (num1 == num2 && num2 == num3 && num1 == num3)   // 3개의 숫자가 모두 같을 때
            System.out.println(10000 + num1 * 1000);
        else if (num1 != num2 && num2 != num3 && num1 != num3) {    // 3개의 숫자가 모두 다를 때
            int max;
			if (num1 > num2) {
				if (num3 > num1) 
					max = num3;
				else max = num1;
			}	
			else {
				if (num3 > num2) 
					max = num3;
				else max = num2;
            }
            System.out.println(max * 100);
        } else {    // 2개의 숫자는 같고, 1개의 숫자는 다를 때
            if (num1 == num2 || num1 == num3) 
                System.out.println(1000 + num1 * 100);
            else
                System.out.println(1000 + num2 * 100);

        }
    }
}