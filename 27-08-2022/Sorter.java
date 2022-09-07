import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Sorter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Mango");
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");        
        Collections.sort(list);        
        Iterator<String> fruits = list.iterator();
        
        while(fruits.hasNext()) {
            System.out.println(fruits.next());
        }
        
        while(fruits.hasPrevious()) {
            System.out.println(fruits.previous());
        }
    }
}