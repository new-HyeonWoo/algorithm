package algorithm;

import java.util.*;

public class Level1_실패율 {

    public static void main(String[] args) {
        Level1_실패율 le = new Level1_실패율();

        int N = 5;  //게임스테이지 개수
        int[] starge = {2, 1, 2, 6, 2, 4, 3, 3}; //사람들이 머물러진 스테이지

//        int N = 4;
//        int[] starge = {4,4,4,4,4};

//        int N = 4;
//        int[] starge = {1,0,0,2};

        le.solution(N, starge);
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        List<Map> list = new ArrayList();
        for(int i=0; i<N; i++) {
            int idx = i+1;
            int num = (int) Arrays.stream(stages).filter(x -> x == idx).count();
            int cnt = (int) Arrays.stream(stages).filter(x -> x >= idx).count();

            double value = 0;

            if(num == 0) {
                value = 0;
            } else if(cnt != 0) {
                value = (double) num / (double) cnt;
            }

            HashMap map = new HashMap();
            map.put("key", idx);
            map.put("value", value);
            list.add(map);
        }

        Collections.sort(list, new Comparator<Map>() {
            @Override
            public int compare(Map o1, Map o2) {
                int r = new Double( (Double) o1.get("value")).compareTo((Double) o2.get("value"))*-1;
                if(r==0) r = (Integer) o1.get("key") - (Integer) o2.get("key");
                return r;
            }
        });

//        list.sort(Comparator.comparing(
//                m -> ((HashMap)m).get("value").toString(),
//                Comparator.nullsLast(Comparator.reverseOrder()))
//        );

        answer = new int[list.size()];
        int i=0;
        for(Map m : list){
            answer[i] = (int) m.get("key");
            i++;
        }

        return answer;
    }
}
