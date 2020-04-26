package algorithm;

import java.util.Arrays;

public class Level1_예산 {

    public static void main(String[] args) {
        Level1_예산 le = new Level1_예산();

//        int[] d = {1,3,2,5,4};
//        int budget = 9;
        int[] d = {2,2,3,3};
        int budget = 10;

        System.out.println(le.solution(d, budget));

    }

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        int cnt = 0;
        for(int i=0; i<d.length; i++) {
            if(budget != 0 && budget >= d[i]) {
                budget  = budget - d[i];
                cnt++;
            }
        }
        answer = cnt;
        return answer;
    }
}
