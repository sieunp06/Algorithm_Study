import java.util.Scanner;
  
public class Main {
  static String solution(String str) {
		String answer = "";
		
		for (char x : str.toCharArray()) {
			if (Character.isUpperCase(x)) {
				answer += Character.toLowerCase(x);
			} else {
				answer += Character.toUpperCase(x);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
	    Scanner in = new Scanner(System.in);
	    
	    String input1 = in.nextLine();	// 문자열
	    
	    System.out.println(solution(input1));
	}
}