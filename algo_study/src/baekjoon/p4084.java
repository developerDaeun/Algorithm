package baekjoon;

import java.util.Scanner;

public class p4084 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, d, cnt;
		int abs01, abs02, abs03, abs04;
		while(true){
			cnt = 0;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			if(a==0 && b==0 && c==0 && d==0) {	// 종료
				break;
			}
			if(a == b && b == c && c == d) {	// 처음부터 다 같으면 0 출력하고 끝
				System.out.println(cnt);
			}else {
				while(true) {
					abs01 = Math.abs(a-b);
					abs02 = Math.abs(b-c);
					abs03 = Math.abs(c-d);
					abs04 = Math.abs(d-a);
					if(abs01 == abs02 && abs02 == abs03 && abs03 == abs04) {
						cnt++;		// 처음에 cnt는 0부터 셌으니 1개 부족한 상태
						System.out.println(cnt);
						break;
					}
					a = abs01;
					b = abs02;
					c = abs03;
					d = abs04;
					cnt++;
				}
			}
		}
	}
}