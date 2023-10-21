class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        
        for (int i = 0; i < code.length(); i++) {
            char alpha = code.charAt(i);
            
            if (alpha == '1') {
                if (mode == 0) mode = 1;
                else mode = 0;
            } else {
                if (mode == 0) {
                    if (i % 2 == 0) {
                        answer += alpha;
                    }
                } else {
                    if (i % 2 != 0) {
                        answer += alpha;
                    }
                }
            }
        }
        
        if (answer.equals("")) return "EMPTY";
        
        return answer;
    }
}