import java.util.Scanner;

public class 가짜동전찾기 {
	
	public static void main(String[] args) {
		// 테케
		// 0 1 1 1 1  1 1 1 1 1  1 1 1 1 1  1 1 1 1 1  1 1 1 1
		// 1 1 1 1 1  1 1 1 1 1  1 1 1 1 1  1 1 1 1 1  1 1 1 0
		// 1 1 1 1 1  1 1 1 1 1  1 1 0 1 1  1 1 1 1 1  1 1 1 1
		Scanner sc = new Scanner(System.in);
		
		int N = 24;	// 총 동전 수 24개로 고정
		
		int[] arr = new int[N];	// 24개 동전 배열 만들기
		for (int i = 0; i < arr.length; i++) {	// 가짜동전 포함한 동전 24개 입력
			arr[i] = sc.nextInt();
		}
		
		System.out.println(binarySearch(arr, 0, arr.length-1));
		
	}

	static int binarySearch(int[] arr, int start, int end) {
		int total = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			if(arr[mid]==0) {// 절반의 위치에 가짜 동전이 있으면 그 위치 리턴
				return mid;
			}
			for(int i = start; i <= mid-1; i++) {	// arr의 왼쪽 반의 합 구하기
				total+=arr[i];
			}
			
			if(total != mid-start) {	// 왼쪽 반에서 가짜 동전이 있으면 왼쪽 반 검색
				return binarySearch(arr, start, mid-1);
			}else {		// 오른쪽 반에서 가짜 동전이 있으면 오른쪽 반 검색
				return binarySearch(arr, mid+1, end);
			}
		}
		
		return -1;	// 가짜동전 못 찾으면 -1 리턴 (그럴일 없다는 전제조건이 있긴 함..)
	}
}
