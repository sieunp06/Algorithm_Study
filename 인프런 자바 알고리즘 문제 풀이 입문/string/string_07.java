import java.util.*;
  
public class Main {
  static String Solution(String word) {
		String answer = "YES";
		
		word = word.toLowerCase();	// 모두 소문자로
		char[] char_word = word.toCharArray();
		
		int lt = 0, rt = word.length() - 1;
		
		while(lt < rt) {
			if (char_word[lt] == char_word[rt]) {
				lt ++;
				rt --;
			} else {
				answer = "NO";
				break;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		String word = stdIn.next();

		System.out.println(Solution(word));
		
	}
}