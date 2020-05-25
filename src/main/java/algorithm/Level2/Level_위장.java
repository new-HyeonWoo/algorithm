package algorithm.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Level_위장 {

    public static void main(String[] args) {


        Level_위장 le = new Level_위장();
//        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        le.solution(clothes);
    }

    public int solution(String[][] clothes) {
        int answer = 0;
        int cnt = 1;

        List<String> list = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();;

        for(int i=0; i<clothes.length; i++) {
            String key = clothes[i][1];

            if(map.get(key) != null) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
                list.add(key);
            }
        }

        for(int i=0; i<list.size(); i++) {
            cnt = cnt * (map.get(list.get(i)) + 1);
        }

        cnt = cnt -1;
        answer = cnt;
        return answer;
    }
}
