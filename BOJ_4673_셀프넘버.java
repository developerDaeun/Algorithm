public class BOJ_4673_셀프넘버 {

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		boolean[] arr = new boolean[10001];
		
		String temp;
		for(int i = 1; i <= 10000; i++) {
			int sum = i;
			temp = Integer.toString(i);
			for(int j = 0; j < temp.length(); j++) {
				sum += temp.charAt(j) - '0';
			}
			if(sum <= 10000 && sum >= 1)
				arr[sum] = true;
		}
		
		for(int i = 1; i <= 10000; i++) {
			if(arr[i]==false) {
				sb.append(i+"\n");
			}
		}
		
		System.out.println(sb);
	}
}