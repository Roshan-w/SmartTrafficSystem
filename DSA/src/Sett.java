import java.util.*;

public class Sett {
    public static void main(String[] args) {


        HashSet<String> s1 = new HashSet<>();
        s1.add("56");
        s1.add("45");
        s1.add("56");
        System.out.println(s1);
        Object[] arr = s1.toArray();

        HashSet<String> s2 = new HashSet<>();
        s2.add("Hey");
        s2.add("java");

        s1.equals(s2);
        System.out.println(s1.hashCode());


    }
}
