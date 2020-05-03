package algorithm.Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level2_기능개발 {

    public static void main(String[] args) {

        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        Level2_기능개발 le = new Level2_기능개발();
        le.solution(progresses, speeds);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        LinkedList<Integer> q = new LinkedList<Integer>();
        LinkedList<Integer> d = new LinkedList<Integer>();

        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int data : progresses) q.add(data);
        for(int data : speeds) d.add(data);

        int temp = 0;
        int day = 0;
        int beforeDay = 0;
        while (!q.isEmpty()) {

            if(temp == 0) {
                temp = q.getFirst();
            }
            temp = temp + d.getFirst();
            day++;

            if(temp >= 100) {

                if(beforeDay == 0) {
                    list.add(1);
                    beforeDay = day;
                } else {
                    if(beforeDay < day) {
                        list.add(1);
                        beforeDay = day;
                    } else {
                        int a = list.getLast() + 1;
                        list.removeLast();
                        list.add(a);
                    }
                }

                temp = 0;
                day = 0;
                q.removeFirst();
                d.removeFirst();
            }
        }

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }

}
