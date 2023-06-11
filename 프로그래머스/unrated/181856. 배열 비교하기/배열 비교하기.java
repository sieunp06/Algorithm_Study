class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        if (arr1.length == arr2.length) {
            int total1 = 0;
            int total2 = 0;
            
            for (int i = 0; i < arr1.length; i++) {
                total1 += arr1[i];
                total2 += arr2[i];
            }
            
            if (total1 > total2) {
                answer = 1;
            } else if (total1 < total2) {
                answer = -1;
            } else {
                answer = 0;
            }
        } else {
            if (arr1.length > arr2.length)
                answer = 1;
            else answer = -1;
        }
        return answer;
    }
}