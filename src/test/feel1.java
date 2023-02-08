package test;

import java.util.ArrayList;

// 길찾기 - top down, dp
public class feel1 {

    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) {

        list = new ArrayList<>();
        for(int i = 0; i < 5; i++) list.add(new ArrayList<>());
        list.get(0).add(5);
        list.get(1).add(1);
        list.get(1).add(5);
        list.get(2).add(2);
        list.get(2).add(3);
        list.get(2).add(4);
        list.get(3).add(9);
        list.get(3).add(4);
        list.get(3).add(1);
        list.get(3).add(7);
        list.get(4).add(6);
        list.get(4).add(7);
        list.get(4).add(1);
        list.get(4).add(9);
        list.get(4).add(3);
        int max = search( 0, 0);
        System.out.println(max);

    }

    public static int search(int row, int col) {
        int currNum = list.get(row).get(col);
        if(row == 4) {
            return currNum;
        }


        int left = search(row+1, col);
        int max = left;
        if(col < 5) {
            int right = search(row + 1, col + 1);
            max = Math.max(max, right);
        }

        return currNum + max;
    }
}
