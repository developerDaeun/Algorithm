import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_7983_내일할거야 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 과제 개수
        int[][] arr = new int[N][2];
        String[] s;
        for(int i = 0; i < N; i++){
            s = br.readLine().split(" ");
            int day = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            arr[i][0] = arr[i][1] - day + 1;
        }

        // 끝 시간 기준으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int max = 0;
        int here = arr[N - 1][0];
        for(int i = N - 2; i >= 0; i--){
            if(arr[i][1] >= here){
                int day = arr[i][1] - arr[i][0];
                arr[i][1] = here - 1;
                arr[i][0] = arr[i][1] - day;
            }else{
                max = Math.max(max, here - arr[i][1] - 1);
            }
            here = arr[i][0];
        }

        max = Math.max(max, arr[0][0] - 1);
        System.out.print(max);
    }
}