package javabasic.effectivejava.listoverarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Arrays differ from generic types in two important ways.
 * First, arrays are covariant. This scary-sounding word means simply that
 * if Sub is a subtype of Super, then the array type Sub[] is a subtype of
 * the array type Super[].
 * 
 * Generics, by contrast, are invariant: for any two distinct types Type1 and
 * Type2, List<Type1> is neither a subtype nor a supertype of List<Type2>
 * 
 * The second major difference between arrays and generics is that
 * arrays are reified
 * This means that arrays know and enforce their element type at runtime
 * 
 * Generics, by contrast, are implemented by erasure
 * This means that they enforce their type constraints only at compile time
 * and discard (or erase) their element type information at runtime.
 * 
 * Because of these fundamental differences, arrays and generics do not mix
 * well.
 * For example, it is illegal to create
 * an array of a generic type, a parameterized type, or a type parameter.
 * new List<E>[], new List<String>[], new E[]
 * 
 * All will result in generic array creation errors at compile time.
 */
public class ListOverArray {
    public static void main(String[] args) {
        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException

        // Won't compile!
        // List<Object> ol = new ArrayList<Long>();
        // ol.add("I don't fit in"); // Incompatible types
    }
}