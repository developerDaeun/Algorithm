package baekjoon;

import java.util.Scanner;

public class p2160 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a = 0, b = 0, min = 0;
		int result = Integer.MAX_VALUE;
		char[][] arr = new char[5*N][7];
		String s;
		
		for(int i = 0; i < 5*N; i++) {
			s = sc.next();
			arr[i] = s.toCharArray();
		}
		
		for(int i = 0; i < N-1; i++) {	// 첫번째 그림 갯수
			for(int j = i + 1; j < N; j++) {	// 두번째 그림 갯수
				for(int k = 0; k < 5; k++) {	// row : 5개씩
					for(int r = 0; r < 7; r++) {	// col : 7개씩
						if(arr[(i*5)+k][r] != arr[(j*5)+k][r]) {	// arr[(i*5)+k][r] : 첫번째 그림, arr[(j*5)+k][r] : 두번째 그림
							min++;		// 같지 않은 그림일 때 min 
						}
					}
				}
				if(result > min){	// 가장 작은 수
					a = i;
					b = j;
					result = min;
				}
				min = 0;
			}
		}
		System.out.println(String.format("%d %d", a+1, b+1));
	}
}
