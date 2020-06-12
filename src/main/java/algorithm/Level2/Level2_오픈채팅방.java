package algorithm.Level2;

import java.util.HashMap;

public class Level2_오픈채팅방 {

    public static void main(String[] args) {

        Level2_오픈채팅방 le = new Level2_오픈채팅방();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        le.solution(record);

    }


    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> map = new HashMap<>();
        int len = 0;
        for(String str : record) {
            String[] arr = str.split(" ");
            if(!arr[0].equals("Change")) len++;
            if(arr[0].equals("Leave")) continue;
            String 아이디 = arr[1];
            String 닉네임 = arr[2];
            map.put(아이디, 닉네임);
        }

        answer = new String[len];
        int idx = 0;
        for(String str : record) {
            String[] arr = str.split(" ");
            String type = arr[0];
            if(!"Change".equals(type)) {
                String id = arr[1];
                String nickName = map.get(id);
                String msg = "Enter".equals(type) ? "님이 들어왔습니다." : "님이 나갔습니다.";

                answer[idx] = nickName + msg;
                idx++;
            }
        }
        return answer;
    }


}
