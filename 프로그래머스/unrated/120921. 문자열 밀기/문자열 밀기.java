import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        Deque<Character> dq = new LinkedList<>();
        for (char alpha : A.toCharArray()) {
            dq.add(alpha);
        }
        
        for (int i = 0; i < A.length(); i++) {
            String text = "";
            for (char alpha : dq) {
                text += alpha;
            }
            if (text.equals(B)) {
                return answer;
            }
            dq.addFirst(dq.pollLast());
            answer++;
        }
        
        return -1;
    }
}