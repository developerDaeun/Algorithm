import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {

    static int N, M;
    static int[][] map, copyMap;
    static int iceCnt, res; // 빙하개수, 년수
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];
            }
        }

        while (true){
            // 덩어리 개수 세기 (dfs)
            if(count() >= 2) break; // 두 덩어리 이상으로 분리되면 break
            if(iceCnt == 0){
                res = 0;
                break;
            }

            res++;  // 년수 + 1
            bfs();  // bfs
        }

        System.out.print(res);
    }

    static int[] dr = {-1, 1, 0, 0};   // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    static int count() {
        // 덩어리 개수 구하기 (dfs)
        v = new boolean[N][M];
        int sum = 0;    // 덩어리 개수
        iceCnt = 0;  // 빙산 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !v[i][j]) {
                    // dfs
                    v[i][j] = true;
                    dfs(i, j);
                    sum++;
                    iceCnt++;
                }
            }
        }
        return sum;
    }

    static void dfs(int r, int c){
        for (int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc])
                continue;

            if(map[nr][nc] == 0)
                continue;

            // 빙산일때만 방문
            v[nr][nc] = true;
            iceCnt++;
            dfs(nr, nc);
        }
    }

    static void bfs(){
        Queue<Data> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        // 빙산 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    q.offer(new Data(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Data cur = q.poll();

            // 빙산이 있는 위치이면 주변 바다의 개수를 구한다.
            if (map[cur.r][cur.c] > 0) {
                int sum = 0;    // 주변 바다의 개수
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;

                    // 주변이 바닷물이면 개수 + 1
                    if (map[nr][nc] == 0) {
                        sum++;
                    }
                }

                // 다 녹을 수 있는 빙산이면 0으로 변경
                if (map[cur.r][cur.c] - sum <= 0) {
                    copyMap[cur.r][cur.c] = 0;
                }else{
                    copyMap[cur.r][cur.c] = map[cur.r][cur.c] - sum;
                }
            }
        }

        copy();
    }

    static void copy(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = copyMap[i][j];
            }
        }
    }

    static class Data {
        int r, c;

        public Data(int r, int c) { // Alt + Insert => IntelliJ 생성자
            this.r = r;
            this.c = c;
        }
    }
}