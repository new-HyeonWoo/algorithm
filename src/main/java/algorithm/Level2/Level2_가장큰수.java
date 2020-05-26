package algorithm.Level2;

import java.util.Arrays;
import java.util.Comparator;

public class Level2_가장큰수 {

    public static void main(String[] args) {

        Level2_가장큰수 le = new Level2_가장큰수();

//        int[] numbers = {6, 10, 2};
        int[] numbers = {0, 000, 0};
        le.solution(numbers);

        //참고
        //https://m.blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221580402785&categoryNo=39&proxyReferer=https:%2F%2Fwww.google.com%2F

    }


    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(arr[0].startsWith("0")) {
            answer = "0";
        } else {
            for(String str : arr) {
                answer += str;
            }
        }

        return answer;
}

}
