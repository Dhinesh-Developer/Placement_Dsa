import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] res = findDailyTemperature(arr);
        System.out.println(Arrays.toString(res));

        in.close();
    }

    private static int[] findDailyTemperature(int[] arr) {

        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[i] = st.peek() - i;
            } else {
                res[i] = 0;
            }

            st.push(i);
        }

        return res;
    }
}