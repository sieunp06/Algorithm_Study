import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        
        ArrayList<String> answer = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
        	String input = bf.readLine(); 
        
        	if (!answer.contains(input))
        		answer.add(input);
        }
        
        Collections.sort(answer, new Comparator<String>() {		
        	@Override
        	public int compare(String s1, String s2) {
        		// 단어 길이가 같을 경우
        		if(s1.length() == s2.length()) {
        			return s1.compareTo(s2);	// 사전 순 정렬
        		}
        		// 그 외의 경우
        		else {
        			return s1.length() - s2.length();
        		}
        	}
        });
        
        for (String x : answer)
        	System.out.println(x);
	}
}
