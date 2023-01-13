import java.util.*;
  
public class Main {
  static String Solution(String word) {
		String answer = "YES";
		
		char[] char_word = word.toLowerCase().toCharArray();
		ArrayList<Character> array_word = new ArrayList<>();
		
		// 특수문자 제거
		for (char x : char_word) {
			if (Character.isAlphabetic(x)) {
				array_word.add(x);
			} 
		}
		
		int len = word.length() / 2;
		
		for (int i = 0; i < len; i++ ) {
			if (array_word.get(i) != array_word.get(array_word.size() - i - 1)) {
				
				return answer = "NO";
			}
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		String word = stdIn.nextLine();

		System.out.println(Solution(word));
		
	}
}