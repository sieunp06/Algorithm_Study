import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;

        int[] plays = new int[N];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            plays[i] = Integer.parseInt(st.nextToken());
            if (start < plays[i]) start = plays[i];     
            end = end + plays[i];       
        }

        while (start <= end) {  
            int middle = (start + end) / 2; 
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + plays[i] > middle) {     
                    count++;    
                    sum = 0;   
                }
                sum += plays[i];  
            }
            if (sum != 0)
                count++;
            if (count > M)
                start = middle + 1;
            else end = middle - 1;      
        }
        System.out.println(start); 
    }
}