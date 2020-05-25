package algorithm.Level2;

import java.util.Arrays;
import java.util.Collections;

public class Level2_전화번호목록 {

    public static void main(String[] args) {
        Level2_전화번호목록 le = new Level2_전화번호목록();
//        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123", "456", "789"};
        String[] phone_book = {"1195524421", "97674223", "119"};
        le.solution(phone_book);
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
