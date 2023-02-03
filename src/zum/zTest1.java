package zum;

import java.util.*;

public class zTest1 {

    public static void main(String[] args) {
        zTest1 test = new zTest1();
        int result = test.solution(new int[]{6, 5, 7, 3, 4, 2});
        System.out.println(result);

    }

    int answer = -1;
    List<Integer> stickIdxList;
    public int solution(int[] histogram) {

        stickIdxList = new ArrayList<>();
        searchMaxArea(0, histogram);
        return answer;
    }

    // 재귀 탐색
    void searchMaxArea(int start, int[] histogram) {

        if(stickIdxList.size()==2) {
            int first = stickIdxList.get(0);
            int second = stickIdxList.get(1);
            int area = histogram[first] * histogram[second];
            answer = Math.max(answer, area);
            return;
        }

        for(int i = start; i < histogram.length; i++) {
            if(!isValid(i)) continue;
            stickIdxList.add(i);
            searchMaxArea(i+1, histogram);
            stickIdxList.remove(stickIdxList.size()-1);
        }
    }

    boolean isValid(int i) {
        if(stickIdxList.isEmpty()) return true;
        if(i - stickIdxList.get(0) > 1) return true;
        return false;
    }
}
