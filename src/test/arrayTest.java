package test;

import java.util.Arrays;

public class arrayTest {

    public static void main(String[] args) {
        arrayTest test = new arrayTest();
        int[] arr = {1,2,3,4};
        test.trans(arr);
        System.out.println(Arrays.toString(arr));
    }

    void trans(int[] arr) {
        arr[3] = 400;
    }


}
