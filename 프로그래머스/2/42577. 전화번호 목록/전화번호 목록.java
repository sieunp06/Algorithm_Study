import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for (String phoneNum: phone_book) {
            set.add(phoneNum);
        }
        
        if (phone_book.length != set.size()) {
            return false;
        }
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
        }
        
        return answer;
    }
}