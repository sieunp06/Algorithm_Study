class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (char alpha : s.toCharArray()) {
            if (alpha != ' ') {
                int change = alpha + n;
                if (alpha >= 65 && alpha <= 90) {   // 대문자
                    if (change > 90) change -= 26;
                } else {                            // 소문자
                    if (change > 122) change -= 26;
                }
                answer += (char)change;
            } else {
                answer += alpha;
            }
        }
        
        return answer;
    }
}