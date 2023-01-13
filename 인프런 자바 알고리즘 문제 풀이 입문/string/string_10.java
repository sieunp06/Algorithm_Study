import java.util.*;
  
public class Main {
  static int[] solution(String text, char Alpha) {
		int[] answer = new int[text.length()];
		
		int p = 1000;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == Alpha) {
				p = 0;
				answer[i] = p;
			} else {
				p++;
				answer[i] = p;
			}
		}
		
		p = 1000;
		for (int i = text.length() - 1; i >= 0; i--) {
			if (text.charAt(i) == Alpha) {
				p = 0;
			} else {
				p++;
				answer[i] = Math.min(answer[i], p);
			}
		}
		
		
		return answer;
	}
	
	public static void main(String[] args){
	    Scanner StdIn = new Scanner(System.in);
	    
	    String text = StdIn.next();	// 문자열
	    char Alpha = StdIn.next().charAt(0);
	    
	    for (int x: solution(text, Alpha)) {
	    	System.out.print(x + " ");
	    }
	}
}