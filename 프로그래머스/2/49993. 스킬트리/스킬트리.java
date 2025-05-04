class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skill_tree : skill_trees) {
            StringBuilder target = new StringBuilder();
            for (char alpha : skill_tree.toCharArray()) {
                if (skill.contains(String.valueOf(alpha))) {
                    target.append(alpha);
                }
            }
            if (skill.indexOf(target.toString()) == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}