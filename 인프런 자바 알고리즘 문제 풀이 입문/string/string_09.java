import java.util.*;
  
public class Main {
  static String solution(String text) {
		String answer = "";
		
		int count = 1;
		
		for (int i = 0; i < text.length(); i++) {
			if (i == 0) {
				answer += text.charAt(0);
			} else if (text.charAt(i) == text.charAt(i - 1)) {
				count++;
			} else if (text.charAt(i) != text.charAt(i - 1)) {
				if (count > 1) {
					answer += String.valueOf(count);
					answer += text.charAt(i);
				} else {
					answer += text.charAt(i);
				}
				count = 1;
			}
		}
		
		
		return answer;
	}
	
	public static void main(String[] args){
	    Scanner StdIn = new Scanner(System.in);
	    
	    String text = StdIn.next();	
	    
    	System.out.println(solution(text));
	}
}