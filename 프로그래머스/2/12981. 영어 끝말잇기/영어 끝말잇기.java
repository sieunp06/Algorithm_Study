import java.util.Set;
import java.util.HashSet;


class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] saying = new int[n + 1];
        
        Set<String> set = new HashSet<>();
        
        String word_st = words[0];
        set.add(words[0]);
        saying[1]++;
        int idx = 2;
        
        for (int i = 1; i < words.length; i++) {            
            int len = set.size();
            set.add(words[i]);
            saying[idx]++;

            if (word_st.charAt(word_st.length() - 1) != words[i].charAt(0)) {
                answer[0] = idx;
                answer[1] = saying[idx];
                break;
            }

            if (len == set.size()) {
                answer[0] = idx;
                answer[1] = saying[idx];
                break;
            }
            
            idx++;
            word_st = words[i];
            if (idx > n) {
                idx = 1;
            }
        }

        return answer;
    }
}