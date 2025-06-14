import java.util.Stack;

public class Solve {

    private static int pow(int a, int b) {
        if (b == 0) return 1;
        else if (b % 2 == 0) {
            int t = pow(a, b / 2);
            return t * t;
        } else return a * pow(a, b - 1);
    }

    private static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((c == '(') || (c == '[') || (c == '{')) {
                st.push(c);
            } else {
                if (st.empty()) return false;
                if ((c == ')') && st.peek().equals((Character) '(')) {
                    st.pop();
                    continue;
                }
                if ((c == ']') && st.peek().equals((Character) '[')) {
                    st.pop();
                    continue;
                }
                if ((c == '}') && st.peek().equals((Character) '{')) {
                    st.pop();
                    continue;
                }
                return false;
            }
        }
        return st.empty();
    }

    private static int pow2(int a, int b) {
        Stack<State> st = new Stack<>();
        st.push(new State(a, b, 0));
        int ret = 0;
        while (!st.empty()) {
            a = st.peek().a();
            b = st.peek().b();
            int pos = st.peek().st();
            st.pop();
            if (pos == 0) {
                if (b == 0) {
                    ret = 1;
                    continue;
                }
                if (b % 2 == 0) {
                    st.push(new State(a, b, 1));
                    st.push(new State(a, b / 2, 0));
                } else {
                    st.push(new State(a, b, 2));
                    st.push(new State(a, b - 1, 0));
                }
                continue;
            } else if (pos == 1) {
                ret *= ret;
                continue;
            } else {
                ret *= a;
                continue;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 10));
        System.out.println(pow2(2, 10));
        System.out.println(check("(){}[]{(())}[]"));
    }
}
