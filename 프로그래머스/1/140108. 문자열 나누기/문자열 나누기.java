import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        
        char alpha = s.charAt(0);
        int same = 1; int diff = 0;
        
        while (idx < s.length()) {
            if (s.charAt(idx) == alpha) {
                same++;
            } else {
                diff++;
            }
            
            if (same == diff) {
                list.add(idx);
                idx++;
                if (idx < s.length()) {
                    alpha = s.charAt(idx);
                    same = 1; diff = 0;   
                } else {
                    break;
                }
            }
            idx++;
        }
        if (list.isEmpty()) {
            return list.size() + 1;
        }
        if (list.get(list.size() - 1) != s.length() - 1) {
            return list.size() + 1;
        }
        return list.size();
    }
}