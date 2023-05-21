import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        if (arr.length % 2 == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    answer.add(arr[i]);
                } else {
                    answer.add(arr[i] + n);
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    answer.add(arr[i] + n);
                } else {
                    answer.add(arr[i]);
                }
            }
        }
        
        
        return answer;
    }
}