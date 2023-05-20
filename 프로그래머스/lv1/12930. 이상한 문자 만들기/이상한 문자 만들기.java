class Solution {
    public String solution(String s) {
        String answer = "";
        
        int ind = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String alpha = "";
            alpha += s.charAt(i);
            if (alpha.equals(" ")) {
                answer += alpha;
                ind = 0;
            } else {
                if (ind % 2 == 0) answer += alpha.toUpperCase();
                else answer += alpha.toLowerCase();
                ind++;
            }
        }
        
        return answer;
    }
}