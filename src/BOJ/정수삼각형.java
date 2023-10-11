package BOJ;

import java.util.*;
import java.io.*;

public class 정수삼각형 {
	
	static int[] arr, temp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		arr[0] = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < n; i++) {
			temp = Arrays.copyOf(arr, n);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
					
				setNextNumber(i,j,Integer.parseInt(st.nextToken()));
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int value : arr) {
			max = Math.max(value, max);
		}
		
		System.out.println(max);
	}
	
	private static void setNextNumber(int i, int j, int value) {
		
		if(j==0) {
			arr[j] = temp[j] + value;
		} else if (j == i) {
			arr[j] = temp[j-1] + value;
		} else {
			arr[j] = Math.max(temp[j-1], temp[j]) + value;
		}
	}

}
