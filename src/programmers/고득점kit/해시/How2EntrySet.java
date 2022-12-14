package programmers.고득점kit.해시;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * entrySet() 은 key 와 value 반환
 * keySet() 은 key 값을 반환
 * iterator() 는 순서에 상관없이 하나씩 접근
 */
public class How2EntrySet {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry<String,Integer> entry = it.next();
            if(entry.getValue() != 0) {
                String value = entry.getKey();
            }
        }
    }
}
