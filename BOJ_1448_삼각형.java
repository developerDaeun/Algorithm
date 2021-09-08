package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1448_삼각형 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {	// N개 빨대 길이 입력
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);	// 오름차순
		
		// 두 변의 길이의 합이 가장 큰 한 변보다 크면 삼각형
		// 앞에서부터 3개의 변 골라서 첫번째 변과 나머지 두 변의 합을 비교, 삼각형이 안되면 다음 변 선택
		int max = -1;
		for(int i = N-1; i > 1; i--) {
			if(arr[i] < arr[i-1] + arr[i-2]) {
				max = arr[i] + arr[i-1] + arr[i-2];
				break;
			}
		}

		System.out.println(max);		
	}
}