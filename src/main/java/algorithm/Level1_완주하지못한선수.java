package algorithm;

import java.util.Arrays;

public class Level1_완주하지못한선수 {

    public static void main(String[] args) {

        Level1_완주하지못한선수 le = new Level1_완주하지못한선수();

//        String[] participant = {"leo", "kiki", "eden"}; //참여자
//        String[] completion = {"eden", "kiki"}; //완주한 선수명단

        String[] participant = {"mislav", "stanko", "mislav", "ana"}; //참여자
        String[] completion = {"stanko", "ana", "mislav"}; //완주한 선수명단

        String a = le.solution(participant, completion);
        System.out.printf(a);

    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<participant.length; i++){
            if(i <= completion.length-1 && (participant[i] != completion[i])) {
                answer = participant[i].toString();
                break;
            }
        }

        if("".equals(answer)) answer = participant[participant.length-1];

        return answer;
    }
}
