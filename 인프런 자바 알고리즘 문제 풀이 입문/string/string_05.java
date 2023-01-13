import java.util.*;
  
public class Main {
  static String Solution(String word) {
		
		char[] words_char = word.toCharArray();
		int lt = 0, rt = words_char.length - 1;
		
		while (lt < rt) {
			if (!Character.isAlphabetic(words_char[lt])) {
				lt ++;
			} 
			else if (!Character.isAlphabetic(words_char[rt])){
				rt --;
			} 
			else { 
				char tmp = words_char[lt];
				words_char[lt] = words_char[rt];
				words_char[rt] = tmp;
				
				lt ++;
				rt --;
			}
		}
		
		String tmp = String.valueOf(words_char);
		
		return tmp;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		String word = stdIn.next();

		System.out.println(Solution(word));
		
	}
}