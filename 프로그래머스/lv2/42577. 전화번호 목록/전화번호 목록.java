import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Boolean answer = true;
        
        Map<String, Integer> phone_num = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) 
            phone_num.put(phone_book[i], i);
        
        for (int i = 0; i < phone_book.length; i++)
            for (int j = 0; j < phone_book[i].length(); j++)
                if (phone_num.containsKey(phone_book[i].substring(0, j)))
                    answer = false;

        return answer;
    }
}