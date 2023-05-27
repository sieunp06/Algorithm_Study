import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int num : arr) {
            boolean isCheck = true;
            for (int i = 0; i < delete_list.length; i++) {
                if (num == delete_list[i]) {
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) 
                answer.add(num);
        }
        
        return answer;
    }
}