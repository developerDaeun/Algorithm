import java.util.Arrays;

public class PRO_43238_입국심사 {
    public static void main(String[] args) {

        System.out.print(Solution.solution(
                6, new int[]{7, 10}
        ));

    }

    static class Solution {
        public static long solution(int n, int[] times) {

            Arrays.sort(times);

            long low = 1;
            long high = (long) times[times.length - 1] * n;
            long mid;

            while (low <= high) {
                mid = (low + high) / 2;

                // 가운데 값이 모두 심사하는 시간인지 체크
                long cnt = 0;
                for (int time : times) {
                    cnt += (mid / time);
                }

                if (cnt >= n) {   // n명을 모두 심사할 수 있으면 answer 업데이트
                    high = mid - 1;
                } else { // cnt < n
                    low = mid + 1;
                }
            }

            return low;
        }
    }
}