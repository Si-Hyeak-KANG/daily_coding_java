package boj;

import java.util.*;
import java.io.*;

public class RGB거리 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			
			if(i==0) continue;
			
			setValueNextIdx(arr, i);
			
		}
		
		int result = Math.min(arr[n-1][0], Math.min(arr[n-1][1], arr[n-1][2]));
		System.out.println(result);
	}
	
	private static void setValueNextIdx(int[][] arr, int i) {
		arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
		arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
		arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
	}
}
