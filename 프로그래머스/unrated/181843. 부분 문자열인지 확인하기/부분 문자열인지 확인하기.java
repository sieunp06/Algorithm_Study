class Solution {
    public int solution(String my_string, String target) {
        String my_string_replaced = my_string.replace(target, "");
        return my_string_replaced.length() != my_string.length() ? 1:0;
    }
}