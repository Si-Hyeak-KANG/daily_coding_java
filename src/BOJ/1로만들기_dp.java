package BOJ;
import java.io.*;
public class 1로만들기_dp {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(br.readLine());
		
		int[] arr = new int[target+2];
		arr[2] = 1;
		
		if(target >= 3) {
			arr[3] = 1;
		}
		
		for( int i=4; i <= target; i++) {
			
			int f1 = Integer.MAX_VALUE;
			int f2 = Integer.MAX_VALUE;
			
			if(i%2==0) {
				f1 = arr[i/2];
			}
			
			if(i%3==0) {
				f2 = arr[i/3];
			}
			
			arr[i] = Math.min(arr[i-1], Math.min(f1, f2)) + 1;
		}
		
		System.out.println(arr[target]);
	}

}
