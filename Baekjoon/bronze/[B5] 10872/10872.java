import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int recursive(int n) {
		if (n <= 1) return 1;
		else {
			return n * recursive(n - 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		System.out.println(recursive(N));
	}
}