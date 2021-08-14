package baekjoon;

import java.util.Scanner;

public class p4848 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String s;
		StringBuilder[] result = new StringBuilder[16];
		char[] c;
		int sum = 0;	// 두 수의 합
		int open = 0;
		int cnt = 0;

		for(int i = 0; i < 16; i++) {	// StringBuilder 초기화
			result[i] = new StringBuilder("");
		}
		result[0].append("{}");
		result[1].append("{{}}");
		result[2].append("{{},{{}}}");
		for(int i = 3; i < 16; i++) {	// 0~15까지 {} 넣기
			result[i].append("{");
			for(int j = 0; j < i; j++) {
				result[i].append(result[j]).append(",");
			}
			result[i].deleteCharAt(result[i].lastIndexOf(","));	// 불필요한 마지막 문자 "," 제거
			result[i].append("}");
		}
		for(int t = 0; t < T; t++) {	// 테케
			sum = 0;
			for(int i = 0; i < 2; i++) {	// sum = 두 수의 합 구하기
				cnt = 0;
				open = 0;
				s = sc.next();
				c = s.toCharArray();
				for(int j = 0; j < c.length; j++) {		// 10진수 값 구하기
					if(c[j] == '{') {
						open++;
					}
				}
				while(open!=1) {		// 2의 몇승인지 구하기 (ex. 2의 3승개의 '{'가 있으면 그 숫자는 3)
					open = open / 2;
					cnt++;
				}
				sum += cnt;
			}
			System.out.println(result[sum]);
		}
	}
}