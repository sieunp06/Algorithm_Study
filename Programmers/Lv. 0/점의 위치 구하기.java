class Solution {
    private final int one = 1;
    private final int two = 2;
    private final int three = 3;
    private final int four = 4;
    
    public int solution(int[] dot) {
        int answer = 0;
        int x = dot[0];
        int y = dot[1];
        
        answer = determinationQuadrant(x, y);
        return answer;
    }
    
    private int determinationQuadrant(int x, int y) {
        if (x > 0 && y > 0)
            return one;
        if (x < 0 && y > 0)
            return two;
        if (x < 0 && y < 0) 
            return three;
        return four;
    }
}