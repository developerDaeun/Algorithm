public class CS_adjacentElementsProduct {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 6, -2, -5, 7, 3}));
    }

    static int solution(int[] inputArray) {

        int max = -1000000;

        for (int i = 0; i < inputArray.length - 1; i++) {
            max = Math.max(max, inputArray[i] * inputArray[i + 1]);
        }

        return max;
    }
}
