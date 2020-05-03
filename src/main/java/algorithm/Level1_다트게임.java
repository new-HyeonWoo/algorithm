package algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Level1_다트게임 {

    public static void main(String[] args) {


        Level1_다트게임 le = new Level1_다트게임();

//        String dartResult = "1S2D*3T";
//        String dartResult = "1D2S0T";
//        String dartResult = "1D#2S*3S";
        String dartResult = "1D2S#10S";


        le.solution(dartResult);

    }

    public int solution(String dartResult) {
        int answer = 0;

        String type = "S,D,T";
        String bonus = "*,#";
        String[] arr = dartResult.split("");

        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if(type.contains(arr[i])) {
                switch (arr[i]) {
                    case "S" :
//                        result += Math.pow(temp, 1);
                        list.add((int)Math.pow(temp, 1));
                        break;
                    case "D" :
//                        result += Math.pow(temp, 2);
                        list.add((int)Math.pow(temp, 2));
                        break;
                    case "T" :
//                        result += Math.pow(temp, 3);
                        list.add((int)Math.pow(temp, 3));
                        break;
                }
            } else if (bonus.contains(arr[i])){
                switch (arr[i]){
                    case "*" :

                        if(list != null && !list.isEmpty()){
                            int num = list.get(list.size()-1);
                            num = num*2;
                            list.set(list.size()-1, num);

                            if(list.size() >= 2){
                                int num2 = list.get(list.size()-2);
                                num2 = num2*2;
                                list.set(list.size()-2, num2);
                            }
                        }
                        break;
                    case "#" :
                        //해당점수는 마이너스

                        if(list != null && !list.isEmpty()){
                            int num = list.get(list.size()-1);
                            num = num*-1;
                            list.set(list.size()-1, num);
                        }

                        break;
                }
            } else {
                temp = Integer.parseInt(arr[i]);
                if(temp == 1) {
                    if(arr[i+1].equals("0")){
                        temp = 10;
                        i++;
                    }
                }
            }
        }

        for(int a : list) {
            answer += a;
        }

        return answer;
    }
}
