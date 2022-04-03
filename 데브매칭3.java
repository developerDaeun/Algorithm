
public class 데브매칭3 {
    public static void main(String[] args) {

        System.out.print(Solution.solution(
                8,
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {4, 0}, {5, 1}, {6, 1}, {7, 2}, {7, 3}, {4, 5}, {5, 6}, {6, 7}},
                4, 0, 3
        ));

    }

    static class Solution {

        static boolean[][] info, res;
        static boolean[] v;

        public static int solution(int n, int[][] edges, int k, int a, int b) {
            int answer = 0;

            info = new boolean[n][n];
            for (int[] edge : edges) {
                info[edge[0]][edge[1]] = true;
                info[edge[1]][edge[0]] = true;
            }

            v = new boolean[n];
            res = new boolean[n][n];

            v[a] = true;
            dfs(a, b, 0, k, n);

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++) {
                    if (info[i][j] && res[i][j]) answer++;
                }
            }

            return answer / 2;
        }

        private static boolean dfs(int here, int b, int total, int k, int n) {
            if(total > k) return false;
            if(here == b) return true;

            boolean check = false;
            for (int j = 0; j < n; j++){
                if(!info[here][j] || !info[j][here] || v[j])
                    continue;

                v[j] = true;
                if(dfs(j, b, total + 1, k, n)){
                    res[here][j] = true;
                    res[j][here] = true;
                    check = true;
                }
                v[j] = false;
            }

            return check;
        }
    }
}