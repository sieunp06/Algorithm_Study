class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        String split = "";
        for (int i = 1; i <= my_string.length(); i++) {
            if (i % m == 0) {
                split += my_string.charAt(i - 1);
                answer += split.charAt(c - 1);
                split = "";
            } else {
                split += my_string.charAt(i - 1);
            }
        }
        
        return answer;
    }
}