import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2470_두용액 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        int left = 0, right = N - 1;
        int ans1 = arr[left], ans2 = arr[right];   // 정답 값
        int sum = ans1 + ans2;  // 두 수를 더한 값
        int min = Math.abs(sum);    // 두 수를 더한 값 중 최소값
        while (left + 1 < right) {
            if (sum == 0) break; // 두 수의 합이 0이면 break
            else if (sum < 0) left++;  // 두 수의 합이 0보다 작으면 왼쪽을 크게 만들어야하므로 + 1
            else right--;    // 두 수의 합이 0보다 크면 오른쪽을 작게 만들어야하므로 - 1

            sum = arr[left] + arr[right];   // 변경된 두 수를 더한 값
            if (min > Math.abs(sum)) {  // min 보다 sum의 절대값이 더 작을때 min, 정답값 변경
                min = Math.min(min, Math.abs(sum));
                ans1 = arr[left];
                ans2 = arr[right];
            }
        }

        System.out.print(ans1 + " " + ans2);
    }
}