import java.util.*;

public class PRO_43238_입국심사 {
    public static void main(String[] args) {

        System.out.print(Solution.solution(
                6, new int[]{7, 10}
        ));

    }

    static class Solution {
        public static long solution(int n, int[] times) {
            long answer = 0;

//            final long MAX = Long.MAX_VALUE;

            ArrayList<Long> list = new ArrayList<>();

            int cnt = 0;
            int idx = 0;
            int mul = 1;
            while(cnt++ < n * times.length){
                if(idx == times.length) {
                    idx = 0;
                    mul++;
                }
                list.add((long)times[idx++] * mul);
            }

            Collections.sort(list);

            answer = list.get(n - 1);

            return answer;
        }
    }

}