package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Level1_크레인인형뽑기게임 {

    public static void main(String[] args) {

        Level1_크레인인형뽑기게임 le = new Level1_크레인인형뽑기게임();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        ArrayList<Integer> aa = new ArrayList();

        aa.add(1);
        aa.add(2);
        aa.add(3);
        aa.add(4);
        aa.add(5);
        aa.add(6);
        aa.add(7);

        Predicate a = (b) -> b.equals(2);

        System.out.println(a.test(1));

//        int a = 1;
//        Integer b = a;

//        System.out.println(aa.stream().filter((x) -> x.equals(1) || x.equals(7)).count());

//        System.out.println(board.length);

//        le.solution(board, moves);
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        //크래인 뽑기
        int cnt = 0;
        int idx = 0;
        int move = 0;
        for(int i=0; i<moves.length; i++) {
            move = moves[i] - 1;
            for(int j=0; j<board.length; j++) {
                if(board[j][move] != 0) {
                    int num = board[j][move];

                    if(list.size() >0 && list.get(list.size()-1) == num) {
                        cnt += 2;
                        list.remove(list.size()-1);
                    } else {
                        list.add(num);
                    }

                    board[j][move] = 0;
                    break;
                }
            }
        }

        answer = cnt;

        return answer;
    }
}
