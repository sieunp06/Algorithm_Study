class Solution {
    public String solution(int age) {
        String answer = "";
        
        for (char alpha : String.valueOf(age).toCharArray()) {
            answer += (char)((int)alpha + 49);
        }
        
        return answer;
    }
}