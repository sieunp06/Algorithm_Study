import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
  
public class Main {
  private static int solution (String input1, String input2) {
		int answer = 0;
		int lt = 0;
		
		HashMap<Character, Integer> input2_map = new HashMap<>();
		for (int i = 0; i < input2.length(); i++) {
			input2_map.put(input2.charAt(i), input2_map.getOrDefault(input2.charAt(i), 0) + 1);
		}
		
		HashMap<Character, Integer> input1_map = new HashMap<>();
		for (int i = 0; i < input2.length() - 1; i++) {
			input1_map.put(input1.charAt(i), input1_map.getOrDefault(input1.charAt(i), 0) + 1);
		}
		
		for (int rt = lt + input2.length() - 1; rt < input1.length(); rt++) {
			input1_map.put(input1.charAt(rt), input1_map.getOrDefault(input1.charAt(rt), 0) + 1);

			if (input1_map.equals(input2_map))
				answer++;
			input1_map.put(input1.charAt(lt), input1_map.getOrDefault(input1.charAt(lt), 0) - 1);
			if (input1_map.get(input1.charAt(lt)) == 0)
				input1_map.remove(input1.charAt(lt));
			lt++;
		}
		
		return answer;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String input1 = bf.readLine();
        String input2 = bf.readLine();
        
        System.out.println(solution(input1, input2));
    }
}