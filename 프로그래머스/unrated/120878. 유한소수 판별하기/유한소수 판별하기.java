import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= a; i++) {
            if (a % i == 0) {
                while(a % i == 0) {
                    a /= i;
                }     
                list.add(i);
            }
        }
        
        for (int num : list) {
            if (b % num == 0) {
                b /= num;
            }
        }
        
        List<Integer> list2 = new ArrayList<>();
        for (int i = 2; i <= b; i++) {
            if (b % i == 0) {
                while(b % i == 0) {
                    b /= i;
                }     
                list2.add(i);
            }
        }
        
        if (list2.size() == 1 && (list2.contains(2) || list2.contains(5))) {
            return 1;
        } 
        if (list2.size() == 2 && list2.contains(2) && list2.contains(5)) {
            return 1;
        }
        return 2;
    }
}