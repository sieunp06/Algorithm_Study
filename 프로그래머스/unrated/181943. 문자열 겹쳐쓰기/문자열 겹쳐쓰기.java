class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        for (int i = 0; i < s; i++) {
            answer += my_string.charAt(i);
        }
        
        answer += overwrite_string;
        
        for (int i = s + overwrite_string.length(); i < my_string.length(); i++) {
            answer += my_string.charAt(i);
        }
        
        return answer;
    }
}