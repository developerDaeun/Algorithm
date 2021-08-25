import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// 학생수
		int K = Integer.parseInt(st.nextToken());	// 한방에 배정할 수 있는 최대 인원 수
		
		int[][] students = new int[7][2];
		
		int s, y;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());	// 성별 (0:여 1:남)
			y = Integer.parseInt(st.nextToken());	// 학년 (1~6)
			
			students[y][s]++;	// 해당 학년의 해당 성별의 사람 카운트 +1
		}
		
		int cnt = 0;
		for(int i = 1; i <= 6; i++) {	// 학년
			for(int j = 0; j <= 1; j++) {	// 성별
				if(students[i][j]>0) { // 현재 학년의 성별이 1명 이상일 때
					if(students[i][j]<=K) {	// 사람수가 K 이하 일때 방 개수 + 1
						cnt++;
					}else {	// 사람수가 K 초과일때 방 개수 구하기
						if(students[i][j]%K==0) {	// K의 배수이면 나눈 몫만큼 방개수 더하기
							cnt = cnt + students[i][j]/K;
						}else {		// K의 배수가 아니면 나눈 몫만큼 방개수 더하고 + 1
							cnt = cnt + students[i][j]/K + 1;
						}
					}	
				}
			}
		}
		
		System.out.println(cnt);
	}
}