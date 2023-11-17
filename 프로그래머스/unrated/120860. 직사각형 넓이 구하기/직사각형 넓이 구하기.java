class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        int[] lengths = new int[2];
        
        for (int i = 1; i < dots.length; i++) {
            int x = Math.abs(dots[i][0] - dots[i - 1][0]);
            int y = Math.abs(dots[i][1] - dots[i - 1][1]);
            
            if (x > lengths[0]) {
                lengths[0] = x;
            }
            if (y > lengths[1]) {
                lengths[1] = y;
            }
        }
        
        return lengths[0] * lengths[1];
    }
}