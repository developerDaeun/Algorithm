import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3052_나머지 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 42로 나눈 나머지를 구하고, 서로 다른값이 몇개인지 출력
		// 41이 최대 나머지이므로 0~41 배열 생성
		int[] arr = new int[42];
		
		int temp = 0, total = 0;
		for (int i = 0; i < 10; i++) {
			temp = Integer.parseInt(br.readLine()) % 42;
			if(arr[temp] == 0) {
				arr[temp] = 1;
				total++;
			}
		}
		
		System.out.println(total);
	}
}