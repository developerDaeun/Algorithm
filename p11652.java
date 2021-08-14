package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p11652 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long here;
		long[] card = new long[N];	// 입력받은 카드 정수
		int[] cnt = new int[N];	// 각 숫자마다 갯수 세기
		int count = 0;
		long result = 0;
		long max = Integer.MIN_VALUE;	// 최대 갯수를 가진 정수 저장

		for(int i = 0; i < N; i++) {
			card[i] = sc.nextLong();
		}
		Arrays.sort(card);	// 오름차순 정렬
		
		here = card[0];
		for(int i = 1; i < N; i++) {	// 카드 개수 세기
			if(here != card[i]) {	// 같은 숫자인 경우 첫번째 인덱스에만 갯수 들어가있음
				count = i;
				here = card[i];
			}else {
				cnt[count]++;
			}
		}
		
		for(int i = 0; i < N; i++) {	// 최대 갯수를 가진 정수 저장
			if(card[i] == 0) continue;
			if(max < cnt[i]) {
				max = cnt[i];
				result = card[i];
			}
		}
		System.out.println(result);
	}
}