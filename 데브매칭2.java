import java.util.*;

public class 데브매칭2 {
    public static void main(String[] args) {

        System.out.print(Solution.solution(
//                new String[]{"??b", "abc", "cc?"}
                new String[]{"aa?"}
        ));

    }

    static class Solution {

        static char[][] chars;
        static boolean[][] v;
        static boolean[] check;
        static int n, m;
        static int[] dr = {-1, 1, 0, 0};    // 상하좌우
        static int[] dc = {0, 0, -1, 1};
        static ArrayList<Data> list;
        static int total;

        public static int solution(String[] grid) {
            int answer = -1;

            n = grid.length;
            m = grid[0].length();
            chars = new char[n][m];
            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    chars[i][j] = grid[i].charAt(j);
                    if (chars[i][j] == '?')
                        list.add(new Data(i, j));   // ? 위치 저장
                }
            }

            perm(0);

            answer = total;

            return answer;
        }

        private static void perm(int cnt) {
            if (cnt == list.size()) {
                int sum = 0;
                v = new boolean[n][m];
                check = new boolean[3];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (v[i][j] || check[chars[i][j] - 97]) continue;
                        v[i][j] = true;
                        check[chars[i][j] - 97] = true;
                        sum += dfs(chars[i][j], i, j);
                    }
                }
                if (sum == n * m) {
                    total++;
                }
                return;
            }

            int r = list.get(cnt).r;
            int c = list.get(cnt).c;
            chars[r][c] = 'a';
            perm(cnt + 1);
            chars[r][c] = 'b';
            perm(cnt + 1);
            chars[r][c] = 'c';
            perm(cnt + 1);
        }

        private static int dfs(char ch, int r, int c) {

            int sum = 1;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || v[nr][nc])
                    continue;

                if (ch != chars[nr][nc]) continue;

                v[nr][nc] = true;
                sum += dfs(ch, nr, nc);
            }

            return sum;
        }
    }

    static class Data {
        int r, c;

        public Data(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}