import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// 라운드 수
		
		int num1, num2;	// 어린이마다 딱지 모양 개수
		int[] arr1, arr2;	// 모양 개수 저장 배열
		
		for(int n = 0; n < N; n++) {
			// 어린이 A
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			arr1 = new int[5];
			for(int i = 0; i < num1; i++) {
				arr1[Integer.parseInt(st.nextToken())]++;	// 어린이 A의 각 모양별로 개수 세기
			}
			
			// 어린이 B
			st = new StringTokenizer(br.readLine());
			num2 = Integer.parseInt(st.nextToken());
			arr2 = new int[5];
			for(int i = 0; i < num2; i++) {
				arr2[Integer.parseInt(st.nextToken())]++;	// 어린이 B의 각 모양별로 개수 세기
			}
			
			char win = 0;
			for(int i = 4; i > 0; i--) {	// 별->동그라미->네모->세모 순으로 개수 비교
				if(arr1[i] > arr2[i]) { // 어린이 A의 개수가 더 많을때
					win = 'A';
					break;
				}else if(arr1[i] < arr2[i]) {	// 어린이 B의 개수가 더 많을때
					win = 'B';
					break;
				}else {	// 개수가 같을 때 => 마지막까지 같으면 무승부
					win = 'D';
				}
			}
			
			sb.append(win).append("\n");
		}
		
		System.out.println(sb);
	}
}