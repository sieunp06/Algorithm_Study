class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        
        int l = 0;
        for (int i = 0; i < num_list.length - n + 1; i += n) {
            for (int j = 0; j < n; j++)
                answer[l][j] = num_list[l * n + j];
            l++;
        }
        
        return answer;
    }
}