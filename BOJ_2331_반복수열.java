import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BOJ_2331_반복수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		ArrayList<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();	// 중복 숫자 찾기
		
		list.add(s[0]);
		set.add(s[0]);
		
		int idx = 0;
		while(true) {
			String temp = list.get(list.size()-1);
			
			int num = 0;
			for(int i = 0; i < temp.length(); i++) {
				char c = temp.charAt(i);
				num += Math.pow(c - '0', Integer.parseInt(s[1]));
			}
			
			String ss = "";
			
			list.add(ss + num);

			// 중복 숫자가 집합 안에 있으면 반복수열의 시작이므로
			// 인덱스(반복 제외 숫자 개수) 구하기
			if(set.contains(list.get(list.size()-1))) {
				idx = list.indexOf(list.get(list.size()-1));
				break;
			}
			
			set.add(list.get(list.size()-1));
		}
		
		System.out.println(idx);
	}
}