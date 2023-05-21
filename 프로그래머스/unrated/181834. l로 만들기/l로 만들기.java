class Solution {
    public String solution(String myString) {
        String answer = "";
        
        int standard = (char)('l');
        
        for (int num : myString.toCharArray()) {
            if (num < standard) 
                answer += 'l';
            else answer += (char)num;
        }
        
        return answer;
    }
}