import java.util.ArrayList;
import java.util.List;

public class ArList {
    public static void main(String[] args) {
       List l= new ArrayList();

       l.add("hello");
       l.add(56);
       l.add(6.6);
       System.out.println(l);

       for(Object e:l){
           System.out.println(e);
       }
        System.out.println(l.isEmpty());
       l.add(0,56);
        System.out.println(l);
       l.set(0,"new");
        System.out.println(l);
        System.out.println(l.size());
        System.out.println(l.get(3));

        List<String> li = new ArrayList<>();
        li.add("Roshan");
        li.add("Virendra");
        li.add("Honey");
        li.add("Sujal");
        li.add("Poornima");
        System.out.println(li);
        li.addLast("Spray");
        System.out.println(li);
        li.remove(3);

        System.out.println(li);


    }
}

