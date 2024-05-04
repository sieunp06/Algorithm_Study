class Solution {
    public String solution(String s) {
        String answer = "";
        
        boolean flag = true;
        for (char alpha: s.toLowerCase().toCharArray()) {
            if (alpha == ' ') {
                flag = true;
                answer += alpha;
                continue;
            }
            if (flag) {
                String empty = "" + alpha;
                answer += empty.toUpperCase();
                flag = false;
            } else {
                answer += alpha;
            }
        }
        
        return answer;
    }
}