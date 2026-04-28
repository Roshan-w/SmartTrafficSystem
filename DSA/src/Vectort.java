import java.util.Vector;

public class Vectort {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        System.out.println(v.capacity());
        //capacity updated by 10
        v.addFirst(5);
        v.add(24);
        System.out.println(v);
        v.set(0,44);
        System.out.println(v);
        System.out.println(v.get(0));
        System.out.println(v.elementAt(0));
        System.out.println((v.isEmpty()));
        v.removeAll(v);
        v.add(20);
        v.add(20);
        v.add(20);
        v.add(20);
        v.add(20);
        v.add(20);
        v.removeElement(20);
        v.removeElementAt(1);

        System.out.println(v.size());




    }
}
