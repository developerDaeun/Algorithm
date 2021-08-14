package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10972_다음순열 {

	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextPermutation()) {
			for(int i = 0; i < arr.length; i++) {
				bw.write(arr[i] + " ");
			}
		}else {	// 마지막 순열이면 -1
			bw.write("-1");
		}
		
		bw.close();
	}
	
	static boolean nextPermutation() {
		int i = N-1;
		
		// 꼭대기 i부터 왼쪽으로 올라가다가 작아지는 위치(i-1)를 찾으면 stop
		while(i>0 && arr[i-1] >= arr[i]) {	
			--i;
		}
		
		// 꼭대기 i가 0이면 마지막 순열이므로 -1 출력
		if(i==0) {
			return false;
		}
		
		// i-1과 교환할 큰값을 N-1부터 찾기
		int j = N-1;
		while(arr[i-1] >= arr[j]) {
			--j;
		}
		
		// i-1과 j 교환
		swap(i-1, j);
		
		// 꼭대기 i의 뒤부터 맨 뒤까지 오름차순
		int k = N-1;
		while(i < k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}