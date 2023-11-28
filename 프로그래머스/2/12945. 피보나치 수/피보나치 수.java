import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                list.add(1);
            } else if (i == 2) {
                list.add(1);
            } else {
                list.add((list.get(i - 3) + list.get(i - 2)) % 1234567);
            }
        }

        return list.get(list.size() - 1);
    }
}