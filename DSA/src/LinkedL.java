import java.util.LinkedList;
import java.util.List;

public class LinkedL {
    public static void main(String[] args) {
        LinkedList<String> ll=new LinkedList<>();
        ll.add("hello");
        ll.add("apple");
        ll.add("hey");
        //ll.removeLast();
        ll.add("vire");
        ll.add("world");
        System.out.println(ll.isEmpty());
        System.out.println(ll);
        System.out.println(ll.size());
        System.out.println(ll.get(3).getClass());

    }
}
