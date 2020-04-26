package algorithm;

import org.graalvm.compiler.lir.stackslotalloc.LSStackSlotAllocator_OptionDescriptors;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Level1_모의고사 {

    public static void main(String[] args) {

        Level1_모의고사 le = new Level1_모의고사();

        int[] answers = {1, 3, 2, 4, 2};

        le.solution(answers);

    }

    /**
     * 완전탐색 알고리즘
     * @param answers
     * @return
     */
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] student_1 = {1, 2, 3, 4, 5};
        int[] student_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];
        for(int i=0; i<answers.length; i++) {
            //1번 수포자
            if(answers[i] == student_1[i%student_1.length]) {
                cnt[0]++;
            }

            //2번 수포자
            if(answers[i] == student_2[i%student_2.length]) {
                cnt[1]++;
            }

            //3번 수포자
            if(answers[i] == student_3[i%student_3.length]) {
                cnt[2]++;
            }
        }



        int maxVal = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
//        int maxVal = 0;
//        for(int data : cnt) {
//            if(maxVal <= data) {
//                maxVal = data;
//            }
//        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<cnt.length; i++) {
            if(maxVal <= cnt[i]){
                list.add(i+1);
            }
        }

        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
