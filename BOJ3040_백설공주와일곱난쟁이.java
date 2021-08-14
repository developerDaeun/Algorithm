import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ3040_백설공주와일곱난쟁이 {
	static int[] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[] isSelected;
   
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        arr = new int[9];
        isSelected = new boolean[9];
        
        // 아홉 난쟁이 모자 숫자 입력
        for(int i = 0 ; i < 9; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        comb(0,0,0);
        
        for(int i = 0; i < 7; i++) { // 합이 100인 난쟁이 모자 수 출력
			bw.write(list.get(i) + "\n");
			bw.flush();
		}
        
        bw.close();
	}

	static boolean comb(int start, int cnt, int total) {
		if(cnt==7) { // 7명 난쟁이를 선택했을 때
			if(total == 100) {	// 합이 100인 난쟁이를 찾았을 때
				for(int i = 0; i < 9; i++) {
					if(isSelected[i]) list.add(arr[i]);	// list에 추가
				}
				return true;
			}
			return false;
		}
		
		for(int i = start; i < 9; i++) {
			if(isSelected[i]) continue;	// 선택된 난쟁이이면 continue
			isSelected[i] = true;
			if(comb(i+1, cnt+1, total+arr[i])) return true;	// 재귀
			isSelected[i] = false;
		}
		
		return false;
	}
}