class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = 0;
        for (char alpha: s.toCharArray()) {
            if (alpha == ' ') {
                answer += ' ';
                idx = 0;
                continue;
            }
            if (idx % 2 == 0) {
                answer += Character.toUpperCase(alpha);
            } else {
                answer += Character.toLowerCase(alpha);
            }
            idx++;
        }
        
        return answer;
    }
}