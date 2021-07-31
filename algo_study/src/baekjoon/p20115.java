package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p20115 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Long[] drinks = new Long[N];
		
		for(int i = 0; i < N; i++) {	// 드링크 개수만큼 드링크 양 입력받기
			drinks[i] = sc.nextLong();
		}
		Arrays.sort(drinks, Collections.reverseOrder());	// 내림차순
		
		double sum = drinks[0];
		for(int i = drinks.length - 1; i  > 0; i--) {
			sum += (double)drinks[i] / 2.0;
		}
		System.out.println(sum);
	}
}