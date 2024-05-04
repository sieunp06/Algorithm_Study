class Solution {
    final String GOAL = "1";
    public int[] solution(String s) {
        int round = 0;
        int removeCount = 0;
        
        while (!s.equals(GOAL)) {
            int len = s.replaceAll("0", "").length();
            
            round++;
            removeCount += s.length() - len;
            
            s = Integer.toString(len, 2);
        }
        
        int[] answer = {round, removeCount};
        return answer;
    }
}