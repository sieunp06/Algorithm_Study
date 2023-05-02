class Solution {
    public String solution(int n) {
        String answer = "";
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                answer += "수";
                count++;
            }
            else {
                answer += "박";
                count = 0;
            }
        }
        return answer;
    }
}