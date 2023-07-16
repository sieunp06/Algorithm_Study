class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        for (char alpha : before.toCharArray()) 
            after = after.replaceFirst(Character.toString(alpha), "");

        if (after.equals("")) 
            answer = 1;
        
        return answer;
    }
}