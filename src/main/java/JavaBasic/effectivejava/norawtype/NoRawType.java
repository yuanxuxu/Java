package JavaBasic.effectivejava.norawtype;

import java.util.HashSet;
import java.util.Set;

/**
 * While you can pass a List<String> to a parameter of type List,
 * you can’t pass it to a parameter of type List<Object>.
 *
 * There are sub- typing rules for generics, and List<String> is a subtype
 * of the raw type List, but not of the parameterized type List<Object>
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
