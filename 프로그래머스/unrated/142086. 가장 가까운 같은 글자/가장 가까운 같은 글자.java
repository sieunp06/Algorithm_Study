class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            if (i == s.indexOf(s.charAt(i))) 
                answer[i] = -1;
            else {
                String word = s.substring(0, i);
                answer[i] = i - word.lastIndexOf(s.charAt(i));
            }
        }
        
        return answer;
    }
}