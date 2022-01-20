import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17244_아맞다우산 {

    static int R, C;
    static char[][] map;
    static int Sr, Sc;
    static int bit;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        int num = 0;    // 물건의 개수
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                // 현재 위치 S  나가는 문 E  물건 위치 X
                if (map[i][j] == 'S') {
                    Sr = i;
                    Sc = j;
                } else if (map[i][j] == 'X') {
                    map[i][j] = Character.forDigit(num++, 10);   // num => 0, 1, 2        1 << num
                }
            }
        }

        // 물건의 개수만큼 bit 에 1 채우기 => 모든 물건을 챙겼는 지 확인하기 위한 용도
        for (int i = 0; i < num; i++){
            bit += (1 << i);
        }

        bfs();

        System.out.print(res);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs() {
        Queue<Data> q = new LinkedList<>();
        boolean[][][] v = new boolean[R][C][32];    // 1 1 1 1 1 => 31까지 나올 수 있음

        q.offer(new Data(Sr, Sc, 0, 0));
        v[Sr][Sc][0] = true;

        while (!q.isEmpty()) {
            Data cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                // S 위치이거나, 벽을 만나면 continue
                if(v[nr][nc][cur.bits] || map[nr][nc] == 'S' || map[nr][nc] == '#') continue;

                // 모든 물건을 챙겼을 때(bit에서 물건의 개수만큼 1일때) 결과값 구하고 break
                if (map[nr][nc] == 'E' && cur.bits == bit){
                    res = cur.time + 1;
                    break;
                }

                // 문을 만나고, 모든 물건을 챙기지 않았을 때 continue
                if (map[nr][nc] == 'E') continue;

                // . 을 만나면 큐에 삽입, 방문체크
                if (map[nr][nc] == '.') {
                    q.offer(new Data(nr, nc, cur.time + 1, cur.bits));
                    v[nr][nc][cur.bits] = true;
                    continue;
                }

                // 이미 챙긴 물건이면 continue
                // 지금까지 챙긴 물건(cur.bits)과 현재 물건(1 << map[nr][nc]) 을 or 연산하면
                // 챙긴 물건인 지 방문체크로 알 수 있다.
                if(v[nr][nc][cur.bits | (1 << (map[nr][nc] - '0'))]) continue;

                // 물건을 만나면 큐에 삽입, 방문체크
                q.offer(new Data(nr, nc, cur.time + 1, cur.bits | (1 << (map[nr][nc] - '0'))));
                v[nr][nc][cur.bits | (1 << (map[nr][nc] - '0'))] = true;
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