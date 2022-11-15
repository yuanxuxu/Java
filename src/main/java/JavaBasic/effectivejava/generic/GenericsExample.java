package javabasic.effectivejava.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// https://youtu.be/K1iu1kXkVoA

public class GenericsExample {

    public static void main(String[] args) {
        // it become an issue when you try to print String, Double
        IntegerPrinter printer = new IntegerPrinter(23);
        printer.print();

        Printer<Integer> printerInt = new Printer<>(23);
        printerInt.print();

        Printer<Double> printDouble = new Printer<>(32.0);
        printDouble.print();

        GenericsExample.shout("Shout", "Done");
        GenericsExample.shout(12, 2);

        List<Object> listObj = Arrays.asList(3.2, 4.1);
        List<Number> listNum = Arrays.asList(3, 4.9);
        List<Integer> listIn = Arrays.asList(1, 2);
        printList(listObj);
        printList(listNum);
        printList(listIn);
    }

    // <T, V> tell java it is a generic type
    private static <T, V> T shout(T thingtoShout, V otherThingToShout) {
        System.out.println(thingtoShout + "!!!" + otherThingToShout);
        return thingtoShout;
    }

    // List<?> is a parent of List<Integer/String>
    // List<Object> is not
    // <? super Integer>, Integer, Number, Object
    private static void printList(List<? super Integer> myList) {
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
