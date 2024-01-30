import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> list1 = filterText(str1);
        
        double total = list1.size();
        double union = 0;
        
        for (String target : filterText(str2)) {
            if (list1.contains(target)) {
                list1.remove(target);
                union++;
            } else {
                total++;
            }
        }
        
        if (total == union) {
            return 65536;
        }
        
        return (int) Math.floor(union / total * 65536);
    }
    
    public List<String> filterText(String str) {
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String text = str.substring(i, i + 2);
            if (text.replaceAll("[a-z]", "").isEmpty()) {
                arr.add(text);
            }
        }
        return arr;
    }
}