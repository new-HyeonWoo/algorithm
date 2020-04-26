package algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Level1_K번째수 {

    public static void main(String[] args) {
        Level1_K번째수 le = new Level1_K번째수();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        le.solution(array, commands);
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int st = commands[i][0]-1;
            int ed = commands[i][1]-1;
            int so = commands[i][2]-1;

            for(int j=st; j<=ed; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);

            answer[i] = list.get(so);
        }
        return answer;
    }
}
