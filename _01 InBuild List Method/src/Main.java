import java.util.*;
public class
Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.addFirst(7);
        list.addFirst(8);
        list.addFirst(9);
        list.addFirst(10);
        System.out.println(list);

        list.addLast(777);
        list.add(9999); // if we write "add" it means add at Last
        System.out.println(list);


        System.out.println("-----------------------------------");
        System.out.println(list.size());         // 4
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("null");
        System.out.println("-----------------------------------");


        list.removeFirst();
        list.removeLast();
        list.remove(); // removes the head (first element) of this list.
        System.out.println(list);
    }
}