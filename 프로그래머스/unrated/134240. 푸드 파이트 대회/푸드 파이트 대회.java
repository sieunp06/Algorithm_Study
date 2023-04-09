class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for (int i = 1; i < food.length; i++) {
            int mul = food[i] / 2;
            for (int j = 0; j < mul; j++)
                answer += i;
        }
        answer += 0;
        for (int i = answer.length() - 2; i >= 0; i--) 
            answer += answer.charAt(i);
        return answer;
    }
}