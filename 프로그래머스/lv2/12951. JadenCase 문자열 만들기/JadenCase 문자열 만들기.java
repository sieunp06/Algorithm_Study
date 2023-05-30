class Solution {
    public String solution(String s) {
        String answer = "";
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count = 0;
                answer += s.charAt(i);
            } else {
                String empty = "";
                empty += s.charAt(i);
                if (count == 0 && !Character.isDigit(s.charAt(i))) {
                    answer += empty.toUpperCase();
                } else {
                    answer += empty.toLowerCase();
                }
                count ++;
            }
            
        }
        
        return answer;
    }
}