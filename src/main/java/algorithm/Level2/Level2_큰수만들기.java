package algorithm.Level2;

import java.lang.reflect.Array;
import java.util.*;

public class Level2_큰수만들기 {


    public static void main(String[] args) {

//        String number = "1924";
//        int k = 2;
//        String number = "1231234";
//        int k = 3;

        String number = "4177252841";
        int k = 4;

        Level2_큰수만들기 le = new Level2_큰수만들기();
        le.solution(number, k);

    }


    public String solution(String number, int k) {
        String answer = "";
        String[] strArr = number.split("");
        int[] arr = new int[number.length()];
        LinkedList<Integer> q = new LinkedList<>();
        LinkedList<Integer> tempQ = new LinkedList<>();


        for(int i=0; i<strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
            q.add(Integer.parseInt(strArr[i]));
            tempQ.add(Integer.parseInt(strArr[i]));
        }

        String result = "";
        int n = number.length() - k;
        List<Integer> list = new ArrayList();
        int cnt = 0;
        int c = k;
        while(result.length() < number.length() - k){

            if(cnt <= n) {
                list.add(q.get(cnt));
                cnt++;
            } else {

                int temp = 0;
                int idx = 0;
                for(int i=0; i<list.size(); i++) {
                    if(temp < list.get(i)) {
                        temp = list.get(i);
                        idx = i;
                    }
                }

                for(int i=0; i<=idx; i++) {
                    q.removeFirst();
                }

                result += temp;
                list = new ArrayList<>();
                cnt = 0;
                n = q.size() - ((number.length() - k) - result.length());

                if(cnt > n) {
                    for(int i=0; i<q.size(); i++) {
                        result += q.get(i);
                    }
                }

            }
        }

        answer = result;
        return answer;
    }

}
