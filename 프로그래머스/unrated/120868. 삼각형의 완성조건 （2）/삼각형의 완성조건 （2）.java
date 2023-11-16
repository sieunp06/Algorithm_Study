class Solution {
    public int solution(int[] sides) {
        int startIdx = calculateStartIdx(sides[0], sides[1]);
        int endIdx = sides[0] + sides[1];        
        return endIdx - startIdx - 1;
    }
    
    private int calculateStartIdx(int num1, int num2) {
        if (num1 < num2) {
            return num2 - num1;
        }
        return num1 - num2;
    }
}