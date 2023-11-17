class Solution {
    public int solution(String[] spell, String[] dic) {
        for (String word : dic) {
            boolean flag = true;
            for (String alphabet : spell) {
                if (!word.contains(alphabet)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return 1;
            }
        }
        
        return 2;
    }
}