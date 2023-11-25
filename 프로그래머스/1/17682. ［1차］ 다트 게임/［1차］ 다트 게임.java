import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        
        while (idx < dartResult.length() - 1) {
            list.add(dartResult.charAt(idx) - '0');
            idx++;
            if (dartResult.charAt(idx) >= 48 && dartResult.charAt(idx) <= 57) {
                String numst = String.valueOf(list.get(list.size() - 1)) + String.valueOf(dartResult.charAt(idx));
                list.set(list.size() - 1, Integer.parseInt(numst));
                idx++;
            }

            if (dartResult.charAt(idx) == 'D') {
                list.set(list.size() - 1, (int) Math.pow(list.get(list.size() - 1), 2));
            } else if (dartResult.charAt(idx) == 'T') {
                list.set(list.size() - 1, (int) Math.pow(list.get(list.size() - 1), 3));
            } 
            idx++;
            if (idx < dartResult.length()) {
                if (dartResult.charAt(idx) == '*') {
                    if (list.size() > 1) {
                        for (int i = list.size() - 2; i < list.size(); i++) {
                            list.set(i, list.get(i) * 2);
                        }   
                    } else {
                        list.set(0, list.get(0) * 2);
                    }
                    idx++;
                } else if (dartResult.charAt(idx) == '#') {
                    list.set(list.size() - 1, list.get(list.size() - 1) * -1);
                    idx++;
                }
            }
        }
        
        for (int num : list) {
            answer += num;
        }
        
        return answer;
    }
}