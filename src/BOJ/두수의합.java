package BOJ;

import java.util.*;
import java.io.*;

public class 두수의합 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int target = Integer.parseInt(br.readLine());

		int left =0, right = n-1; // last index
		int cnt = 0;
		while(left<right) {
			
			int sum = arr[left] + arr[right];
			
			if(sum==target) {
				cnt++;
			}
			
			if(sum > target) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(cnt);		
	}

}
