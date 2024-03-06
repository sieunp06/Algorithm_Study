class Solution {
    public int solution(int[][] sizes) {
        int height = 0;
        int width = 0;
        
        for (int[] size: sizes) {
            int[] maxAndMin = calculateMaxAndMin(size[0], size[1]);
            
            int max = maxAndMin[0];
            int min = maxAndMin[1];
            
            if (max > height) {
                height = max;
            }
            if (min > width) {
                width = min;
            }
        }
        
        return height * width;
    }
    
    private int[] calculateMaxAndMin(int num1, int num2) {
        int[] result = {num1, num2};
        if (num1 < num2) {
            result[0] = num2;
            result[1] = num1;
        }
        return result;
    }
}