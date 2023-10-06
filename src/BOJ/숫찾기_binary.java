package BOJ;

import java.util.*;
import java.io.*;

//이분탐색으로 풀이할 경우
public class 수찾기_binary {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] first = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < N; i++) {
			first[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(first);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			
			boolean find = false;
			int target = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = N-1;
			
			while(left <= right) {
				int mid = (left+right)/2;
				
				if (first[mid] > target) {
					right = mid - 1;
				} else if (first[mid] < target) {
					left = mid + 1;
				} else {
					find = true;
					break;
				}
			}
			
			if(find) System.out.println("1");
			else System.out.println("0");
			
		}
	}
}
