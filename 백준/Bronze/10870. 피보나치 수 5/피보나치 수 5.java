import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }
    
    private static int fibo(int num) {
        if (num <= 1) return num;
        return fibo(num - 2) + fibo(num - 1);
    }
}