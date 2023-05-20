class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        if (my_string.length() < is_suffix.length()) return 0;
        String suffix = my_string.substring(my_string.length() - is_suffix.length(), my_string.length());
        if (suffix.equals(is_suffix)) return 1;
        return 0;
    }
}