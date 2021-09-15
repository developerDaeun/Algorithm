import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2133_타일채우기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+2];	// N+1로 길이를 주면 N이 1일때 dp[2] 값 초기화하려다 ArrayIndexOutOfBounds 떠서... N+2
		
		dp[0] = 1;
		dp[2] = 3;
		
		for(int i = 4; i <= N; i=i+2) { // 홀수는 변화없으므로 짝수만
			dp[i] = dp[i-2]*3;	// 3*2는 3가지가 있으므로 이전 dp값에서 3배
			for(int j = i; j >= 4; j=j-2) {	// 4, 6, 8,... 은 새로운 2가지 방법이 생기므로 j를 뺀 dp 값 * 2 (==>새로생긴 방법 2가지)
				dp[i] += dp[i-j] * 2;
			}
		}
		
		System.out.println(dp[N]);
	}

}
