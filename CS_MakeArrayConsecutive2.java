import java.util.Arrays;

public class CS_MakeArrayConsecutive2 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{6, 2, 3, 8}));

    }

    static int solution(int[] statues) {
        int cnt = 0;

        Arrays.sort(statues);
        for (int i = 0; i < statues.length - 1; i++){
            cnt += statues[i + 1] - statues[i] - 1;
        }

        return cnt;
    }
}