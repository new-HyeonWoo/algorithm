package algorithm;

import java.util.ArrayList;

public class Level1_비밀지도 {

    public static void main(String[] args) {

        Level1_비밀지도 le = new Level1_비밀지도();

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

//        le.solution(n, arr1, arr2);
        le.solution2(n, arr1, arr2);

    }

    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];

        int[] arr3=new int[n];
        for(int i=0; i<n; i++) {
            arr3[i]=arr1[i]|arr2[i];
            String binary=Integer.toBinaryString(arr3[i]);
            if(binary.length()<n) {
                binary=String.format("%0"+n+"d", Integer.parseInt(binary));
            }

            binary=binary.replaceAll("1", "#");
            binary=binary.replaceAll("0", " ");
            answer[i]=binary;

        }

        return answer;
    }


    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];

        int[][] a = this.getList(arr1, n);
        int[][] b = this.getList(arr2, n);

        int[][] temp = new int[n][n];

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++) {
                if(a[i][j] == 1 || b[i][j] == 1){
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = 0;
                }
            }
        }

        for(int i=0; i<temp.length; i++){
            int[] t = temp[i];
            String result = "";
            for(int j=t.length-1; j>=0; j--) {
                if(t[j] == 1){
                    result += "#";
                } else {
                    result += " ";
                }
            }
            answer[i] = result;
        }

        return answer;
    }

    public int[][] getList(int[] arr, int n){
        ArrayList list = new ArrayList();

        int[][] b = new int[n][n];

        for(int i=0; i<arr.length; i++){
            int j= 0;
            while (arr[i] != 1){
                b[i][j++] = arr[i] % 2;
                arr[i] = arr[i] / 2;
            }
            b[i][j] = arr[i];
        }

        return b;
    }
}
