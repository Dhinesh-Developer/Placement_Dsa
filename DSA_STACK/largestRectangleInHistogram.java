// import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class largestRectangleInHistogram {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int res = largestRectangle(arr);
        System.out.println(res);

        in.close();

    }

    private static int largestRectangle(int[] arr) {    
        int n = arr.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<=n;i++){
            int h = (i==n)?0:arr[i];
            while(!st.isEmpty() && h < arr[st.peek()]){
                int height = arr[st.pop()];
                int width = st.isEmpty()? i: st.peek()-1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        return maxArea;
    }
}
