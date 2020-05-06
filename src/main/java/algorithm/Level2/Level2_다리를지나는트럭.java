package algorithm.Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level2_다리를지나는트럭 {

    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        Level2_다리를지나는트럭 le = new Level2_다리를지나는트럭();
        le.solution(bridge_length, weight, truck_weights);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        LinkedList<Integer> q = new LinkedList<Integer>();
        List<Integer> truck = new ArrayList<Integer>();
        List<Integer> ss = new ArrayList<Integer>();

        for(int d : truck_weights) {
            q.add(d);
        }

        int passCnt = 0;
        int second = 0;
        while (passCnt != truck_weights.length) {
            second++;
            int sum = 0;
            for(int d : truck) {
                sum += d;
            }

            if(!q.isEmpty()) {
                sum += q.peekFirst();
                if(sum <= weight) {
                    truck.add(q.pollFirst());
                    ss.add(0);
                }
            }

            for(int i=0; i<truck.size(); i++) {
                ss.set(i, ss.get(i) + 1);
            }

            List<Integer> slist = new ArrayList<Integer>();
            for(int i=0; i<ss.size(); i++) {
                if(ss.get(i) >= bridge_length) {
                    slist.add(i);
                }
            }

            for(int i=0; i<slist.size(); i++) {
                int idx = slist.get(i);
                truck.remove(idx);
                ss.remove(idx);
                passCnt++;
            }
        }
        second++;
        answer = second;

        return answer;
    }
}
