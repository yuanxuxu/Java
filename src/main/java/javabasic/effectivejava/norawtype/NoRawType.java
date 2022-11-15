package javabasic.effectivejava.norawtype;

import java.util.HashSet;
import java.util.Set;

/**
 * While you can pass a List<String> to a parameter of type List,
 * you can’t pass it to a parameter of type List<Object>.
 *
 * There are subtyping rules for generics, and List<String> is a subtype
 * of the raw type List, but not of the parameterized type List<Object>
 * 
 * ?: unbounded wildcard types, Set<?> (read “set of some type”)
 * You can put any element into a collection with a raw type
 * you can’t put any ele- ment (other than null) into a Collection<?>
 * 
 * You must use raw types in class literals. List.class, String[].class
 * List<String>.class and List<?>.class are not legal
 * 
 * instanceof
 * // Legitimate use of raw type - instanceof operator
 * if (o instanceof Set) { // Raw type
 * Set<?> s = (Set<?>) o; // Wildcard type
 * }
 * 
 * diamond operator (<>)
 */
public class NoRawType {

    // unbounded wildcard types
    // Uses unbounded wildcard type - typesafe and flexible
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        return 0;
    }

    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        Set<?> set = s;

    }

}
