package BOJ;

import java.util.*;
import java.io.*;

// SET으로 풀이할 경우
// 어차피 데이터 N 100,000개, M 100,000개 니까 안될건 없음
public class 수찾기_set {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> first = new HashSet();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			first.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (first.contains(Integer.parseInt(st.nextToken()))) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}
		
	}
}
