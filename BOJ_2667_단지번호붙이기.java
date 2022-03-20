import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667_단지번호붙이기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = s[j].charAt(0);
            }
        }

        Queue<Data> q = new LinkedList<>();
        boolean[][] v = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i][j]) continue;
                v[i][j] = true;
                if (map[i][j] == '1') {
                    int cnt = 1;
                    q.offer(new Data(i, j));
                    while (!q.isEmpty()) {
                        Data cur = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = cur.r + dr[d];
                            int nc = cur.c + dc[d];

                            if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc])
                                continue;

                            v[nr][nc] = true;

                            if (map[nr][nc] == '0') continue;

                            q.offer(new Data(nr, nc));
                            cnt++;
                        }
                    }
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int temp : list) {
            sb.append(temp).append("\n");
        }

        System.out.print(sb);
    }

    static class Data {
        int r, c;

        public Data(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}