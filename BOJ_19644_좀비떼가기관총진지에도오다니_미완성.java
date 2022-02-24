import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
9
7 10
0
0
16
4
12
8
2
0
5
14

답 : YES
 */
public class BOJ_19644_좀비떼가기관총진지에도오다니_미완성 {

    static int L, ML, MK, C;   // 거리, 기관총 사거리, 낮출 체력, 지뢰 개수
    static int[] Z; // 좀비 체력
    static boolean check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());   // 거리

        StringTokenizer st = new StringTokenizer(br.readLine());
        ML = Integer.parseInt(st.nextToken());  // 기관총 사거리
        MK = Integer.parseInt(st.nextToken());  // 낮출 체력

        C = Integer.parseInt(br.readLine());   // 지뢰 개수
        Z = new int[L + 1];

        for (int i = 1; i <= L; i++) {
            st = new StringTokenizer(br.readLine());
            Z[i] = Integer.parseInt(st.nextToken());    // 0 : 좀비 X, 1이상 : 좀비체력
        }

        solve();

        System.out.print(check ? "NO" : "YES");
    }

    private static void solve() {
        int idx = 0;    // 진지 위치
        int bombCnt = 0;
        int damage = 0;
        Queue<Integer> q = new LinkedList<>();  // 좀비 넣기
        while (true) {
            if (idx == L) break;  // 모든 좀비를 죽였으면 break

            if (idx + 1 > ML && !q.isEmpty())
                q.poll();

            if (!q.isEmpty()) {
                damage = (ML - q.peek()) * MK - Z[idx + 1];
            } else {
                damage = MK - Z[idx + 1];
            }

            if (damage < 0) {  // 죽일 수 없는 좀비일 때
                if (C == bombCnt) { // 지뢰를 다 썼으면 break
                    check = true;
                    break;
                } else {
                    bombCnt++;    // 지뢰 사용
                }
                if (!q.isEmpty()) {
                    q.offer(q.peek() + 1);
                } else {
                    q.offer(1);
                }
            } else {
                q.offer(0);
            }
            idx++;
        }
    }
}