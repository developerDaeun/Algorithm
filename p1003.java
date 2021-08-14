package baekjoon;

import java.util.Scanner;

public class p1003 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		int[] dp;
		int[] count;

		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			dp = new int[N+2];
			count = new int[N+2];
			// 0 횟수만 구하기 ( 1횟수는 0 횟수에서 한칸 앞이 답)
			dp[1] = 1;
			count[0] = 1;
			count[1] = 0;

			
			for(int i = 2; i < N + 2; i++) {
				if(dp[i] == 0) {
					dp[i] = dp[i-1] + dp[i-2];
					count[i] = count[i-1] + count[i-2];
				}
			}
			if(N > 1)
				System.out.println(count[N] + " " + count[N+1]);
			else if(N == 0)
				System.out.println("1 0");
			else if(N == 1)
				System.out.println("0 1");
		}
	}

}
