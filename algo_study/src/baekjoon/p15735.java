package baekjoon;

import java.util.Scanner;

public class p15735 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long init;
		long sum = (long)Math.pow(N, 2);	// 1층 삼각형 갯수
		
		for(int i = 2; i <= N; i++) {	// 2층 삼각형부터 N층 삼각형까지
			init = 1;
			for(int j = i; j <= N; j++) {	// 정방향 삼각형 : 1->3->6->10 (+2,3,4..)
				sum += init;
				init++;
			}
		}
		for(int i = 2; i <= N/2; i++) { // 역방향 삼각형 : N이 4이상인 삼각형만
			init = 1;
			if(N%2 == 1) {	// N이 홀수일 때 3->10->21 
				for(int j = 2; j < 2*i ; j++) {
					sum += init;
					init++;
				}
			}else {		// N이 짝수일 때 1->6->15
				for(int j = 3; j < 2*i ; j++) {
					sum += init;
					init++;
				}
			}
		}
		System.out.println(sum);
	}
}