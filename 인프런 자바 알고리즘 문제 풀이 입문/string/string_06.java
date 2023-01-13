import java.util.*;
  
public class Main {
  static String Solution(String word) {
		String answer = "";
		ArrayList<Character> char_answer = new ArrayList<>();
		char[] word_char = word.toCharArray();
		
		for (char x : word_char) {
			if (!char_answer.contains(x)) {
				char_answer.add(x);
			}
		}
		
		for (char x : char_answer) {
			answer += x;
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		String word = stdIn.next();

		System.out.println(Solution(word));
		
	}
}