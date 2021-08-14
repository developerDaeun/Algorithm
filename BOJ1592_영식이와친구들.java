import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1592_영식이와친구들 {

	static int N, M, L;
	static int[] getBall;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		getBall = new int[N];
		
		bw.write(String.valueOf(game(0,0)));
		bw.close();
	}

	static int game(int cur, int total) {	// cur: 0번 시작, total: 총 공을 받은 횟수
		getBall[cur] = 1;	// 처음 공을 받은 사람 횟수 + 1
		while(getBall[cur] != M) {
			if(getBall[cur]%2==1) {	// 홀수번 공을 받았으면 시계방향으로 L번째 사람에게 공 던짐
				cur = (cur+L)%N; // ex) N이 5일때, 3번째 사람이 2칸뒤인 0번째 사람에게 공을 던지려면 (3+2)%5 = 0번째 사람
			}else {	// 짝수번 공을 받았으면 반시계방향으로 L번째 사람에게 공 던짐
				cur = ((N-L)+cur)%N; // ex) N이 5일때, 1번째 사람이 2칸 앞인 4번째 사람에게 공을 던지려면 ((5-2)+1)%5 = 4번째 사람
			}	
			getBall[cur]++; // 현재 받은 사람의 받은 횟수 추가
			total++;
		}
		return total;
	}
}
