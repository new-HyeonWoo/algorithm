package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1_greedy {

    public static void main(String[] args) {

        Level1_greedy greedy = new Level1_greedy();
        greedy.greedy_체육복();;

    }


    public void greedy_체육복(){

        Level1_greedy greedy = new Level1_greedy();
        int n = 8;
        int[] lost = {4,5};
        int[] reserve = {5,6};


        int answer = greedy.solution(n, lost, reserve);
        System.out.println("answer :" + answer);
    }

    /** greedy_체육복 */
    public int solution(int n, int[] lost, int[] reserve) {

//        전체 학생의 수는 2명 이상 30명 이하입니다.
//        체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//        여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.

//        if(!(n >= 2 && n<= 30)){
//            return 0;
//        }
//
//        if(!(lost.length > 0 && lost.length <= n)){
//            return 0;
//        }

        int answer = 0;

        //안정빵으로 입을수 있는 사람의 수
        answer = n - lost.length;
        List<String> list = new ArrayList<String>();
        List<String> temp = new ArrayList<>();

        for(int k : reserve){
            if(Arrays.stream(lost).anyMatch(x->x == k)){
                temp.add(String.valueOf(k));
                answer++;
            } else {
                list.add(String.valueOf(k));
            }

        }

        for(int i : lost) {

            if(temp.contains(String.valueOf(i))){
                continue;
            }

            if(list.contains(String.valueOf(i))){
                list.remove(String.valueOf(i));
                answer++;
                continue;
            }

            if(list.contains(String.valueOf(i-1))){
                list.remove( String.valueOf(i-1));
                answer++;
            } else if (list.contains(String.valueOf(i+1))) {
                list.remove(String.valueOf(i+1));
                answer++;
            }
        }

        return answer;
    }

}
