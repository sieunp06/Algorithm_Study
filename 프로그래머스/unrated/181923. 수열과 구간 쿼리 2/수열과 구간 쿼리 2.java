class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int min = 2147000000;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (queries[i][2] < arr[j]) {
                    min = Math.min(min, arr[j]);
                }
            }
            answer[i] = min;
            if (min == 2147000000) {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}