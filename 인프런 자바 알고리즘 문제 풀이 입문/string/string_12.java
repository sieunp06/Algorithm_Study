import java.util.Scanner;
  
public class Main {
  static String solution(int N, String text) {
		String answer = "";
		
		String[] substring_text = new String[N];
		
		for (int i = 0; i < N; i++){
			substring_text[i] = text.substring(i * 7, i * 7 + 7);
		}
		
		for (String x : substring_text) {
			// test - substring text -> success
			
			char[] substring_char = x.toCharArray();
			
			for (int j = 0; j < substring_char.length; j++) {
				// 2진수로 바꾸기
				if (substring_char[j] == '#') 
					substring_char[j] = '1';
				else if (substring_char[j] == '*') 
					substring_char[j] = '0';
			}
			
			// substring_char를 문자로 바꾸기 -> 변수를 하나 선언해야되나 말아야되나
			x = String.valueOf(substring_char);
			
			// 2진수를 10진수로 바꾸기
			int ASCII = Integer.valueOf(x, 2);
			answer += (char)ASCII;
		}
		
		return answer;
	}
	
	public static void main(String[] args){
	    Scanner StdIn = new Scanner(System.in);
	    
	    int N = StdIn.nextInt();
	    String text = StdIn.next();	
	    
    	System.out.println(solution(N, text));
	}
}