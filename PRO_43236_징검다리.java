import java.util.Arrays;

public class PRO_43236_징검다리 {
    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    static public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int len = rocks.length;
        int[] dist = new int[len + 1];
        int before = 0;
        for(int i = 0; i < len; i++){
            dist[i] = rocks[i] - before;
            before = rocks[i];
        }
        dist[len] = distance - rocks[len - 1];




        return answer;
    }
}