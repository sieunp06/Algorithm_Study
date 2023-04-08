class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] arr = my_string.toCharArray();
        char[] alpha_arr = {'a', 'e', 'i', 'o', 'u'};
        
        for (char alpha : arr) {
            boolean isContain = false;
            for (char alpha1 : alpha_arr) {
                if (alpha == alpha1) {
                    isContain = true;
                    break;
                }
            }
            if (!isContain)
                answer += alpha;
        }
        return answer;
    }
}