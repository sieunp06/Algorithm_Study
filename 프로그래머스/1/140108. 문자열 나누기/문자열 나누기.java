class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0);
        int numOfx = 1;
        int numOfNotx = 0;
        for (int i = 1; i < s.length(); i++) {
            if (numOfx == numOfNotx) {
                answer++;
                x = s.charAt(i);
                numOfx = 1;
                numOfNotx = 0;
                continue;
            }
            if (x == s.charAt(i)) {
                numOfx++;
                continue;
            }
            if (x != s.charAt(i)) {
                numOfNotx++;
            }
        }
        return answer + 1;
    }
}