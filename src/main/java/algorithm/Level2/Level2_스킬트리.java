package algorithm.Level2;

public class Level2_스킬트리 {

    public static void main(String[] args) {

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        Level2_스킬트리 le = new Level2_스킬트리();
        le.solution(skill, skill_trees);

    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] tempArr = new String[skill_trees.length];

        for(int i=0; i<skill_trees.length; i++) {
            String str = "";
            String[] arr = skill_trees[i].split("");

            for(int j=0; j<arr.length; j++) {
                if(skill.contains(arr[j])) {
                    str += arr[j];
                }
            }
            tempArr[i] = str;
        }

        for(int i=0; i<tempArr.length; i++) {
            if(skill.indexOf(tempArr[i]) == 0) {
                answer++;
            }
        }
        return answer;
    }
}
