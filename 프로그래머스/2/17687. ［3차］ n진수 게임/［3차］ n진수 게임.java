import java.util.List;
import java.util.ArrayList;

class Solution {
    // n: 진법, t: 말해야 하는 숫자, m: 인원, p: 순서
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        List<Character> list = new ArrayList<>();
        
        int i = 0;
        while (list.size() < t * m) {
            String text = Integer.toString(i, n);
            i++;
            for (char alpha : text.toCharArray()) {
                list.add(alpha);
            }
        }
        
        int start = p - 1;
        while (answer.length() < t) {
            answer += list.get(start);
            start += m;
        }
        
        return answer.toUpperCase();
    }
}