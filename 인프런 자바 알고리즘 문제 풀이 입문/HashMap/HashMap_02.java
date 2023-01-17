import java.util.Scanner;
import java.util.HashMap;
  
public class Main {
  private static String solution(String text1, String text2) {
		String answer = "YES";
		
		HashMap<Character, Integer> one = new HashMap<>();
		
		for (char x : text1.toCharArray()) 
			one.put(x, one.getOrDefault(x, 0) + 1);
		for (char x : text2.toCharArray()) {
			if (!one.containsKey(x) || one.get(x) == 0)
				return "NO";
			one.put(x, one.get(x) - 1);
		}
			
				
		return answer;
	}
	
	public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        String text1 = stdIn.next();
        String text2 = stdIn.next();
        
        System.out.println(solution(text1, text2));
    }
}