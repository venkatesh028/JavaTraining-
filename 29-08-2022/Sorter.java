import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * gives the name in alphabetical order & reverse order
 * using inbuilt method of list 
 *
 * @version 1.0 29 Aug 2022
 * @author Venkatesh TM  
 */
public class Sorter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Mango");
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");        
        Collections.sort(list);        
        ListIterator<String> fruits = list.listIterator();
        
        System.out.println("Alphabetical Order");
        while(fruits.hasNext()) {
            System.out.println(fruits.next());
        }
        
        System.out.println("\nReverse order");
        while(fruits.hasPrevious()) {
            System.out.println(fruits.previous());
        }
    }
}