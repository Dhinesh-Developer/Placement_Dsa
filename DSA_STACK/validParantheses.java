import java.util.Scanner;
import java.util.Stack;

public class validParantheses {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        boolean res = isValid(s);
        System.out.println(res);

        in.close();

    }

    public static boolean isValid(String s){
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch =='{'){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;
                else{
                    if((ch ==']' && st.pop() != '[') || 
                    (ch == ')' && st.pop() != '(') ||
                     (ch == '}' && st.pop() != '{')){
                        return false;
                     }
                }
            }
        }
        return st.isEmpty();

    }
}
