class Solution {
    public int[] solution(int[] arr) {
        
        int i = 0;
        while (true) {
            if (arr.length <= Math.pow(2, i)) {
                break;
            }
            i++;
        }
        
        int[] answer = new int[(int)Math.pow(2, i)];
        
        for (int j = 0; j < answer.length; j++) {
            if (j < arr.length) {
                answer[j] = arr[j];        
            } else {
                answer[j] = 0;
            }
        }
        
        return answer;
    }
}