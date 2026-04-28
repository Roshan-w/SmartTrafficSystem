import java.util.Stack;

public class Stackt {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(5);
        System.out.println(s);
        s.push(32);
        s.push(32);
        s.push(32);
        s.push(32);
        s.push(32);
        s.push(32);
        s.push(32);
        s.push(32);
        s.push(32);
        s.push(32);

        System.out.println(s);
        System.out.println(s.pop());
        s.pop();
        s.push(null);
        //System.out.println(s.remove(0)); -- Do not use this method in  stack as stack is filo
        System.out.println(s);
        System.out.println(s.capacity());
    }
}
