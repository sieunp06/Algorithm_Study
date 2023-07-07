import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        StringTokenizer st;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (String operation : operations) {
            st = new StringTokenizer(operation);
    
            String command = st.nextToken();        
            if (command.equals("I")) {   // 삽입
                int num = Integer.parseInt(st.nextToken());
                arr.add(num);
                Collections.sort(arr);
            } else {    // 삭제
                String minOrMax = st.nextToken();
                if (!arr.isEmpty()) {
                    if (minOrMax.equals("1")) {  // 최댓값 삭제
                        arr.remove(arr.size() - 1);
                    } else {    // 최솟값 삭제
                        arr.remove(0);
                    }
                }
            }
        }
        
        if (!arr.isEmpty()) {
            if (arr.size() > 1) {
                Collections.sort(arr);
                answer[1] = arr.get(0);
                answer[0] = arr.get(arr.size() - 1);
            } else {
                if (arr.get(0) > 0) 
                    answer[0] = arr.get(0);
                else answer[1] = arr.get(0);
            }
        }
        
        return answer;
    }
}