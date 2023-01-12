import java.util.Scanner;
  
public class Main {
  static String Solution(String word) {
		String[] words = word.split(" ");
		
		int maxIdx = 0;
		
		for (int i = 0; i < words.length; i++) {
			if (words[maxIdx].length() < words[i].length()) {
				maxIdx = i;
			}
		}
		
		return words[maxIdx];
	}
	public static void main(String[] args) {
		Scanner stdId = new Scanner(System.in);
		
		String word = stdId.nextLine();
		
		System.out.println(Solution(word));
	}
}