class Solution {
    public int[] solution(long n) {
        char[] textArray = String.valueOf(n).toCharArray();
        int[] answer = new int[textArray.length];
        
        int ind = textArray.length - 1;
        
        for (char alpha : textArray) {
            answer[ind] = alpha - '0';
            ind--;
        }
            
        return answer;
    }
}