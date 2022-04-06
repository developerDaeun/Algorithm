public class CS_shapeArea {
    public static void main(String[] args) {

        System.out.println(solution(3));

    }

    static int solution(int n) {
        int area = 1;

        for (int i = 1; i <= n; i++) {
            area += ((i - 1) * 4);
        }

        return area;
    }
}
