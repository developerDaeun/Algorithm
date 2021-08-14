package baekjoon;

import java.util.Scanner;

public class p14492 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] A = new int[N][N];
		int[][] B = new int[N][N];
		int result = 0;
		
		for(int i = 0; i < N; i++) {	// A 행렬 입력
			for(int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < N; i++) {	// B 행렬 입력
			for(int j = 0; j < N; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < N; i++) {	// A 행렬 가로 읽기
			for(int k = 0; k < N; k++) {	// B 행렬 세로 읽기
				for(int j = 0; j < N; j++) {	// B 행렬 세로 하나씩 읽기
					if(A[i][j] == 1 && B[j][k] == 1) {	// 둘다 1이면 1
						result++;
						break;
					}
				}
			}
		}
		System.out.println(result);
	}

}
