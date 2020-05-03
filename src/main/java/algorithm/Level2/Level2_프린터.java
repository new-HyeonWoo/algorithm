package algorithm.Level2;

import java.util.*;

/**
 * 이거는 이해가 잘 안된다.
 * 다시 한번 확인하자.
 */
public class Level2_프린터 {

    public static void main(String[] args) {
        Level2_프린터 le = new Level2_프린터();

//        int[] priorities = {2, 1, 3, 2};
//        int location = 3;

//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;

//        int[] priorities = {1, 7, 3, 2, 1, 2, 6, 2, 5, 5};
//        int location = 5;

        int[] priorities = {1, 2, 3};
        int location = 0;

        le.solution(priorities, location);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> q = new LinkedList<Integer>();

        for(int i = 0; i < priorities.length; i++){
            q.add(priorities[i]);
        }

        while(!q.isEmpty()){
            boolean isCheck = false;
            int first = q.getFirst();
            for(int i = 1; i < q.size(); i++){
                if(first < q.get(i)){
                    isCheck = true;
                    break;
                }
            }

            if(isCheck){ //첫 번째 원소보다 큰 수가 대기목록에 있는 경우
                q.removeFirst();
                q.add(first);

                if(location == 0) location = q.size() - 1;
                else location--;
            }
            else{ //첫 번째 원소가 가장 큰 경우
                q.removeFirst();
                answer++;
                if(location == 0) break;
                else location--;
            }
        }
        return answer;
    }

}
