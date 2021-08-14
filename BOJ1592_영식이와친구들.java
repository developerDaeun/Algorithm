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
		
		getBall[0] = 1;	// 1번 사람이 처음에 공을 받으므로 1 초기화
		
		bw.write(String.valueOf(game(0)));
		bw.close();
	}

	static int game(int total) {
		int cur = 0;
		while(getBall[cur] != M) {
			if(getBall[cur]%2==1) {	// 홀수번 공을 받았으면 시계방향으로 L번째 사람에게 공 던짐
				cur = (cur+L)%N; // ex) N이 5일때, 3번째 사람이 2칸뒤인 0번째 사람에게 공을 던지려면 (3+2)%5 = 0번째 사람
				getBall[cur]++;	
			}else {	// 짝수번 공을 받았으면 반시계방향으로 L번째 사람에게 공 던짐
				cur = ((N-L)+cur)%N; // ex) N이 5일때, 1번째 사람이 2칸 앞인 4번째 사람에게 공을 던지려면 ((5-2)+1)%5 = 4번째 사람
				getBall[cur]++;	
			}
			total++;
		}
		return total;
	}
}
