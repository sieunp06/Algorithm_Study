class Solution {
    public int solution(int[][] sizes) {
        int max_x = 0; int max_y = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        for (int[] size : sizes) {
            if (max_x < size[0]) {
                max_x = size[0];
            }
            if (max_y < size[1]) {
                max_y = size[1];
            }
        }
        
        return max_x * max_y;
    }
}