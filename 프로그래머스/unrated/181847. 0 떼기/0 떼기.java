class Solution {
    public String solution(String n_str) {
        String answer = "";
        
        boolean isCheck = false;
        
        for (char alpha : n_str.toCharArray()) {
            if (isCheck) {
                answer += alpha;
            } else {
                if (alpha != '0') {
                    answer += alpha;
                    isCheck = true;
                }
            }
        }
        return answer;
    }
}