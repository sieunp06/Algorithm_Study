class Solution {
    public int[][] solution(int[][] arr) {
        
        int maxLength = arr.length;
        
        for (int[] nums : arr) {
            if (nums.length > maxLength) {
                maxLength = nums.length;
            }
        }
        
        int[][] answer = new int[maxLength][maxLength];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}