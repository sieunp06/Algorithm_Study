import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> wordList = new HashSet<>();
         
        char lastAlphabet = words[0].charAt(words[0].length() - 1);
        for (int i = 0; i < words.length; i++) {
            if (wordList.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            wordList.add(words[i]);
            if (i == 0) {
                lastAlphabet = words[i].charAt(words[i].length() - 1);
                continue;
            }
            if (words[i].charAt(0) != lastAlphabet) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            lastAlphabet = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }
}