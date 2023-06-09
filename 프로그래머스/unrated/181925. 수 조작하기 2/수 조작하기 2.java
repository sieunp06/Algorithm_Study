class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int initial = numLog[0];
        
        for (int i = 1; i < numLog.length; i++) {
            int change = numLog[i] - initial;
            
            if (change == 1) 
                answer += "w";
            else if (change == -1)
                answer += "s";
            else if (change == 10)
                answer += "d";
            else answer += "a";
            
            initial = numLog[i];
        }
        
        return answer;
    }
}