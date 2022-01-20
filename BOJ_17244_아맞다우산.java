import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17244_아맞다우산 {

    static int R, C;
    static char[][] map;
    static int Sr, Sc, Er, Ec;
    static int bit;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        int num = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = st.nextToken().charAt(0);
                // 현재 위치 S  나가는 문 E  물건 위치 X
                if (map[i][j] == 'S') {
                    Sr = i;
                    Sc = j;
                } else if (map[i][j] == 'X') {
                    map[i][j] = (char) num++;
                }
            }
        }

        res = Integer.MAX_VALUE;
        bfs();

        System.out.print(res);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs() {
        Queue<Data> q = new LinkedList<>();
        boolean[][][] v = new boolean[R][C][32];    // 1 1 1 1 1 => 31까지 나올 수 있음

        q.offer(new Data(Sr, Sc, 0));
        v[Sr][Sc][0] = true;

        while (!q.isEmpty()) {
            Data cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (map[nr][nc] == 'E' && ) {    // 문을 만나면 break
                    res = Math.min(res, cur.time + 1);
                    break;
                }

                if (v[nr][nc][0] || map[nr][nc] == '#')
                    continue;

                // . 과 X 를 만나면 큐에 삽입, 방문체크
                if(map[nr][nc] == '.') {
                    q.offer(new Data(nr, nc, cur.time + 1, cur.bits));
                    v[nr][nc][0] = true;
                }

                // . 이면 continue
                if (map[nr][nc] == '.') continue;

                // 물건을 만나면 (bit = bit | 1 << 물건숫자) 로 물건 체크
                if (v[nr][nc][0 | 1 << map[nr][nc] - '0']) continue;    // 챙긴 물건이면 continue



            }

        }
    }

    static class Data {
        int r, c, time, bits;

        public Data(int r, int c, int time, int bits) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.bits = bits;
        }
    }
}
