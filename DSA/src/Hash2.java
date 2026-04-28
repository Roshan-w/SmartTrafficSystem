import java.util.*;

public class Hash2 {
    public static void main(String[] args) {

        // 1. Create HashSet
        HashSet<String> set = new HashSet<>();

        // 2. add() - Add elements
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java");   // Duplicate not allowed

        System.out.println("HashSet after add(): " + set);

        // 3. size() - Number of elements
        System.out.println("Size of HashSet: " + set.size());

        // 4. contains() - Check element exists or not
        System.out.println("Contains Java? " + set.contains("Java"));
        System.out.println("Contains Ruby? " + set.contains("Ruby"));

        // 5. remove() - Remove element
        set.remove("C++");
        System.out.println("After remove(): " + set);

        // 6. isEmpty() - Check empty or not
        System.out.println("Is HashSet empty? " + set.isEmpty());

        // 7. iterator() - Traverse elements
        System.out.print("Using Iterator: ");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 8. toArray() - Convert HashSet to Array
        Object[] arr = set.toArray();
        System.out.println("Array elements:");
        for (Object obj : arr) {
            System.out.println(obj);
        }

        // 9. addAll() - Add another collection
        HashSet<String> set2 = new HashSet<>();
        set2.add("Spring");
        set2.add("Hibernate");

        set.addAll(set2);
        System.out.println("After addAll(): " + set);

        // 10. containsAll() - Check all elements exist
        System.out.println("Contains all set2? " + set.containsAll(set2));

        // 11. removeAll() - Remove all elements of another set
        set.removeAll(set2);
        System.out.println("After removeAll(): " + set);

        // 12. retainAll() - Keep only common elements
        HashSet<String> set3 = new HashSet<>();
        set3.add("Java");
        set3.add("Python");

        set.retainAll(set3);
        System.out.println("After retainAll(): " + set);

        // 13. clear() - Remove all elements
        set.clear();
        System.out.println("After clear(): " + set);

        // 14. equals() - Compare two HashSets
        HashSet<String> a = new HashSet<>();
        HashSet<String> b = new HashSet<>();

        a.add("One");
        b.add("One");

        System.out.println("Are both sets equal? " + a.equals(b));

        // 15. hashCode() - Hash code of set
        System.out.println("HashCode of set a: " + a.hashCode());
    }
}