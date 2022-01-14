import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14578_영훈이의색칠공부 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1 <= N <= 10^5 ==> 10^5 * 10^5 == 100억개
		int N = Integer.parseInt(br.readLine());

		// 파란색을 칠했을 때 => n! 
		long fact = 1;
		for (int i = 2; i <= N; i++) {
			fact *= i;
			fact %= 1_000_000_007;
		}
		
		// 파란색을 칠한 후, 빨간색을 칠했을 때 => 빨간색 1개 칠한 값 + 2개 칠한 값
		
		// 파란색이 있는 행 or 열에 빨간색 1개 칠했을 때 => (N-1)*f(N-1)
		// 첫번째 열에 빨간색을 칠할 수 있는 칸 개수는 (N-1)
		// 나머지 칸 개수는 f(N-1)
		
		// 파란색이 없는 행 or 열에 빨간색 1개 칠했을 때 => (N-1)*f(N-2)
		long[] dp = new long[N + 1];
		dp[0] = 1;
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			dp[i] = ((i - 1) * (dp[i - 2] + dp[i - 1])) % 1_000_000_007;
		}

		System.out.print((fact * dp[N]) % 1_000_000_007);
	}
}