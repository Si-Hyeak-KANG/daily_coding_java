import java.util.Arrays;

public class KTest {

    public int solution(int[][] flowers) {

        Arrays.sort(flowers, (o1, o2)->{
            return o1[0] - o1[0];
        });

        int floweringDaySize = getLastDay(flowers);
        boolean[] checkFloweringDay = new boolean[floweringDaySize+1];

        for(int i = 0; i < getLength(flowers); i++) {
            for(int j = flowers[i][0]; j <flowers[i][1]; j++) {
                checkFloweringDay[j] = true;
            }
        }

        int result = checkCount(checkFloweringDay);

        return result;
    }

    private int checkCount(boolean[] checkFloweringDay) {
        int count = 0;
        for (boolean day : checkFloweringDay) {
            if(day) count++;
        }
        return count;
    }

    private int getLength(int[][] flowers) {
        return flowers.length;
    }

    private int getLastDay(int[][] flowers) {
        return flowers[flowers.length-1][1];
    }
}
    