class Solution {
    public String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        
        boolean isFirst = true;
        for (char c : s.toCharArray()) {
            if (isFirst) {
                stringBuilder.append(Character.toUpperCase(c));
            } else {
                stringBuilder.append(Character.toLowerCase(c));
            }
            isFirst = false;
            if (c == ' ') {
                isFirst = true;
            }
        }
        
        return stringBuilder.toString();
    }
}