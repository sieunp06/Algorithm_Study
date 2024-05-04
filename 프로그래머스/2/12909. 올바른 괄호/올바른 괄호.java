import java.util.Stack;

class Solution {
    final char OPEN_BRACKET = '(';
    final char CLOSE_BRACKET = ')';
    
    boolean solution(String s) {
        Stack<Character> brackets = new Stack<>();
        
        for (char bracket: s.toCharArray()) {
            if (bracket == OPEN_BRACKET) {
                brackets.push(bracket);
                continue;
            } 
            if (brackets.isEmpty()) {
                return false;
            }
            brackets.pop();
        }
        
        if (!brackets.isEmpty()) {
            return false;
        }
        return true;
    }
}