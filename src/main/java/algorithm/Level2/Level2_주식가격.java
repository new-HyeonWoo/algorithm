package algorithm.Level2;

import java.util.*;

public class Level2_주식가격 {

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3};

        Level2_주식가격 le = new Level2_주식가격();
        le.solution(prices);
    }

    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];

        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<prices.length; i++) {
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] <= prices[j]) {
                    cnt++;
                } else {
                    cnt++;
                    break;
                }
            }
            list.add(cnt);
        }

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}


