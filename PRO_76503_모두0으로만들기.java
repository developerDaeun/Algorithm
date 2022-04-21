import java.util.ArrayList;
import java.util.List;

public class PRO_76503_모두0으로만들기 {
    public static void main(String[] args) {
        System.out.print(solution(
                new int[]{-5, 0, 2, 1, 2},
                new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}
        ));
    }

    public static long solution(int[] a, int[][] edges) {
        long answer = -1;

        // 모든 가중치가 0인지 체크
        boolean check = false;
        for (int temp : a) {
            if (temp != 0) {
                check = true;
                break;
            }
        }

        if (!check) // 모든 가중치가 0이면 0 리턴
            answer = 0;
        else {
            int n = a.length;
            List[] list = new ArrayList[n];
            for(int i = 0; i < n; i++){
                list[i] = new ArrayList<>();
            }
            for(int[] edge : edges){
                list[edge[0]].add(edge[1]);
                list[edge[1]].add(edge[0]);
            }
        }

        return answer;
    }
}