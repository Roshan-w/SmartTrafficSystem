import java.util.*;

public class Queuet {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(null);
        System.out.println(q);
        q.offer(80);
        q.offer(80);
        System.out.println(q);

        q.poll();
        System.out.println(q.peek());
         //System.out.println(q.isFull());

    }
}
