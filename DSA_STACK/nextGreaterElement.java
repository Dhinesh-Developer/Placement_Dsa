

import java.util.*;
public class nextGreaterElement{
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        int[] res = nge(arr);
        System.out.println(Arrays.toString(res));

        in.close();
    }

    public static int[] nge(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i] = st.peek();
            }

            st.push(arr[i]);
        }
        return res;
    }
}