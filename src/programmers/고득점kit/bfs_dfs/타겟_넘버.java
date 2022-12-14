package programmers.고득점kit.bfs_dfs;

public class 타겟_넘버 {
    public static void main(String[] args) {
        타겟_넘버 test = new 타겟_넘버();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = test.solution(numbers, target);
        System.out.println(result);
    }

    int count = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);
        System.out.println(count);
        return count;
    }

    public void dfs(int[] numbers, int target, int column, int sum) {

        if (column >= numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        sum += numbers[column];
        dfs(numbers, target, column + 1, sum);
        sum -= numbers[column];
        sum -= numbers[column];
        dfs(numbers, target, column + 1, sum);
        return;
    }

    int dfs2(int[] numbers, int column, int sum, int target) {
        if(column == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs2(numbers, column+1, sum + numbers[column], target)
                + dfs2(numbers, column+1,sum - numbers[column], target);
    }
}
