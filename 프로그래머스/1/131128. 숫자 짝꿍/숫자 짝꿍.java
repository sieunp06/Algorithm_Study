import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuilder;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        String text_y = Y;
        String text_x = X;
        
        while (text_x.length() > 0) {
            int len_x = text_x.length();
            int len_y = text_y.length();
            String alpha = "" + text_x.charAt(0);
            text_x = text_x.replaceAll(alpha, "");
            text_y = text_y.replaceAll(alpha, "");
            
            int diff_x = len_x - text_x.length();
            int diff_y = len_y - text_y.length();
            
            if (diff_y == 0) {
                continue;
            }
            
            if (diff_x > diff_y) {
                for (int i = 0; i < diff_y; i++) {
                    list.add(alpha);
                }
                set.add(alpha);
            } else {
                for (int i = 0; i < diff_x; i++) {
                    list.add(alpha);
                }
                set.add(alpha);
            }
        }
        
        if (list.isEmpty()) {
            return "-1";
        }

        Collections.sort(list, Collections.reverseOrder());
        
        if (set.size() == 1 && set.contains("0")) {
            return "0";
        }
        
        for (String num : list) {
            stringBuilder.append(num);
        }
        
        return stringBuilder.toString();
    }
}